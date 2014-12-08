package antwortKomponente;

import nutzerKomponente.INutzer;
import nutzerKomponente.INutzerKomponenteServices;
import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AntwortKomponente implements IAntwortKomponenteServices {
    private INutzerKomponenteServices nutzerVerwaltung;
    private IPersistenzServices persistenzServices;
//    public AntwortKomponente(INutzerKomponenteServices nutzerVerwaltung) {
//        this.nutzerVerwaltung = nutzerVerwaltung;
//    }

    public AntwortKomponente(IPersistenzServices persistenzServices) {
        this.persistenzServices = persistenzServices;
    }
}
