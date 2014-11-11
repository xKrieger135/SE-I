package lernkarte;

import antwort.IAntwortVerwaltung;
import persistenz.IPersistenzServices;
import user.INutzerVerwaltung;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenVerwaltungsKomponente {
    private IAntwortVerwaltung antwortVerwaltung;
    private INutzerVerwaltung nutzerVerwaltung;

    public LernkartenVerwaltungsKomponente(IPersistenzServices persistenzServices, IAntwortVerwaltung antwortVerwaltung) {
        this.antwortVerwaltung = antwortVerwaltung;
    }
}
