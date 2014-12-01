package lernkartenVerwaltungsKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements ILernkarte {

    private int lernkartenID;
    private Modul modul;
    private AufgabenArt lernkartenart;

    public Lernkarte() {
        this.lernkartenart = new AufgabenArt();
    }

    public Lernkarte(AufgabenArt art) {
        this.lernkartenart = art;
    }

    @Override
    public IModul getModul() {

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
    public void fuegeAufgabenArtHinzu(AufgabenArt aufgabenArt) {

    }

    @Override
    public void getAufgabenArt() {

    }

    @Override
    public void speichereLernkarte(ILernkarte lernkarte) {

    }



}
