package lernkartenArt;

import antwortAbgabeKomponente.IAntwort;
import lernkartenVerwaltungsKomponente.IFrage;
import lernkartenVerwaltungsKomponente.ILernkarte;

import java.io.File;
import java.util.HashMap;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class MultipleChoice implements IAntwort{
    private File multipleChoice;

    @Override
    public HashMap<IFrage, HashMap<IAntwort, Boolean>> leseFragenUndAntwortenAusDatenbank(ILernkarte lernkarte) {
        return null;
    }
}
