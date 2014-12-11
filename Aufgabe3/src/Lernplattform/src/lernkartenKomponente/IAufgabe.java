package lernkartenKomponente;

/**
 * Created by patrick_steinhauer on 02.12.2014.
 */
public interface IAufgabe {

    /**
     * Diese Methode dient dem hinzufügen von Fragen, z.B. für einen Single Choice Test
     * Wird zur Zeit jedoch nicht benötigt
     * @param frage
     */
    void fuegeFrageHinzu(String frage);

    /**
     * Hier in der Methode ist es möglich Antworten für einen SingleChoice hinzuzufügen.
     * Zur Zeit nicht benötigt
     * @param aufgabenNummer
     * @param antwort
     * @param richtigOderFalsch
     */
    void fuegeAntwortHinzu(int aufgabenNummer, String antwort, boolean richtigOderFalsch);
}
