package main;

import antwort.AntwortAbgabeKomponente;
import antwort.IAntwortVerwaltung;
import lernkarte.ILernkartenVerwaltung;
import lernkarte.LernkartenVerwaltungsKomponente;
import persistenz.IPersistenzServices;
import user.INutzerVerwaltung;
import user.NutzerVerwaltungskomponente;

/**
 * Created by patrick_steinhauer on 11.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        INutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltungskomponente();
        IAntwortVerwaltung antwortVerwaltung = new AntwortAbgabeKomponente(nutzerVerwaltung);
        ILernkartenVerwaltung lernkartenVerwaltung = new LernkartenVerwaltungsKomponente(antwortVerwaltung, nutzerVerwaltung);
    }
}
