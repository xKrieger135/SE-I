package lernkartenVerwaltungsKomponente;

import antwortAbgabeKomponente.IAntwort;
import lernkartenArt.AufgabenArt;

import java.util.HashMap;
import java.util.List;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface ILernkarte {


    ILernkarte erstelleLernkarte(IModul modul);

    void fuegeAufgabenArtHinzu(AufgabenArt aufgabenArt);

    void speichereLernkarte(ILernkarte lernkarte);

    List<ILernkarte> getListeDerLernkarten();

    ILernkarte zeigeLernkarteAn(ILernkarte lernkarte);

    HashMap<IFrage, HashMap<IAntwort, Boolean>>  leseFragenUndAntwortenAusDatenbank(ILernkarte lernkarte);
}
