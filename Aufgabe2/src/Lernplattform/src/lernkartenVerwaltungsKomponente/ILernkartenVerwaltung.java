package lernkartenVerwaltungsKomponente;

import lernkartenArt.Lernkartenart;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface ILernkartenVerwaltung {
    public Lernkarte erstelleLernkarte();

    public Lernkarte aendereLernkarte(Lernkartenart lernkartenart);

    public Modul zeigeModuleVonLernkarteAn();
}
