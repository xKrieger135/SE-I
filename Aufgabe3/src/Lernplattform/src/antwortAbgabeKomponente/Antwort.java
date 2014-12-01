package antwortAbgabeKomponente;

import lernkartenArt.AufgabenArt;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Antwort {
    private boolean antwortIstKorrekt=false;
    private AufgabenArt antwort;

    public boolean istAbgegebeneAntwortKorrekt() {

        return antwortIstKorrekt;

    }

    public boolean isAntwortIstKorrekt() {
        return antwortIstKorrekt;
    }

    public void setAntwortIstKorrekt(boolean antwortIstKorrekt) {
        this.antwortIstKorrekt = antwortIstKorrekt;
    }

    public AufgabenArt getAntwort() {
        return antwort;
    }

    public void setAntwort(AufgabenArt antwort) {
        this.antwort = antwort;
    }
}
