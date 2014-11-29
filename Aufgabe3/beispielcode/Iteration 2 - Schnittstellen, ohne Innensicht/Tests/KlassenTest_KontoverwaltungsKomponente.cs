using Anwendungskern;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;

namespace TestBankingSystem
{
    [TestClass]
    public class KlassentestTest_KontoverwaltungsKomponente
    {
        private Konto konto = null;

        public KlassentestTest_KontoverwaltungsKomponente()
        {
        }

        [TestInitialize]
        public void InitializeTest()
        {
            konto = new Konto(new KontoNrTyp(100, 123)) { DispoKredit = 500 };
        }

        [TestMethod]
        public void TesteBuchungenDurchführenSuccess()
        {
            Assert.AreEqual(0, konto.Kontostand);
            
            konto.Buche(100000, "Budget für 2014");
            Assert.AreEqual(100000, konto.Kontostand);
            Assert.AreEqual(1, konto.Buchungen.Count);

            konto.Buche(100, "zweite Buchung");
            konto.Buche(50, "dritte Buchung");
            konto.Buche(-70, "vierte Buchung");
            Assert.AreEqual(4, konto.Buchungen.Count);
            Assert.AreEqual(100080, konto.Kontostand);
            Assert.IsTrue(konto.Buchungen[3].Beschreibung.Contains("vierte Buchung")); // evtl. wegen LoD (Law of Demeter) zu verbessern

            konto.Buche(-100081, "fünfte Buchung");
            Assert.AreEqual(-1, konto.Kontostand);
        }

        [TestMethod]
        public void TesteBuchungenDurchführenDispoAusgenutztSuccess()
        {
            konto.Buche(-500, "Teuer die Currywurst heutzutage.");
        }

        [TestMethod]
        public void TesteBuchungenDurchführenFailWegenÜberzogenemDispo()
        {
            bool exceptionWasThrown = false;
            try
            {
                konto.Buche(-501, "Teuer die Pizza heutzutage.");
            }
            catch (KontoNotGedecktException ex)
            {
                Assert.AreEqual(konto.KontoNummer, ex.Konto.KontoNummer);
                exceptionWasThrown = true;
            }
            Assert.IsTrue(exceptionWasThrown, "KontoNotGedecktException erwartet.");
        }

        [TestMethod]
        [ExpectedException(typeof(KontoNotGedecktException))]
        public void TesteBuchungenDurchführenFailWegenÜberzogenemDispo_Verbessert()
        {
            konto.Buche(-501, "Sehr teuer die Pizza heutzutage.");
        }
    }
}
