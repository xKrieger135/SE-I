package antwortKomponente;

import nutzerKomponente.INutzer;

/**
 * Created by patrick_steinhauer on 29.11.2014.
 */
public interface IAntwort {

    IAntwort erstelleAntwort(INutzer nutzerVerwaltung);

    void speichereAntwort(IAntwort antwort);


}
