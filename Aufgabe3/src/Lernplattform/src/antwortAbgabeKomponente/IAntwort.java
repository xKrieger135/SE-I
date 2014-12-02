package antwortAbgabeKomponente;

import lernkartenVerwaltungsKomponente.IFrage;
import lernkartenVerwaltungsKomponente.ILernkarte;
import nutzerVerwaltungsKomponente.INutzerVerwaltung;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface IAntwort {

    IAntwort erstelleAntwort(INutzerVerwaltung nutzerVerwaltung);

    void speichereAntwort(IAntwort antwort);


}
