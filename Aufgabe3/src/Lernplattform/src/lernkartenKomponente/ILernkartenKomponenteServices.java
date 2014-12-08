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
     * @return List<IModul>
     */
    IModul erstelleModul(String modulName, String modulBeschreibung);

    List<IModul> getModulListe();

    List<ILernkarte> getListeDerLernkarten();

    ILernkarte erstelleLernkarte(IModul modul, String lernkartenName, AufgabenTyp aufgabenTyp);

    List<ILernkarte> getListeDerUnkorrigiertenLernkarten();

    int speichereLernkarte(ILernkarte lernkarte);

    ILernkarte getLernkarte(String LernkartenName);


}
