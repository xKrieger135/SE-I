package antwortKomponente;

import nutzerKomponente.INutzer;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AntwortAbgabeKomponente implements IAntwortKomponenteServices {
    private INutzer nutzerVerwaltung;
    public AntwortAbgabeKomponente(INutzer nutzerVerwaltung) {
        this.nutzerVerwaltung = nutzerVerwaltung;
    }
}
