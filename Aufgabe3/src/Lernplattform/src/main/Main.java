package main;

import antwortKomponente.AntwortKomponente;
import antwortKomponente.IAntwortKomponenteServices;
import lernkartenKomponente.ILernkartenKomponenteServices;
import lernkartenKomponente.LernkartenKomponente;
import nutzerKomponente.INutzer;
import nutzerKomponente.INutzerKomponenteServices;
import nutzerKomponente.Nutzerkomponente;
import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 11.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        IPersistenzServices persistenzServices = null;
        IAntwortKomponenteServices iAntwortKomponenteServices = new AntwortKomponente(persistenzServices);
        ILernkartenKomponenteServices iLernkartenKomponenteServices = new LernkartenKomponente(persistenzServices, iAntwortKomponenteServices);
        INutzerKomponenteServices iNutzerKomponenteServices = new Nutzerkomponente(persistenzServices, iLernkartenKomponenteServices, iAntwortKomponenteServices);
    }
}
