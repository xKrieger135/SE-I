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

    public Modul(String modulName, String modulBeschreibung) {
        this.modulName = modulName;
        this.modulBeschreibung = modulBeschreibung;
    }


    @Override
    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    @Override
    public void setModulNummer(int modulNummer) {

    }

    @Override
    public void setModulBeschreibung(String modulBeschreibung) {
        this.modulBeschreibung = modulBeschreibung;
    }

    public void setModulID(int modulID) {
        this.modulID = modulID;
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
