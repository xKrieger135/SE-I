package nutzerKomponente;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface INutzer {

    /**
     *
     * @return die Nutzerid wird hier zurückgegeben.
     */
    int getNutzerID();

    /**
     *
     * @return der Name eines nutzers wird hier zurückgegeben.
     */
    String getName();

    /**
     *
     * @return Der vorname einer Person wird hier zurückgegeben.
     */
    String getVorname();

    /**
     *
     * @return Hier wird die Email des Nutzers zurückgegeben.
     */
    EmailDatentyp getEmail();

    /**
     * Hier wird die Nutzerkennung des Nutzers zurückgegeben.
     * @return
     */
    NutzerKennung getNutzerkennung();
}
