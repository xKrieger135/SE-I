package lernkartenKomponente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Modul implements IModul{
    private String name;
    private List<ILernkarte> lernkarten;

    public Modul() {

    }

    @Override
    public IModul erstelleModul(String modul) {
        return null;
    }

    @Override
    public List<IModul> getModulListe() {
        return null;
    }

    @Override
    public void speichereModul(IModul modul) {
        //Datenbankoperation
    }

    @Override
    public void erstelleLernkarte(ILernkarte lernkarte) {
        lernkarten = new ArrayList<ILernkarte>();
        lernkarten.add(lernkarte);
    }

    @Override
    public List<ILernkarte> getListeDerLernkarten() {
        return lernkarten;
    }

    @Override
    public String zeigeLernkartenInhaltAn(Lernkarte lernkarte) {
        return null;
    }
}
