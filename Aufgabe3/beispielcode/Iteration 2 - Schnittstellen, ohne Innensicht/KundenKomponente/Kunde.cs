using System;
using System.Collections.Generic;

namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert die Kunden-Entität
    /// </summary>
    public class Kunde
    {
        public virtual string Nachname { get; set; }
        public virtual string Vorname { get; set; }
        public virtual Adresse Adresse { get; set; }

        public Kunde()
        {
        }

        public override bool Equals(object obj)
         {   
             if (obj == null)  
                 return false;
             Kunde toCompare = obj as Kunde;
             if (toCompare == null)
                 return false;
             return (this.Nachname == toCompare.Nachname && this.Vorname == toCompare.Vorname);  
         }

         public override int GetHashCode()
         {
             return 0;
         }
    }
}
