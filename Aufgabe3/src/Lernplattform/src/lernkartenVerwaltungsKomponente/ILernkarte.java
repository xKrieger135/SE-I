package lernkartenVerwaltungsKomponente;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface ILernkarte {

    void fuegeAufgabenArtHinzu(AufgabenArt aufgabenArt);

    void getAufgabenArt();

    void speichereLernkarte(ILernkarte lernkarte);

    IModul getModul();


}
