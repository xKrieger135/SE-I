package lernkartenVerwaltungsKomponente;

import antwortAbgabeKomponente.IAntwortVerwaltung;
import lernkartenArt.AufgabenArt;
import persistenz.IPersistenzServices;
import nutzerVerwaltungsKomponente.INutzerVerwaltung;

import java.util.Collection;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenVerwaltungsKomponente implements ILernkartenVerwaltung {
    private IAntwortVerwaltung antwortVerwaltung;
    private INutzerVerwaltung nutzerVerwaltung;
    private Collection<Lernkarte> lernkarte;

    public LernkartenVerwaltungsKomponente(IPersistenzServices persistenzServices, IAntwortVerwaltung antwortVerwaltung, INutzerVerwaltung nutzerVerwaltung) {
        this.antwortVerwaltung = antwortVerwaltung;
        this.nutzerVerwaltung = nutzerVerwaltung;
    }

    @Override
    public Lernkarte erstelleLernkarte() {
        return new Lernkarte();
    }

    @Override
    public Lernkarte aendereLernkarte(AufgabenArt neueArt) {
        return new Lernkarte(neueArt);
    }

    @Override
    public Modul zeigeModuleVonLernkarteAn() {
        return null;
    }
}
