package lernkartenKomponente;

import nutzerKomponente.INutzer;

import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface ILernkartenKomponenteServices {
    /**
     *
     * @param
     * @return IModul
     */
    IModul erstelleModul(IModul modul);

    List<IModul> getModulListe(INutzer nutzerVerwaltung);

    List<ILernkarte> getListeDerLernkarten(IModul modul);

    ILernkarte erstelleLernkarte(ILernkarte lernkarte);

    List<ILernkarte> getListeDerUnkorrigiertenLernkarten(IModul modul);


}
