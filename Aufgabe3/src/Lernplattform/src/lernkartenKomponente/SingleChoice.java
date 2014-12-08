package lernkartenKomponente;

import java.util.HashMap;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class SingleChoice implements IAufgabe {

    HashMap<String, HashMap<String, Boolean>> singleChoice;
    private static SingleChoice instance = null;

    SingleChoice() {
        singleChoice = new HashMap<String, HashMap<String, Boolean>>();
    }

    public static SingleChoice getInstance() {
        if (instance == null) {
            instance = new SingleChoice();
        }
        return instance;
    }

    @Override
    public void fuegeFrageHinzu(String frage) {
        HashMap<String, Boolean> antworten = new HashMap();
        singleChoice.put(frage, antworten);
    }

    public String getKeyFuerFrage(int aufgabenNummer) {
        String gesuchteFrage = "";
        for (String frage : singleChoice.keySet()) {
            if (aufgabenNummer == 1) {
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

    @Override
    public void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch) {
        if (singleChoice.get(getKeyFuerFrage(aufgabenNummer)).containsValue(true) && richtigOderFalsch == true) {
            throw new IllegalArgumentException();
        } else {
            HashMap<String, Boolean> zuGehoerigeFrage = singleChoice.get(getKeyFuerFrage(aufgabenNummer));
            zuGehoerigeFrage.put(antwort, richtigOderFalsch);
        }

        System.out.println(singleChoice.get(getKeyFuerFrage(aufgabenNummer)).containsValue(true));
    }

    @Override
    public String toString() {
        return "SingleChoice{" +
                "singleChoice=" + singleChoice +
                '}';
    }
}
