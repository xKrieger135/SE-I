package lernkartenVerwaltungsKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface IModul {

    /**
     *
     * @param modul
     * @return IModul
     */
    IModul erstelleModul(String modul);

    List<IModul> getModulListe();

    //IModul getModul(String modul);

    void speichereModul(IModul modul);

    void erstelleLernkarte(ILernkarte lernkarte);

    List<ILernkarte> getListeDerLernkarten();

    String zeigeLernkartenInhaltAn(Lernkarte lernkarte);

}
