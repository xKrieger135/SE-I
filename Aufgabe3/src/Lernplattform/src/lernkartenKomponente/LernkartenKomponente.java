package lernkartenKomponente;

import antwortKomponente.IAntwortKomponenteServices;
import com.sun.org.apache.xpath.internal.SourceTree;
import nutzerKomponente.INutzer;
import nutzerKomponente.INutzerKomponenteServices;
import persistenz.IPersistenzServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenKomponente implements ILernkartenKomponenteServices {
    private IAntwortKomponenteServices antwortKomponentenServices;
    private INutzerKomponenteServices nutzer;
    private List<ILernkarte> lernkarte;
    private List<IModul> vorhandeneModule;
    private SingleChoice singleChoice;
    private LernkartenkomponenteDAO lkDAO;

    public LernkartenKomponente(IPersistenzServices persistenzServices, IAntwortKomponenteServices antwortKomponentenServices) {
        this.antwortKomponentenServices = antwortKomponentenServices;
        this.lkDAO = LernkartenkomponenteDAO.getInstance();
    }

    @Override
    public IModul erstelleModul(String modulName, String modulBeschreibung) {
        Modul modul = new Modul();
        modul.setModulName(modulName);
        modul.setModulBeschreibung(modulBeschreibung);
        return modul;
    }

    @Override
    public List<IModul> getModulListe() {

        return lkDAO.getModulListe();
    }

    @Override
    public List<ILernkarte> getListeDerLernkarten() {
        return lkDAO.getListeDerLernkarten();
    }

    @Override
    public ILernkarte erstelleLernkarte(IModul modul, String lernkartenName, AufgabenTyp aufgabenTyp) {
        Lernkarte lernkarte = new Lernkarte();
//        lernkarte.setLernkartenName(lernkartenName);
        return lernkarte;
    }

    @Override
    public List<ILernkarte> getListeDerUnkorrigiertenLernkarten() {
        return null;
    }

    @Override
    public int speichereLernkarte(ILernkarte lernkarte) {

        //TODO JDBC machen speichert lernkarte und gibt einen integer mit der id zurück für den user.
        return 0;
    }

    @Override
    public ILernkarte getLernkarte(String lernkartenName) {
        return lkDAO.getLernkarte(lernkartenName);
    }

    @Override
    public String toString() {
        return "LernkartenKomponente{" +
                "antwortKomponentenServices=" + antwortKomponentenServices +
                ", nutzer=" + nutzer +
                ", lernkarte=" + lernkarte +
                ", singleChoice=" + singleChoice +
                '}';
    }

}
