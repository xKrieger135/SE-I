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
public class NutzerKomponentenTest {

    private IPersistenzServices iPersistenzServices = null;
    private IAntwortKomponenteServices iAntwortKomponenteServices;
    private ILernkartenKomponenteServices iLernkartenKomponenteServices;
    private INutzerKomponenteServices iNutzerKomponenteServices;
    private INutzerKomponentenDAO iNutzerKomponentenDAO;
    private LernkartenkomponenteDAO lkdao;


    @Before
    public void setUp() {
        lkdao = new LernkartenkomponenteDAO(); //LernkartenkomponenteDAO.getInstance();
        iNutzerKomponentenDAO = NutzerKomponentenDAO.getInstance();
        iAntwortKomponenteServices = new AntwortKomponente(iPersistenzServices);
        iLernkartenKomponenteServices = new LernkartenKomponente(iPersistenzServices, iAntwortKomponenteServices);
        iNutzerKomponenteServices = new Nutzerkomponente(iPersistenzServices, iLernkartenKomponenteServices, iAntwortKomponenteServices);
        iNutzerKomponentenDAO.login();
        lkdao.login();
    }

    @Test
    public void testGetUserVonLernkarte() {
        org.junit.Assert.assertEquals("Son-Goku", iNutzerKomponentenDAO.getNutzerVonLernkarte(2).getName());
    }
}
