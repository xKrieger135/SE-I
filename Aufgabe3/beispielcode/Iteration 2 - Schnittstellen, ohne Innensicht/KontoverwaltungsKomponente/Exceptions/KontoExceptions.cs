using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert den fachlichen Fehlerfall, dass ein Konto nicht gefunden wurde.
    /// </summary>
    public class KontoNotFoundException : Exception
    {
        public KontoNrTyp KontoNummer { get; private set; }

        /// <summary>
        /// Repräsentiert den fachlichen Fehlerfall, dass ein Konto nicht gefunden wurde.
        /// </summary>
        /// <param name="konto">Konto, welches nicht gefunden wurde.</param>
        public KontoNotFoundException(KontoNrTyp kontoNummer) : base("Das Konto " + kontoNummer.ToString() + " ist nicht vorhanden.")
    	{
            this.KontoNummer = kontoNummer;
	    }
    }

    /// <summary>
    /// Repräsentiert den fachlichen Fehlerfall, dass ein Konto nicht gedeckt ist.
    /// </summary>
    public class KontoNotGedecktException : Exception
    {
        public Konto Konto { get; private set; }

        /// <summary>
        /// Repräsentiert den fachlichen Fehlerfall, dass ein Konto nicht gedeckt ist.
        /// </summary>
        /// <param name="konto">Konto, welches nicht gedeckt ist.</param>
        /// <param name="dispo">Dispokredit des nicht gedeckten Kontos.</param>
        /// <param name="betrag">Betrag, der versucht wurde, von dem Konto abzubuchen.</param>
        public KontoNotGedecktException(Konto konto, Decimal dispo, Decimal kontostand, Decimal betrag)
            : base("Das Konto " + konto.KontoNummer.ToString() + " ist nicht gedeckt. Es wurde versucht den Betrag " + betrag + " abzubuchen, der aktuelle Kontostand lautet " + kontostand + ", der Dispokredit ist " + dispo + ".")
        {
            this.Konto = konto;
        }
    }
}
