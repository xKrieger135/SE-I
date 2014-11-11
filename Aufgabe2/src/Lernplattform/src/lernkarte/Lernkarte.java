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
