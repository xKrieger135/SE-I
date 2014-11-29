using System;

namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert eine Adress-Entität
    /// </summary>
    public class Adresse
    {
        public virtual string Strasse { get; set; }
        public virtual string Hausnummer { get; set; }
        public virtual string PLZ { get; set; }
        public virtual string Ort { get; set; }

        public Adresse()
        {
        }
 
        public override bool Equals(object obj)
         {   
             if (obj == null)  
                 return false;
             Adresse toCompare = obj as Adresse;
             if (toCompare == null)
                 return false;
             return (this.PLZ == toCompare.PLZ && this.Ort == toCompare.Ort && this.Strasse == toCompare.Strasse && this.Hausnummer == toCompare.Hausnummer);  
         }

         public override int GetHashCode()
         {
             return 0;
         }
    }
}
