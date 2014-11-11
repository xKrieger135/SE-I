package antwort;

import persistenz.IPersistenzServices;
import user.INutzerVerwaltung;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AntwortAbgabeKomponente implements IAntwortVerwaltung{
    private INutzerVerwaltung nutzerVerwaltung;
    public AntwortAbgabeKomponente(INutzerVerwaltung nutzerVerwaltung) {
        this.nutzerVerwaltung = nutzerVerwaltung;
    }
}
