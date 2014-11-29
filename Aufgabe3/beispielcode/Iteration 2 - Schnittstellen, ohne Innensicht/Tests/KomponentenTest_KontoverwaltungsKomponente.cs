using Anwendungskern;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace TestBankingSystem
{
    [TestClass]
    [DeploymentItem("createDatabaseTables.txt")]
    public class KomponentenTest_KontoverwaltungsKomponente
    {
        private static IBuchungsManager buchungsManager = null;
        private static FilialeverwaltungsDummyKomponente filialeDummy = null;

        private static IPersistenceServices persistenceService = null;

        private static readonly string dbConnectionString;

        public KomponentenTest_KontoverwaltungsKomponente()
        {
        }

        static KomponentenTest_KontoverwaltungsKomponente()
        {
            System.Configuration.ConnectionStringSettings connectionSettings = System.Configuration.ConfigurationManager.ConnectionStrings["DatabaseConnection"];
            dbConnectionString = connectionSettings.ConnectionString;
        }

        /// <summary>
        /// Erzeugt die Komponenten-Instanzen und konfiguriert die Objekte
        /// via Dependency Injection.
        /// Erzeugt das Datenbankschema für die Tests.
        /// </summary>
        /// Durch die Angabe des Attributs ClassInitialize() wird eine Methode markiert,
        /// die vor Beginn aller Tests einmal ausgeführt wird.
        [ClassInitialize]
        public static void BuildAndConfigureApplicationComponentsAndCreateDatabase(TestContext testContext)
        {
            // konfiguriere Anwendung (Dependency Injection)
            filialeDummy = new FilialeverwaltungsDummyKomponente();
            buchungsManager = new KontoverwaltungsKomponente(persistenceService, filialeDummy as IFilialeManager);

            // erzeugte das Datenbankschema
            using (MySqlConnection connection = new MySqlConnection(dbConnectionString))
            {
                connection.Open();
                MySqlScript script = new MySqlScript(connection, File.ReadAllText("createDatabaseTables.txt"));
                script.Execute();
            }
        }

        /// <summary>
        /// Erzeugt die Testdaten zu Beginn jedes Tests.
        /// </summary>
        /// Durch die Angabe des Attributs TestInitialize() wird eine Methode markiert,
        /// die vor Beginn jedes einzelnen Tests ausgeführt wird.
        [TestInitialize]
        public void ErzeugeTestdaten()
        {
            using (MySqlConnection connection = new MySqlConnection(dbConnectionString))
            {
                connection.Open();
                MySqlCommand deleteCommands = new MySqlCommand(
                    "DELETE FROM `bank`.`buchungsposition`;" + 
                    "DELETE FROM `bank`.`konto`", connection);
                deleteCommands.ExecuteNonQuery();
                MySqlCommand insertCommands = new MySqlCommand(
                    "INSERT INTO `bank`.`konto` (Id, DispoKredit, Filiale_id, Blz, KontoNummer) VAlUES (1, 500, 1, 100, 123);" +
                    "INSERT INTO `bank`.`konto` (Id, DispoKredit, Filiale_id, Blz, KontoNummer) VAlUES (2, 500, 2, 100, 456);" +
                    "INSERT INTO `bank`.`buchungsposition` (Id, GebuchterBetrag, Beschreibung, Konto_id) VALUES (1, 100000, \"Budget fuer 2015\", 1)", connection);
                insertCommands.ExecuteNonQuery();
            }
        }

        /// <summary>
        /// Löscht alle Testdaten aus der Datenbank
        /// </summary>
        /// Durch die Angabe des Attributs TestCleanup() wird eine Methode markiert,
        /// die zum Ende jedes einzelnen Tests ausgeführt wird.
        [TestCleanup]
        public void CleanupDatabase()
        {
            // hier nicht benötigt
        }

        [TestMethod]
        public void TesteÜberweisungSuccess()
        {
            KontoNrTyp kNrQuellkonto = new KontoNrTyp(100, 123);
            KontoNrTyp kNrZielkonto = new KontoNrTyp(100, 456);
            buchungsManager.Überweise(kNrQuellkonto, kNrZielkonto, 100000, "Überweisung für neues Projekt");
            IKonto quellKonto = buchungsManager.GetKonto(kNrQuellkonto);
            IKonto zielKonto = buchungsManager.GetKonto(kNrZielkonto);
            Assert.AreEqual(0, quellKonto.Kontostand);
            Assert.AreEqual(100000, zielKonto.Kontostand);

            // Teste Zusammenspiel mit Dummy-Komponentenimplementierung
            Assert.AreEqual(1, filialeDummy.AnzahlÜberweisungen[quellKonto.FilialeNr]);
            Assert.AreEqual(1, filialeDummy.AnzahlÜberweisungen[zielKonto.FilialeNr]);
        }

        [TestMethod]
        public void TesteÜberweisungFail()
        {
            KontoNrTyp kNrQuellkonto = new KontoNrTyp(100, 123);
            KontoNrTyp kNrZielkonto = new KontoNrTyp(100, 456);
            bool exceptionWasThrown = false;
            try
            {
                buchungsManager.Überweise(kNrQuellkonto, kNrZielkonto, 100501, "Überweisung für neues Projekt");
            }
            catch (KontoNotGedecktException ex)
            {
                Assert.AreEqual(kNrQuellkonto, ex.Konto.KontoNummer);
                exceptionWasThrown = true;
            }
            Assert.IsTrue(exceptionWasThrown, "KontoNotGedecktException should have been thrown.");
        }

        [TestMethod]
        [ExpectedException(typeof(KontoNotGedecktException))]
        public void TesteÜberweisungFail_Verbessert()
        {
            KontoNrTyp kNrQuellkonto = new KontoNrTyp(100, 123);
            KontoNrTyp kNrZielkonto = new KontoNrTyp(100, 456);
            buchungsManager.Überweise(kNrQuellkonto, kNrZielkonto, 100501, "Überweisung für neues Projekt");
        }
    }
}
