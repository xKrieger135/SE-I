package lernkartenKomponente;

import java.util.HashMap;

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

    public String getKeyFuerFrage(int aufgabenNummer) {
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
        if(singleChoice.get(getKeyFuerFrage(aufgabenNummer)).containsValue(true) && richtigOderFalsch == true) {
            throw new IllegalArgumentException();
        } else {
            HashMap<String, Boolean> zuGehoerigeFrage = singleChoice.get(getKeyFuerFrage(aufgabenNummer));
            zuGehoerigeFrage.put(antwort, richtigOderFalsch);
        }

        System.out.println(singleChoice.get(getKeyFuerFrage(aufgabenNummer)).containsValue(true));
    }

    public static void main(String[] args) {
        SingleChoice single = SingleChoice.getInstance();

        single.fuegeFrageHinzu("Wie heiße ich?");

        single.fuegeAntwortHinzu(1,"Patrick", true);
        single.fuegeAntwortHinzu(1, "Steinhauer", false);


        System.out.println(single.getKeyFuerFrage(1).toString());
    }

    @Override
    public String toString() {
        return "SingleChoice{" +
                "singleChoice=" + singleChoice +
                '}';
    }
}
