package lernkarte;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface ILernkartenVerwaltung {
    public Lernkarte erstelleLernkarte();

    public Lernkarte aendereLernkarte();

    public Modul zeigeModuleVonLernkarteAn();
}
