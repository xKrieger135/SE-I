using System;

namespace Anwendungskern
{
    /// <summary>
    /// Diese Schnittstelle stellt die zentrale Geschäftslogik für die Kontenverwaltung zur Verfügung.
    /// </summary>
    public interface IBuchungsManager
    {
        /// <summary>
        /// Diese Operation holt sich die Informationen zu einem Konto.
        /// </summary>
        /// <param name="kontoNummer">Kontonummer der Kontos, für welches die Informationen abgefragt werden sollen.</param>
        /// <returns>Die abgefragten Kontoinformationen. "Null", falls das Konto nicht existiert.</returns>
        IKonto GetKonto(KontoNrTyp kontoNummer);

        /// <summary>
        /// Diese Operation führt eine Überweisung zwischen zwei Konten durch
        /// </summary>
        /// <param name="vonKontoNr">Konto, vom dem der Betrag abgebucht wird.</param>
        /// <param name="nachKontoNr">Konto, auf das der Betrag überwiesen wird.</param>
        /// <param name="betrag">Der zu überweisende Betrag.</param>
        /// <param name="beschreibung">Beschreibung für die Überweisung.</param>
        /// <throw>KontoNotFoundException, falls das Quell- oder Zielkonto nicht vorhanden ist.</throw>
        /// <throw>KontoNotGedecktException, falls das Quellkonto nicht gedeckt ist.</throw>
        void Überweise(KontoNrTyp vonKontoNr, KontoNrTyp nachKontoNr, Decimal betrag, string beschreibung);

        // weitere Operationen (Konto anlegen, auflösen, usw.) ...
    }
}
