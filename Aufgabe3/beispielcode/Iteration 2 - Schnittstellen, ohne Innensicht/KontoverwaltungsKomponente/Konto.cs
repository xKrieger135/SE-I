using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.Contracts;

namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert eine Sicht auf ein Konto
    /// </summary>
    public interface IKonto
    {
        int Id { get; }
        KontoNrTyp KontoNummer { get; }
        int DispoKredit { get; }
        int FilialeNr { get; }

        Decimal Kontostand { get; }
    }

    /// <summary>
    /// Repräsentiert die Konto-Entität
    /// </summary>
    public class Konto : IKonto
    {
        public virtual int Id { get; set; }
        public virtual KontoNrTyp KontoNummer { get; set; }
        public virtual int DispoKredit { get; set; }
        public virtual int FilialeNr { get; set; }

        private IList<Kunde> kunden = new List<Kunde>(); 
        private IList<BuchungsPosition> buchungen = new List<BuchungsPosition>();

        public Konto()
        {
        }

        public Konto(KontoNrTyp kontoNummer)
        {
            this.KontoNummer = kontoNummer;
        }

        public virtual Decimal Kontostand
        {
            get
            {
                Decimal kontostand = 0;
                foreach (BuchungsPosition buchungsPosition in buchungen)
                {
                    kontostand += buchungsPosition.GebuchterBetrag;
                }
                return kontostand;
            }
        }

        public virtual ReadOnlyCollection<BuchungsPosition> Buchungen
        {
            get
            {
                return new ReadOnlyCollection<BuchungsPosition>(buchungen);
            }
        }

        public virtual ReadOnlyCollection<Kunde> Kunden
        {
            get
            {
                return new ReadOnlyCollection<Kunde>(kunden);
            }
        }

        /// <summary>
        /// Verbindet das Konto mit einem neuen Kontobesitzer.
        /// </summary>
        /// <param name="kunde">Der neue Kontobesitzer</param>
        /// <pre>kunde != null</pre>
        public virtual void AddKunde(Kunde kunde)
        {
            Contract.Requires(kunde != null);
            if (!kunden.Contains(kunde))
                kunden.Add(kunde);
        }

        /// <summary>
        /// Bucht den gegebenen Betrag von/auf das Konto.
        /// </summary>
        /// <param name="betrag">Zu buchender Betrag</param>
        /// <param name="beschreibung">Beschreibung der Buchung</param>
        /// <pre>beschreibung != null</pre>
        /// <throw>KontoNotGedecktException, falls das Quellkonto nicht gedeckt ist.</throw>
        public virtual void Buche(Decimal betrag, string beschreibung)
        {
            Contract.Requires(beschreibung != null);

            // prüfe, ob Konto gedeckt ist
            Decimal neuerKontostandTemp = Kontostand + betrag;
            if (neuerKontostandTemp < -DispoKredit)
            {
                throw new KontoNotGedecktException(this, DispoKredit, Kontostand, betrag);
            }

            // Konto ist gedeckt, buche den Betrag
            buchungen.Add(new BuchungsPosition(betrag, DateTime.Now.ToUniversalTime() + " : " + beschreibung));
        }

         public override bool Equals(object obj)
         {   
             if (obj == null)  
                 return false;   
             Konto toCompare = obj as Konto;
             if (toCompare == null)
                 return false;
             return (this.KontoNummer == toCompare.KontoNummer);  
         }

         public override int GetHashCode()
         {
             return 0;
         }
    }
}
