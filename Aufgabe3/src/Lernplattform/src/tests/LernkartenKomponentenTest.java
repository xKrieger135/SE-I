package tests;

import antwortKomponente.AntwortKomponente;
import antwortKomponente.IAntwortKomponenteServices;
import junit.framework.Assert;
import lernkartenKomponente.ILernkartenKomponenteServices;
import lernkartenKomponente.LernkartenKomponente;
import lernkartenKomponente.LernkartenkomponenteDAO;
import nutzerKomponente.INutzerKomponenteServices;
import nutzerKomponente.INutzerKomponentenDAO;
import nutzerKomponente.NutzerKomponentenDAO;
import nutzerKomponente.Nutzerkomponente;
import org.junit.Before;
import org.junit.Test;
import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 07.12.2014.
 */
public class LernkartenKomponentenTest {
    private IPersistenzServices iPersistenzServices = null;
    private IAntwortKomponenteServices iAntwortKomponenteServices;
    private ILernkartenKomponenteServices iLernkartenKomponenteServices;
//    private INutzerKomponenteServices iNutzerKomponenteServices;
    private INutzerKomponentenDAO iNutzerKomponentenDAO;
    private LernkartenkomponenteDAO lkdao;


    @Before
    public void setUp() {
        lkdao = new LernkartenkomponenteDAO(); //LernkartenkomponenteDAO.getInstance();
        iNutzerKomponentenDAO = NutzerKomponentenDAO.getInstance();
                iAntwortKomponenteServices = new AntwortKomponente(iPersistenzServices);
        iLernkartenKomponenteServices = new LernkartenKomponente(iPersistenzServices, iAntwortKomponenteServices);
//        iNutzerKomponenteServices = new Nutzerkomponente(iPersistenzServices, iLernkartenKomponenteServices, iAntwortKomponenteServices);
        iNutzerKomponentenDAO.login();
        lkdao.login();
    }

    @Test
    public void testGetLernkartenFromDatabase() {

        Assert.assertEquals(3, iLernkartenKomponenteServices.getListeDerLernkarten().size());
        Assert.assertTrue(!(iLernkartenKomponenteServices.getListeDerLernkarten().size() > 3));

    }

    @Test
    public void testGetLernkarteFromDatabase() {
        Assert.assertEquals(1, iLernkartenKomponenteServices.getLernkarte("SE-Lernkarte01").getLernkartenNummer());
        Assert.assertEquals("SE-Lernkarte01", iLernkartenKomponenteServices.getLernkarte("SE-Lernkarte01").getLernkartenName());
        Assert.assertEquals("WELCHE FARBE HAT MEINE UNTERHOSE?", iLernkartenKomponenteServices.getLernkarte("SE-Lernkarte01").getLernkartenFrage());
        Assert.assertNotSame("WELCHE FARBE HAT MEINE HOSE?", iLernkartenKomponenteServices.getLernkarte("SE-Lernkarte01").getLernkartenFrage());
    }

    /**
     * Dieser Test funktioniert leider noch nicht ganz weil mein Datenbankschema zu kompliziert war, weswegen ich den Fehler nicht mehr gefunden habe.
     * einen User heraus holen anhand seiner lernkarten id ist jedoch möglich test dafür im nutzerkomponentenTest
     */

    @Test
    public void testGetUserVonlernkarte() {
        Assert.assertEquals("Son-Goku", iLernkartenKomponenteServices.getLernkarte("SE-Lernkarte02").getErsteller().getName());

    }
}
