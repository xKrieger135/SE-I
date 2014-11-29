namespace Anwendungskern
{
    /// <summary>
    /// Repräsentiert die Filiale-Entität
    /// </summary>
    public class Filiale
    {
        public virtual int Nr { get; set; }
        public virtual string Name { get; set; }
        public virtual int AnzahlUeberweisungen { get; set; }

        public Filiale()
        {
            this.AnzahlUeberweisungen = 0;
        }

        /// <summary>
        /// Nimmt eine neue Buchung in die Statistik auf.
        /// </summary>
        public virtual void NeueÜberweisungFürFilialStatistik()
        {
            AnzahlUeberweisungen++;
        }

         public override bool Equals(object obj)
         {   
             if (obj == null)  
                 return false;
             Filiale toCompare = obj as Filiale;
             if (toCompare == null)
                 return false;
             return (this.Nr == toCompare.Nr);  
         }

         public override int GetHashCode()
         {
             return 0;
         }
    }
}
