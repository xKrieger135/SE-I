package lernkartenVerwaltungsKomponente;

import antwortAbgabeKomponente.IAntwort;
import lernkartenArt.AufgabenArt;

import java.util.HashMap;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements ILernkarte{

    private int lernkartenID;


    public Lernkarte() {
        this.lernkartenart = new AufgabenArt();
    }
    public Lernkarte(AufgabenArt art) {
        this.lernkartenart=art;
    }
    private Modul modul;

    private AufgabenArt lernkartenart;

    public Modul getModul() {

        return modul;
    }

    public void setModul(Modul modul) {

        this.modul = modul;
    }

    public AufgabenArt getLernkartenart() {

        return lernkartenart;
    }

    public void setLernkartenart(AufgabenArt lernkartenart) {

        this.lernkartenart = lernkartenart;
    }


    @Override
    public ILernkarte erstelleLernkarte(IModul modul) {
        return null;
    }

    @Override
    public void fuegeAufgabenArtHinzu(AufgabenArt aufgabenArt) {

    }

    @Override
    public void speichereLernkarte(ILernkarte lernkarte) {

    }

    @Override
    public List<ILernkarte> getListeDerLernkarten() {
        return null;
    }

    @Override
    public ILernkarte zeigeLernkarteAn(ILernkarte lernkarte) {
        return null;
    }

    @Override
    public HashMap<IFrage, HashMap<IAntwort, Boolean>> leseFragenUndAntwortenAusDatenbank(ILernkarte lernkarte) {
        return null;
    }
}
