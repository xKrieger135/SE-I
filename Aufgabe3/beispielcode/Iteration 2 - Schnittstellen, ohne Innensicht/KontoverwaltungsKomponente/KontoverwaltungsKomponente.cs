using System;
using MySql.Data.MySqlClient;

namespace Anwendungskern
{
    /// <summary>
    /// Implementiert die Persistenz-Operationen der Konto-Entität.
    /// Diese Klasse ist "internal" d.h. sie kann von außerhalb der Komponente nicht zugegriffen werden.
    /// </summary>
    internal class KontoDAO
    {
        private readonly string dbConnectionString;

        public KontoDAO() {
            System.Configuration.ConnectionStringSettings connectionSettings = System.Configuration.ConfigurationManager.ConnectionStrings["DatabaseConnection"];
            dbConnectionString = connectionSettings.ConnectionString;
        }

        /// <summary>
        /// Aktualisiert eine Konto-Entität in der Persistenz.
        /// </summary>
        /// <param name="konto">Konto, welches aktualisiert werden soll.</param>
        public void UpdateKonto(Konto konto)
        {
            using (MySqlConnection connection = new MySqlConnection(dbConnectionString))
            {
                connection.Open();

                // aktualisiere Kontodaten (Blz und Kontonummer sind der fachliche Schlüssel, Id der technische Schlüssel)
                MySqlCommand updateCommand = new MySqlCommand("UPDATE Konto SET DispoKredit = @0, Filiale_Id = @1 WHERE Id = @2", connection);
                updateCommand.Parameters.Add(new MySqlParameter("0", konto.DispoKredit));
                updateCommand.Parameters.Add(new MySqlParameter("1", konto.FilialeNr));
                updateCommand.Parameters.Add(new MySqlParameter("2", konto.Id));
                updateCommand.ExecuteNonQuery();

                // unschön gelöst: erst alle vorhandenen Buchungspositionen des Kontos löschen und dann alle neu einfügen (s.u.)
                // das geht alles einfacher und besser -> in einer späteren Vorlesung!
                MySqlCommand deleteCommand = new MySqlCommand("DELETE FROM BuchungsPosition WHERE Konto_id = @0", connection);
                deleteCommand.Parameters.Add(new MySqlParameter("0", konto.Id));
                deleteCommand.ExecuteNonQuery();

                // speichere Buschungspositionen
                foreach (BuchungsPosition buchungsPosition in konto.Buchungen)
                {
                    MySqlCommand insertCommand = new MySqlCommand("INSERT INTO BuchungsPosition (GebuchterBetrag, Beschreibung, Konto_id) VALUES (@0, @1, @2)", connection);
                    insertCommand.Parameters.Add(new MySqlParameter("0", buchungsPosition.GebuchterBetrag));
                    insertCommand.Parameters.Add(new MySqlParameter("1", buchungsPosition.Beschreibung));
                    insertCommand.Parameters.Add(new MySqlParameter("2", konto.Id));
                    insertCommand.ExecuteNonQuery();
                }
            }
        }

        /// <summary>
        /// Liest eine Konto-Entität von der Persistenz.
        /// </summary>
        /// <param name="kontoNummer"></param>
        /// <returns></returns>
        public Konto GetKonto(KontoNrTyp kontoNummer)
        {
            Konto konto = null;

            using (MySqlConnection connection = new MySqlConnection(dbConnectionString))
            {
                connection.Open();

                MySqlCommand command = new MySqlCommand("SELECT * FROM Konto WHERE KontoNummer = @0 AND Blz = @1", connection);
                command.Parameters.Add(new MySqlParameter("0", kontoNummer.KontoNummer));
                command.Parameters.Add(new MySqlParameter("1", kontoNummer.Blz));

                // Create new MySqlDataReader object and read data from the command.
                using (MySqlDataReader reader = command.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        konto = new Konto();
                        konto.Id = Int32.Parse(reader["Id"].ToString());
                        konto.KontoNummer = new KontoNrTyp(Int32.Parse(reader["Blz"].ToString()), Int32.Parse(reader["KontoNummer"].ToString()));
                        konto.DispoKredit = Int32.Parse(reader["DispoKredit"].ToString());
                        konto.FilialeNr = Int32.Parse(reader["Filiale_id"].ToString());
                    }
                }

                if (konto != null)
                {
                    command = new MySqlCommand("SELECT * FROM BuchungsPosition WHERE Konto_id = @0", connection);
                    command.Parameters.Add(new MySqlParameter("0", konto.Id));

                    // Create new MySqlDataReader object and read data from the command.
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            konto.Buche(Decimal.Parse(reader["GebuchterBetrag"].ToString()), reader["Beschreibung"].ToString());
                        }
                    }
                }
            }

            return konto;
        }
    }

    /// <summary>
    /// Die Kontoverwaltungskomponente stellt die zentrale Geschäftslogik für die
    /// Kontoverwaltung zur Verfügung.
    /// </summary>
    public class KontoverwaltungsKomponente : IBuchungsManager
    {
        private KontoDAO kontoDAO;
        private IFilialeManager filialeManager;

        public KontoverwaltungsKomponente(IPersistenceServices persistenceService, IFilialeManager filialeManager)
        {
            this.filialeManager = filialeManager;
            this.kontoDAO = new KontoDAO();
        }

        // Regionen können helfen, den Code übersichtlicher zu gestalten.
        #region IBuchungsManager Members

        /// <see cref="IBuchungsManager"/>
        /// Hier verweisen wir an die Dokumentation des Interfaces. Doppelt zu kommentieren wäre sinnlos und ist gefährlich.
        /// Die Komponentenimplementierung delegiert hier nur an die jeweilige Operation des Anwendungsfalls.
        /// Der Benutzer dieser Komponente sieht den Anwendungsfall also nicht direkt, was eine Änderung des inneren
        /// Aufbaus ermöglicht.
        public IKonto GetKonto(KontoNrTyp kontoNummer)
        {
            return kontoDAO.GetKonto(kontoNummer);
        }

        /// <see cref="IBuchungsManager"/>
        public void Überweise(KontoNrTyp vonKontoNr, KontoNrTyp nachKontoNr, decimal betrag, string beschreibung)
        {
            Konto vonKonto = kontoDAO.GetKonto(vonKontoNr);
            if (vonKonto == null)
            {
                throw new KontoNotFoundException(vonKontoNr);
            }
            Konto nachKonto = kontoDAO.GetKonto(nachKontoNr);
            if (nachKonto == null)
            {
                throw new KontoNotFoundException(nachKontoNr);
            }

            try
            {
                // wir buchen die Beträge und weise die Persistenz sofort zum Update an
                vonKonto.Buche(-betrag, beschreibung);
                kontoDAO.UpdateKonto(vonKonto);
                nachKonto.Buche(betrag, beschreibung);
                kontoDAO.UpdateKonto(nachKonto);

                // aktualisiere die Überweisungsstatistiken der Konten
                filialeManager.NeueÜberweisungFürFilialStatistik(vonKonto.FilialeNr);
                filialeManager.NeueÜberweisungFürFilialStatistik(nachKonto.FilialeNr);
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        #endregion
    }
}
