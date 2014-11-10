package user;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Assistent {
    private String name;
    private String Vorname;
    private int personalnummer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }
}
