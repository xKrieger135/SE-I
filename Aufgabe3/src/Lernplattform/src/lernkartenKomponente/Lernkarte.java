package lernkartenKomponente;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements ILernkarte, IAufgabe {

    private int lernkartenID;
    private String lernkartenName;
    private IModul modul;
    private boolean ueberprueft;
    private IAufgabe aufgabenTyp;


    public Lernkarte(String lernkartenName, IModul modul, AufgabenTyp aufgabenTyp) {
        this.lernkartenName = lernkartenName;
        this.modul = modul;
        if (aufgabenTyp == AufgabenTyp.SINGLECHOICE) {
            this.aufgabenTyp = SingleChoice.getInstance();
        }
    }

    public void setModul(Modul modul) {

        this.modul = modul;
    }

    @Override
    public String getLernkartenName() {
        return lernkartenName;
    }

    @Override
    public int getLernkartenNummer() {
        return lernkartenID;
    }

    @Override
    public String zeigeLernkartenInhaltAn() {
        return null;
    }

    @Override
    public void fuegeFrageHinzu(String frage) {
        aufgabenTyp.fuegeFrageHinzu(frage);
    }

    @Override
    public void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch) {
        aufgabenTyp.fuegeAntwortHinzu(aufgabenNummer, antwort, richtigOderFalsch);
    }

    @Override
    public String toString() {
        return "Lernkarte{" +
                "lernkartenID=" + lernkartenID +
                ", lernkartenName='" + lernkartenName + '\'' +
                ", modul=" + modul +
                ", ueberprueft=" + ueberprueft +
                ", aufgabenTyp=" + aufgabenTyp +
                '}';
    }
}
