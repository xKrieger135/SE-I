package antwortKomponente;


import lernkartenKomponente.AufgabenTyp;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Antwort implements IAntwort{
    private boolean antwortIstKorrekt = false;
    private AufgabenTyp antwort;

    public boolean istAbgegebeneAntwortKorrekt() {
        return antwortIstKorrekt;
    }

    public boolean isAntwortIstKorrekt() {
        return antwortIstKorrekt;
    }

    public void setAntwortIstKorrekt(boolean antwortIstKorrekt) {
        this.antwortIstKorrekt = antwortIstKorrekt;
    }

    public AufgabenTyp getAntwort() {
        return antwort;
    }

    public void setAntwort(AufgabenTyp antwort) {
        this.antwort = antwort;
    }

}
