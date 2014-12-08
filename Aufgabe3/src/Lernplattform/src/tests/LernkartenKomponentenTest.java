package tests;

import antwortKomponente.AntwortKomponente;
import antwortKomponente.IAntwortKomponenteServices;
import junit.framework.Assert;
import lernkartenKomponente.ILernkartenKomponenteServices;
import lernkartenKomponente.LernkartenKomponente;
import lernkartenKomponente.LernkartenkomponenteDAO;
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
    private LernkartenkomponenteDAO lkdao;


    @Before
    public void setUp() {
        lkdao = new LernkartenkomponenteDAO();
        iAntwortKomponenteServices = new AntwortKomponente(iPersistenzServices);
        iLernkartenKomponenteServices = new LernkartenKomponente(iPersistenzServices, iAntwortKomponenteServices);
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
}
