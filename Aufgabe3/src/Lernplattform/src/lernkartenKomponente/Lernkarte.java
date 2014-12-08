package lernkartenKomponente;

import nutzerKomponente.INutzer;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lernkarte implements ILernkarte, IAufgabe {

    private int lernkartenID;
    private String lernkartenName;
    private Modul modul;
    private String ueberprueft;
    private String frage;
    private String antwort;
    private INutzer nutzer;
    private IAufgabe aufgabenTyp;
    private AufgabenTyp _aufgabentyp;


//    public Lernkarte(String lernkartenName, IModul modul, AufgabenTyp aufgabenTyp) {
//        this.lernkartenName = lernkartenName;
//        this.modul = modul;
//        if (aufgabenTyp == AufgabenTyp.SINGLECHOICE) {
//            this.aufgabenTyp = SingleChoice.getInstance();
//        }
//    }


    public Lernkarte() {
        if (_aufgabentyp == AufgabenTyp.SINGLECHOICE) {
            this.aufgabenTyp = SingleChoice.getInstance();
        }
    }

    public void setModul(Modul modul) {

        this.modul = modul;
    }

    public int getLernkartenID() {
        return lernkartenID;
    }

    public void setLernkartenID(int lernkartenID) {
        this.lernkartenID = lernkartenID;
    }

    public void setLernkartenName(String lernkartenName) {
        this.lernkartenName = lernkartenName;
    }

    public Modul getModul() {
        return modul;
    }

    public String isUeberprueft() {
        return ueberprueft;
    }

    public void setUeberprueft(String ueberprueft) {
        this.ueberprueft = ueberprueft;
    }

    public IAufgabe getAufgabenTyp() {
        return aufgabenTyp;
    }

    public void setAufgabenTyp(IAufgabe aufgabenTyp) {
        this.aufgabenTyp = aufgabenTyp;
    }

    public String getUeberprueft() {
        return ueberprueft;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public INutzer getNutzer() {
        return nutzer;
    }

    public void setNutzer(INutzer nutzer) {
        this.nutzer = nutzer;
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
    public String getLernkartenFrage() {
        return frage;
    }

    @Override
    public String getLernkartenAntwort() {
        return antwort;
    }


    @Override
    public INutzer getErsteller() {
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
