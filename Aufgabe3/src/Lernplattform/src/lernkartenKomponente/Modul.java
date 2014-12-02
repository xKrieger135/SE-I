package lernkartenKomponente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Modul implements IModul{
    private String name;
    private List<ILernkarte> lernkarten;

    public Modul() {

    }

    @Override
    public String getModulName() {
        return null;
    }

    @Override
    public int getModulNummer() {
        return 0;
    }

    @Override
    public String getModulBeschreibung() {
        return null;
    }
}
