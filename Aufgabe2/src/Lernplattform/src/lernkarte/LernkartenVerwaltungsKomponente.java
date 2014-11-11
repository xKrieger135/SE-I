package lernkarte;

import antwort.IAntwortVerwaltung;
import persistenz.IPersistenzServices;
import user.INutzerVerwaltung;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenVerwaltungsKomponente implements ILernkartenVerwaltung {
    private IAntwortVerwaltung antwortVerwaltung;
    private INutzerVerwaltung nutzerVerwaltung;

    public LernkartenVerwaltungsKomponente(IAntwortVerwaltung antwortVerwaltung, INutzerVerwaltung nutzerVerwaltung) {
        this.antwortVerwaltung = antwortVerwaltung;
        this.nutzerVerwaltung = nutzerVerwaltung;
    }

    @Override
    public Lernkarte erstelleLernkarte() {
        return null;
    }

    @Override
    public Lernkarte aendereLernkarte() {
        return null;
    }

    @Override
    public Modul zeigeModuleVonLernkarteAn() {
        return null;
    }
}
