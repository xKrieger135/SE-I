package lernkartenKomponente;

import nutzerKomponente.INutzer;

import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface ILernkartenKomponenteServices {

    /**
     *
     * @param modulName
     * @param modulBeschreibung
     * @return Es wird eine Modul zurückgegeben, wenn eins erstellt wurde.
     */
    IModul erstelleModul(String modulName, String modulBeschreibung);

    /**
     *
     * @return Hier wird eine Liste mit vorhandenen Modulen aus der Datenbank zurückgegeben.
     */
    List<IModul> getModulListe();

    /**
     *
     * @return Hier wird eine Liste mit den vorhandenen lernkarten aus der Datenbank zurückgegeben.
     */
    List<ILernkarte> getListeDerLernkarten();

    /**
     *
     * @param modul
     * @param lernkartenName
     * @param aufgabenTyp
     * @return Hier wird eine Lernkarte zurückgegeben, wenn eine erstellt  wurde.
     */
    ILernkarte erstelleLernkarte(IModul modul, String lernkartenName, AufgabenTyp aufgabenTyp);

    /**
     * Noch nicht implementiert.
     * @return Hier soll später eine Liste der unkorrigierten Lernkarten zurückgegeben werden.
     */
    List<ILernkarte> getListeDerUnkorrigiertenLernkarten();

    /**
     *
     * @param lernkarte
     * @return Diese Methode soll später eine erstellte lernkarte in die Datenbank abspeichern.
     */
    int speichereLernkarte(ILernkarte lernkarte);

    /**
     *
     * @param LernkartenName
     * @return Anhand des lernkartennamens soll hier eine Lernkarte zurückgegeben werden.
     */
    ILernkarte getLernkarte(String LernkartenName);


}
