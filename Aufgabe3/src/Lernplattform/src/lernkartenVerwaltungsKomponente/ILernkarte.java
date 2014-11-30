package lernkartenVerwaltungsKomponente;

import antwortAbgabeKomponente.IAntwort;
import lernkartenArt.Lernkartenart;

import java.util.HashMap;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface ILernkarte {
   
    // TODO erstelleLernkarte, paramater modul um dem ein modul zuzuordnen und noch einen string um den lernkartennamen zu definieren
    // TODO speichereLernkarte
    // TODO getListeDerLernkarten
    // TODO zeigeLernkarteAn

    HashMap<IFrage, HashMap<IAntwort, Boolean>>  leseFragenUndAntwortenAusDatenbank(ILernkarte lernkarte);
}
