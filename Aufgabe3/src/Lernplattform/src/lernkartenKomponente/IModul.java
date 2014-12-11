package lernkartenKomponente;

import nutzerKomponente.INutzer;

import java.util.List;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface IModul {
    /**
     *
     * @return Der Modulname wird zurückgegeben.
     */
    String getModulName();

    /**
     *
     * @return Die Modulnummer wird zurückgegeben.
     */
    int getModulNummer();

    /**
     *
     * @return die Modulbeschreibung wird zurükcgegeben.
     */
    String getModulBeschreibung();

    /**
     *
     * @return Für die Textdarstellung der Objekte etc.
     */
    String toString();
}
