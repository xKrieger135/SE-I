package nutzerKomponente;

/**
 * Created by patrick_steinhauer on 10.12.2014.
 */
public interface INutzerKomponentenDAO {

    /**
     *
     * @param id
     * @return Es wird ein INutzer zurueckgegeben, der eine Lernkarte erstellt hat.
     */
    INutzer getNutzerVonLernkarte(int id);

    /**
     *
     * @return die verbindung für die Datenbank zurzeit noch doppelt und unschön weil der Login in jeder Komponente aufgerufen wird.
     */
    boolean login();
}
