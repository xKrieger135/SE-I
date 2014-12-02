package lernkartenKomponente;

import java.util.HashMap;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Lueckentext {
    HashMap<String, HashMap<String, Boolean>> lueckenText;
    //HashMap<String, Boolean>> lueckenText;
    private static Lueckentext instance = null;

    private Lueckentext() {
        lueckenText = new HashMap<String, HashMap<String, Boolean>>();
    }

    public static Lueckentext getInstance() {
        if (instance == null) {
            instance = new Lueckentext();
        }
        return instance;
    }

    public void fuegeTextHinzu(String lueckentextText) {
        HashMap<String, Boolean> antworten = new HashMap();
        lueckenText.put(lueckentextText, antworten);
    }

    public String getKeyFuerFrage(int antwortNummer) {
        String gesuchteFrage = "";
        for(String frage : lueckenText.keySet()) {
            if(antwortNummer == 1) {
                gesuchteFrage = frage;
            } else {
                antwortNummer = antwortNummer - 1;
            }
        }

        return gesuchteFrage;
    }

    public int getAnzahl() {
        return lueckenText.size();
    }

    public void fuegeAntwortHinzu(int antwortNummer, String antwort, boolean richtigOderFalsch) {

        HashMap<String, Boolean> zuGehoerigeFrage = lueckenText.get(getKeyFuerFrage(antwortNummer));
        zuGehoerigeFrage.put(antwort, richtigOderFalsch);

        System.out.println(lueckenText.get(getKeyFuerFrage(antwortNummer)).containsValue(true));
    }

    public static void main(String[] args) {
        Lueckentext lueckenText = Lueckentext.getInstance();

        lueckenText.fuegeTextHinzu("Ich gehe  in die  und habe dort eine Menge Spaß.?");

        lueckenText.fuegeAntwortHinzu(1,"gern", true);
        lueckenText.fuegeAntwortHinzu(1, "Uni", true);


        System.out.println(lueckenText.getKeyFuerFrage(1).toString());
    }
}
