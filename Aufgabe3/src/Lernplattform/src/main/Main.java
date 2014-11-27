package main;

import antwortAbgabeKomponente.AntwortAbgabeKomponente;
import antwortAbgabeKomponente.IAntwortVerwaltung;
import lernkartenVerwaltungsKomponente.ILernkartenVerwaltung;
import lernkartenVerwaltungsKomponente.LernkartenVerwaltungsKomponente;
import persistenz.IPersistenzServices;
import nutzerVerwaltungsKomponente.INutzerVerwaltung;
import nutzerVerwaltungsKomponente.NutzerVerwaltungskomponente;

/**
 * Created by patrick_steinhauer on 11.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        IPersistenzServices persistenzServices = null;
        INutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltungskomponente();
        IAntwortVerwaltung antwortVerwaltung = new AntwortAbgabeKomponente(nutzerVerwaltung);
        ILernkartenVerwaltung lernkartenVerwaltung = new LernkartenVerwaltungsKomponente(persistenzServices, antwortVerwaltung, nutzerVerwaltung);
    }
}
