package lernkartenKomponente;

import nutzerKomponente.INutzer;

import java.util.List;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface IModul {
    String getModulName();

    int getModulNummer();

    String getModulBeschreibung();

    void setModulName(String modulName);

    void setModulNummer(int modulNummer);

    void setModulBeschreibung(String modulBeschreibung);

    String toString();
}
