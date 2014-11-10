package antwort;

import lernkartenArt.Lernkartenart;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Antwort {
    private boolean antwortIstKorrekt;
    private Lernkartenart lerkartenart;

    public boolean istAbgegebeneAntwortKorrekt() {
         boolean ergebnis = false;
        if (antwortIstKorrekt) {
            ergebnis = true;
        }
        return ergebnis;
    }

}
