using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert eine Buchungsposition
    /// </summary>
    public class BuchungsPosition
    {
        public virtual Decimal GebuchterBetrag { get; set; }
        public virtual string Beschreibung { get; set; }

        public BuchungsPosition()
        {
        }

        public BuchungsPosition(Decimal gebuchterBetrag, string beschreibung)
        {
            this.GebuchterBetrag = gebuchterBetrag;
            this.Beschreibung = beschreibung;
        }
    }
}
