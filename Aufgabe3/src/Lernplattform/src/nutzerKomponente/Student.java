package nutzerKomponente;

import lernkartenKomponente.ILernkarte;
import lernkartenKomponente.IModul;
import lernkartenKomponente.LernkartenKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Student extends Nutzer{
    private String name;
    private String vorname;
    private int matrikelnummer;
    private int semester;
    private EmailDatentyp email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }


}
