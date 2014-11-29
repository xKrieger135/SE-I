using System;
using System.Collections.Generic;
using System.Linq;

namespace Anwendungskern
{
    /// <summary>
    /// Die FilialeverwaltungsKomponente stellt die zentrale Geschäftslogik für die
    /// Filialeverwaltung zur Verfügung.
    /// </summary>
    public class FilialeverwaltungsDummyKomponente : IFilialeManager
    {
        public Dictionary<int, int> AnzahlÜberweisungen;

        public FilialeverwaltungsDummyKomponente()
        {
            AnzahlÜberweisungen = new Dictionary<int, int>();
        }

        #region IFilialeManager Members

        /// <see cref="IFilialeManager"/>
        /// Hier verweisen wir an die Dokumentation des Interfaces. Doppelt zu kommentieren wäre sinnlos und ist gefährlich.
        /// Die Komponentenimplementierung delegiert hier nur an die jeweilige Operation des Anwendungsfalls.
        /// Der Benutzer dieser Komponente sieht den Anwendungsfall also nicht direkt, was eine Änderung des inneren
        /// Aufbaus ermöglicht.
        public Filiale GetFilialeByNr(int filialNr)
        {
             throw new NotImplementedException();
        }

        /// <see cref="IFilialeManager"/>
        public void NeueÜberweisungFürFilialStatistik(int filialNr)
        {
            if (AnzahlÜberweisungen.Keys.Contains(filialNr) == false)
            {
                AnzahlÜberweisungen.Add(filialNr, 0);
            }
            AnzahlÜberweisungen[filialNr]++;
        }

        /// <see cref="IFilialeManager"/>
        public void UpdateFiliale(Filiale filiale)
        {
             throw new NotImplementedException();
        }

        #endregion
    }
}
