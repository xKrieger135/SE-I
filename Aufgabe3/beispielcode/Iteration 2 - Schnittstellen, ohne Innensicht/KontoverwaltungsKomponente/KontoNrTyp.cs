using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.Contracts;

namespace Anwendungskern
{
    /// <summary>
    /// Fachlicher Datentyp für eine Kontonummer
    /// </summary>
    public struct KontoNrTyp
    {
        public int Blz { get; private set; }
        public int KontoNummer { get; private set; }

        public KontoNrTyp(int blz, int kontoNummer)
            : this()
        {
            Blz = blz;
            KontoNummer = kontoNummer;
        }

        /// <summary>
        /// Konstruiert einen KontoNrTyp.
        /// </summary>
        /// <param name="kontoVerbindung">Kontoverbindungsdaten.</param>
        /// <pre>IsValidFormatKontoVerbindung(kontoVerbindung) == true</pre>
        public KontoNrTyp(string kontoVerbindung)
            : this()
        {
            Contract.Ensures(IsValidFormatKontoVerbindung(kontoVerbindung) == true, "Die Kontoverbindung muss in einem gültigen Format angegeben werden.");

            string[] parts = kontoVerbindung.Split(' ');
            Blz = Int32.Parse(parts[0]);
            KontoNummer = Int32.Parse(parts[1]);
        }

        /// <summary>
        /// Prüft, ob die angegebene Kontoverbindung in einem gültigen Format angegeben wurde ("BLZ<space>KONTONUMMER")
        /// </summary>
        /// <param name="kontoVerbindung">Kontoverbindung, die überprüft werden soll.</param>
        /// <returns>True, falls die Verbindung in einem gültigen Format vorliegt, ansonsten false.</returns>
        public static bool IsValidFormatKontoVerbindung(string kontoVerbindung)
        {
            try
            {
                string[] parts = kontoVerbindung.Split(' ');
                if (parts.Length != 2)
                    return false;

                int dummy = Int32.Parse(parts[0]);
                dummy = Int32.Parse(parts[1]);
            }
            catch (Exception)
            {
                return false;
            }

            return true;
        }

        /// <summary>
        /// Die Überladung des "=="-Operators ermöglicht den Vergleich zweier Kontonummern
        /// </summary>
        /// <param name="kNr1">Erste Kontonummer</param>
        /// <param name="kNr2">Zweite Kontonummer</param>
        /// <returns></returns>
        public static bool operator ==(KontoNrTyp kNr1, KontoNrTyp kNr2)
        {
            return (kNr1.Blz == kNr2.Blz) && (kNr1.KontoNummer == kNr2.KontoNummer);
        }

        public static bool operator !=(KontoNrTyp kNr1, KontoNrTyp kNr2)
        {
            return !(kNr1 == kNr2);
        }

        public override int GetHashCode()
        {
            return 0;
        }

        public override bool Equals(object obj)
        {
            if (obj is KontoNrTyp)
                return this == (KontoNrTyp)obj;
            else
                return false;
        }

        public override string ToString()
        {
            return Blz + "/" + KontoNummer;
        }
    }
}
