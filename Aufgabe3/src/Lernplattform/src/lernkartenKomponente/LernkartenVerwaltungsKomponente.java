package lernkartenKomponente;

import antwortKomponente.IAntwortKomponenteServices;
import nutzerKomponente.INutzer;
import persistenz.IPersistenzServices;

import java.util.Collection;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenVerwaltungsKomponente implements ILernkartenKomponenteServices {
    private IAntwortKomponenteServices antwortVerwaltung;
    private INutzer nutzerVerwaltung;
    private Collection<Lernkarte> lernkarte;

    public LernkartenVerwaltungsKomponente(IPersistenzServices persistenzServices, IAntwortKomponenteServices antwortVerwaltung, INutzer nutzerVerwaltung) {
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
