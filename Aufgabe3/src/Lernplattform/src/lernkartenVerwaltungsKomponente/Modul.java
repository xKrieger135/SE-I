package lernkartenVerwaltungsKomponente;

import java.util.Collection;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Modul implements IModul{
    private String name;
    private Collection<Lernkarte> lernkarten;

    @Override
    public IModul erstelleModul(String modul) {
        return null;
    }

    @Override
    public List<IModul> getModulListe() {
        return null;
    }

    @Override
    public void speichereModul(IModul modul) {

    }
}
