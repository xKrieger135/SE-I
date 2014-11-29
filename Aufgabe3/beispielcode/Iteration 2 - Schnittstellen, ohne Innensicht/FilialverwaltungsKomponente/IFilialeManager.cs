using System;

namespace Anwendungskern
{
    /// <summary>
    /// Diese Schnittstelle stellt die zentrale Geschäftslogik für die Filialenverwaltung zur Verfügung.
    /// </summary>
    public interface IFilialeManager
    {
        /// <summary>
        /// Diese Operation holt sich die Informationen zu einer Filiale.
        /// </summary>
        /// <param name="filialNr">Schlüssel der Filiale, für welche die Informationen abgefragt werden sollen.</param>
        /// <returns>Die abgefragten Filialinformationen. "Null", falls die Filiale nicht existiert.</returns>
        Filiale GetFilialeByNr(int filialNr);

        /// <summary>
        /// Diese Operation aktualisiert die Überweisungs-Statistik einer Filiale.
        /// </summary>
        /// <param name="filialNr">Technischer Schlüssel der zu aktualisierenden Filiale.</param>
        void NeueÜberweisungFürFilialStatistik(int filialNr);

        /// <summary>
        /// Diese Operation aktualisiert die Filialdaten.
        /// </summary>
        /// <param name="filiale">Filialdaten, die aktualisiert werden sollen.</param>
        void UpdateFiliale(Filiale filiale);
    }
}
