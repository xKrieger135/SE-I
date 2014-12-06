package nutzerKomponente;

import lernkartenKomponente.IModul;
import lernkartenKomponente.LernkartenKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Professor extends Nutzer {
    private String name;
    private String vorname;
    private int personalnummer;
    private LernkartenKomponente lernkartenKomponente;

    List<IModul> getModuleFromDB() {
        return lernkartenKomponente.getModulListe();
    }



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

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }
}
