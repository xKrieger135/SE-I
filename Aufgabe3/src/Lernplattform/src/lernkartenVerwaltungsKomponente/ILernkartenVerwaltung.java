package lernkartenVerwaltungsKomponente;

import lernkartenArt.AufgabenArt;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface ILernkartenVerwaltung {
    public Lernkarte erstelleLernkarte();

    public Lernkarte aendereLernkarte(AufgabenArt lernkartenart);

    public Modul zeigeModuleVonLernkarteAn();
}
