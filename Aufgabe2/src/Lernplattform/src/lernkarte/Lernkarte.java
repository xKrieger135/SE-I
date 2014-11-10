package lernkarte;

import lernkartenArt.Lernkartenart;
import persistenz.IPersistenzServices;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements IPersistenzServices{
    private Modul modul;
//    Lernkartenart vielleicht als Enum? Ausfzählungstyp, PDF aus Vorlesung.
//    Lernkartenart sonst als Klassen
    private Lernkartenart lernkartenart;

    public Lernkarte(Modul modul, Lernkartenart lernkartenart) {
        this.lernkartenart  = lernkartenart;
        this.modul = modul;
    }

    private Collection<Lernkarte> erstelleLernkarte() {
        Collection<Lernkarte> lernkarte = new ArrayList<Lernkarte>();
        return lernkarte;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    public Lernkartenart getLernkartenart() {
        return lernkartenart;
    }

    public void setLernkartenart(Lernkartenart lernkartenart) {
        this.lernkartenart = lernkartenart;
    }
}
