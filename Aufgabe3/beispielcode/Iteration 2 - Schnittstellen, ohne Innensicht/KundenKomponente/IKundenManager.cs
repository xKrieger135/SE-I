using System;

namespace Anwendungskern
{
    /// <summary>
    /// Exception für den Fall, dass ein Kunde beim Anlegen bereits existiert.
    /// </summary>
    public class KundeAlreadyExistsException : Exception
    {
        public KundeAlreadyExistsException(string nachname)
            : base("Es existiert bereits ein Kunde mit dem Nachnamen '" + nachname + "':")
        {
        }
    }

    /// <summary>
    /// Diese Schnittstelle stellt die zentrale Geschäftslogik für die Kunden- und Adressverwaltung zur Verfügung.
    /// </summary>
    public interface IKundenManager
    {
        /// <summary>
        /// Liefert Informationen zu einem Kunden.
        /// </summary>
        /// <param name="nachname">Der Nachname des Kunden. Dieser muss im System eindeutig sein.</param>
        /// <pre>nachname != null</pre>
        /// <pre>(nachname.Length > 0) &&(nachname.Length < 30)</pre>
        /// <returns>Die Kunden-Entität, falls ein Kunde mit dem übergebenen Nachnamen existiert, ansonsten null</returns>
        Kunde GetKunde(string nachname);

        /// <summary>
        /// Ändert die Daten eines Kunden, inklusive seiner Adresse.
        /// </summary>
        /// <param name="kunde">Der Kunde, dessen Daten geändert werden sollen.</param>
        /// <pre>kunde != null</pre>
        void UpdateKunde(Kunde kunde);

        /// <summary>
        /// Legt einen Kunden an.
        /// </summary>
        /// <param name="nachname">Nachname des Kunden</param>
        /// <pre>nachname != null</pre>
        /// <pre>(nachname.Length > 0) &&(nachname.Length < 30)</pre>
        /// <param name="vorname">Vorname des Kunden</param>
        /// <pre>vorname != null</pre>
        /// <pre>(vorname.Length > 0) &&(vorname.Length < 15)</pre>
        /// <returns>Die erzeugte Kunden-Entität</returns>
        /// <throw>KundeAlreadyExistsException, falls ein Kunde mit diesem Nachnamen bereits in der Persistenz existiert.</throw>
        Kunde CreateKunde(string nachname, string vorname);
    }
}
