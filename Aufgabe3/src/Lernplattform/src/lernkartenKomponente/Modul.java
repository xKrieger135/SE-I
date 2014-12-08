package lernkartenKomponente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Modul implements IModul{
    private String modulName;
    private String modulBeschreibung;
    private int modulID;
    private List<ILernkarte> lernkarten;

    public Modul() {

    }

    public int getModulID() {
        return modulID;
    }

    public void setModulID(int modulID) {
        this.modulID = modulID;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public void setModulBeschreibung(String modulBeschreibung) {
        this.modulBeschreibung = modulBeschreibung;
    }

    @Override
    public String getModulName() {
        return modulName;
    }

    @Override
    public int getModulNummer() {
        return modulID;
    }

    @Override
    public String getModulBeschreibung() {
        return modulBeschreibung;
    }

    @Override
    public String toString() {
        return "Modul{" +
                "modulName='" + modulName + '\'' +
                ", modulBeschreibung='" + modulBeschreibung + '\'' +
                ", modulID=" + modulID +
                ", lernkarten=" + lernkarten +
                '}';
    }
}
