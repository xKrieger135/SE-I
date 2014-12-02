package lernkartenKomponente;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements ILernkarte {

    private int lernkartenID;
    private Modul modul;
    private AufgabenArt aufgabenArt;

    public Lernkarte() {
        this.aufgabenArt = new AufgabenArt();
    }

    public Lernkarte(AufgabenArt art) {
        this.aufgabenArt = art;
    }

    public void setModul(Modul modul) {

        this.modul = modul;
    }

    public AufgabenArt getAufgabenArt() {

        return aufgabenArt;
    }

    public void setAufgabenArt(AufgabenArt aufgabenArt) {

        this.aufgabenArt = aufgabenArt;
    }

    @Override
    public String getLernkartenName() {
        return null;
    }

    @Override
    public int getLernkartenNummer() {
        return 0;
    }

    @Override
    public String getLernkartenArt() {
        return null;
    }

    @Override
    public String zeigeLernkartenInhaltAn() {
        return null;
    }
}
