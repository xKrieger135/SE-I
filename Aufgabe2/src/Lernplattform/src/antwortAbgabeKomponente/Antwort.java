package antwortAbgabeKomponente;

import lernkartenArt.Lernkartenart;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Antwort {
    private boolean antwortIstKorrekt=false;
    private Lernkartenart antwort;

    public boolean istAbgegebeneAntwortKorrekt() {

        return antwortIstKorrekt;

    }

    public boolean isAntwortIstKorrekt() {
        return antwortIstKorrekt;
    }

    public void setAntwortIstKorrekt(boolean antwortIstKorrekt) {
        this.antwortIstKorrekt = antwortIstKorrekt;
    }

    public Lernkartenart getAntwort() {
        return antwort;
    }

    public void setAntwort(Lernkartenart antwort) {
        this.antwort = antwort;
    }
}
