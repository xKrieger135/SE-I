package antwortKomponente;

import nutzerKomponente.INutzer;
import nutzerKomponente.INutzerKomponenteServices;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AntwortKomponente implements IAntwortKomponenteServices {
    private INutzerKomponenteServices nutzerVerwaltung;
    public AntwortKomponente(INutzerKomponenteServices nutzerVerwaltung) {
        this.nutzerVerwaltung = nutzerVerwaltung;
    }
}
