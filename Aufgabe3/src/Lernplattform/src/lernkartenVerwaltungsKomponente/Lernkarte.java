package lernkartenVerwaltungsKomponente;

import lernkartenArt.Lernkartenart;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte {
    public Lernkarte() {
        this.lernkartenart = new Lernkartenart();
    }
    public Lernkarte(Lernkartenart art) {
        this.lernkartenart=art;
    }
    private Modul modul;

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
