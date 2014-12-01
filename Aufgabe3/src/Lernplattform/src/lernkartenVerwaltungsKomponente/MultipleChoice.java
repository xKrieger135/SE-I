package lernkartenVerwaltungsKomponente;

import java.util.HashMap;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class MultipleChoice {
    HashMap<String, HashMap<String, Boolean>> multipleChoice;
    private static MultipleChoice instance = null;

    private MultipleChoice() {
        multipleChoice = new HashMap<String, HashMap<String, Boolean>>();
    }

    public static MultipleChoice getInstance() {
        if (instance == null) {
            instance = new MultipleChoice();
        }
        return instance;
    }

    public void fuegeFrageHinzu(String frage) {
        HashMap<String,Boolean> antworten = new HashMap();
        multipleChoice.put(frage, antworten);
    }

    public String getKeyFuerFrage(int aufgabenNummer) {
        String gesuchteFrage = "";
        for(String frage : multipleChoice.keySet()) {
            if(aufgabenNummer == 1) {
                gesuchteFrage = frage;
            } else {
                aufgabenNummer = aufgabenNummer - 1;
            }
        }

        return gesuchteFrage;
    }

    public int getAnzahl() {
        return multipleChoice.size();
    }

    public void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch) {

            HashMap<String, Boolean> zuGehoerigeFrage = multipleChoice.get(getKeyFuerFrage(aufgabenNummer));
            zuGehoerigeFrage.put(antwort, richtigOderFalsch);

        System.out.println(multipleChoice.get(getKeyFuerFrage(aufgabenNummer)).containsValue(true));
    }

    public static void main(String[] args) {
        MultipleChoice multi = MultipleChoice.getInstance();

        multi.fuegeFrageHinzu("Wie heiße ich?");

        multi.fuegeAntwortHinzu(1,"Patrick", true);
        multi.fuegeAntwortHinzu(1, "Steinhauer", false);


        System.out.println(multi.getKeyFuerFrage(1).toString());
    }
}
