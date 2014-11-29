using System;
namespace Anwendungskern
{
    /// <summary>
    /// Die Kundenkomponente stellt die zentrale Geschäftslogik für die
    /// Kunden- und Adressverwaltung zur Verfügung.
    /// </summary>
    public class KundenverwaltungsDummyKomponente : IKundenManager
    {
        // der einzige Kunde, den unsere Dummy-Komponente verwaltet
        private Kunde kunde = null;

        public KundenverwaltungsDummyKomponente(IPersistenceServices persistenceManager)
        {
            kunde = new Kunde();
            kunde.Vorname = "John";
            kunde.Nachname = "Doe";

            Adresse adresse = new Adresse();
            adresse.Strasse = "Berliner Tor";
            adresse.Hausnummer = "7";
            adresse.PLZ = "20099";
            adresse.Ort = "Hamburg";

            kunde.Adresse = adresse;
        }

        // Regionen können helfen, den Code übersichtlicher zu gestalten.
        #region IKundenManager Members

        /// <see cref="IKundenManager"/>
        /// Hier verweisen wir an die Dokumentation des Interfaces. Doppelt zu kommentieren wäre sinnlos und ist gefährlich.
        /// Die Komponentenimplementierung delegiert hier nur an die jeweilige Operation des Anwendungsfalls.
        /// Der Benutzer dieser Komponente sieht den Anwendungsfall also nicht direkt, was eine Änderung des inneren
        /// Aufbaus ermöglicht.
        public Kunde GetKunde(string nachname)
        {
            if (nachname != "Doe")
            {
                throw new ArgumentException("Komponente unterstützt nur Kunden 'Doe'.");
            }

            return kunde;
        }

        /// <see cref="IKundenManager"/>
        public void UpdateKunde(Kunde kunde)
        {
            throw new NotImplementedException("UpdateFiliale nicht implementiert.");
        }

        /// <see cref="IKundenManager"/>
        public Kunde CreateKunde(string nachname, string vorname)
        {
            throw new NotImplementedException("UpdateFiliale nicht implementiert.");
        }

        #endregion
    }
}
