package lernkartenKomponente;

import nutzerKomponente.INutzer;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface ILernkarte {
    String getLernkartenName();

    int getLernkartenNummer();

    String getLernkartenFrage();

    String getLernkartenAntwort();

    INutzer getErsteller();

    String toString();

}
