package main;

import antwortKomponente.AntwortAbgabeKomponente;
import antwortKomponente.IAntwortKomponenteServices;
import lernkartenKomponente.ILernkartenKomponenteServices;
import lernkartenKomponente.LernkartenVerwaltungsKomponente;
import nutzerKomponente.INutzer;
import nutzerKomponente.Nutzerkomponente;
import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 11.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        IPersistenzServices persistenzServices = null;
        INutzer nutzerVerwaltung = new Nutzerkomponente();
        IAntwortKomponenteServices antwortVerwaltung = new AntwortAbgabeKomponente(nutzerVerwaltung);
        ILernkartenKomponenteServices lernkartenVerwaltung = new LernkartenVerwaltungsKomponente(persistenzServices, antwortVerwaltung, nutzerVerwaltung);
    }
}
