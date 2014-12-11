package lernkartenKomponente;

import nutzerKomponente.INutzer;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface ILernkarte {
    /**
     *Diese methode holt sich den namen einer Lernkarte
     * @return
     */
    String getLernkartenName();

    /**
     *
     * @return Hier wird die Lernkartennummer einer bestimmten lernkarte zurückgegeben.
     */
    int getLernkartenNummer();

    /**
     *
     * @return Gibt zu einer bestimmten Lernkarte die Frage zurück.
     */
    String getLernkartenFrage();

    /**
     *
     * @return Gibt zu einer bestimmten Lernkarte die Antwort zurück.
     */
    String getLernkartenAntwort();

    /**
     *
     * @return gibt einen Nutzer zurück, dem die Lernkarte gehört.
     */
    INutzer getErsteller();

    /**
     *
     * @return Text der vorhandenen Objekte etc.
     */
    String toString();

}
