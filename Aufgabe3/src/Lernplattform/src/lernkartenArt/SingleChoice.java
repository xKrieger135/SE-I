package lernkartenArt;

import antwortAbgabeKomponente.IAntwort;
import lernkartenVerwaltungsKomponente.IFrage;
import lernkartenVerwaltungsKomponente.ILernkarte;
import lernkartenVerwaltungsKomponente.IModul;
import lernkartenVerwaltungsKomponente.Lernkarte;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class SingleChoice {

    //HashMap<Integer, HashMap<String, HashMap<String, Boolean>>> singleChoice;
    HashMap<String, HashMap<String, Boolean>> singleChoice;
    private static SingleChoice instance = null;

    private SingleChoice() {
        singleChoice = new HashMap<String, HashMap<String, Boolean>>();
    }

    public static SingleChoice getInstance() {
        if (instance == null) {
            instance = new SingleChoice();
        }
        return instance;
    }

    public void fuegeFrageHinzu(String frage) {
        HashMap<String,Boolean> antworten = new HashMap();
        singleChoice.put(frage, antworten);
    }

    public String getkeyFuerFrage(int aufgabenNummer) {
        String gesuchteFrage = "";
        for(String frage : singleChoice.keySet()) {
            if(aufgabenNummer == 1) {
                gesuchteFrage = frage;
            } else {
                aufgabenNummer = aufgabenNummer - 1;
            }
        }

        return gesuchteFrage;
    }

    public int getAnzahl() {
        return singleChoice.size();
    }

    public void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch) {
        HashMap<String, Boolean> zuGehoerigeFrage = singleChoice.get(getkeyFuerFrage(aufgabenNummer));
        zuGehoerigeFrage.put(antwort, richtigOderFalsch);
    }

    public static void main(String[] args) {
        SingleChoice single = SingleChoice.getInstance();

        single.fuegeFrageHinzu("Wie heiße ich?");

        single.fuegeAntwortHinzu(1,"Patrick", true);


        System.out.println(single.getkeyFuerFrage(1).toString());
    }

    @Override
    public String toString() {
        return "SingleChoice{" +
                "singleChoice=" + singleChoice +
                '}';
    }
}
