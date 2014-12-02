package antwortAbgabeKomponente;

import lernkartenVerwaltungsKomponente.AufgabenArt;
import nutzerVerwaltungsKomponente.INutzerVerwaltung;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Antwort implements IAntwort{
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

    @Override
    public IAntwort erstelleAntwort(INutzerVerwaltung nutzerVerwaltung) {
        return null;
    }

    @Override
    public void speichereAntwort(IAntwort antwort) {

    }
}
