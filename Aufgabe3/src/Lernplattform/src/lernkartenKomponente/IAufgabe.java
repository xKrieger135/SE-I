package lernkartenKomponente;

/**
 * Created by patrick_steinhauer on 02.12.2014.
 */
public interface IAufgabe {

    void fuegeFrageHinzu(String frage);

    void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch);
}
