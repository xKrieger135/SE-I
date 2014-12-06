package nutzerKomponente;

import lernkartenKomponente.ILernkarte;
import lernkartenKomponente.LernkartenKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 01.12.2014.
 */
public class Nutzer {

    private NutzerKennung nutzerKennung;
    private String name;
    private String vorname;
    private EmailDatentyp email;
    private List<ILernkarte> erstellteLernkarten;
    private LernkartenKomponente lernkartenKomponente;

    public void speichereLernkarteMittelsLernkartenIDInDenUser(ILernkarte lernkarte) {
        int lernkartenID = lernkartenKomponente.speichereLernkarte(lernkarte);
        //TODO Mit JDBC die lernkartenid in den user schreiben, damit er die lernkarte kennt
    }

    public NutzerKennung getNutzerKennung() {
        return nutzerKennung;
    }

    public void setNutzerKennung(NutzerKennung nutzerKennung) {
        this.nutzerKennung = nutzerKennung;
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

    public EmailDatentyp getEmail() {
        return email;
    }

    public void setEmail(EmailDatentyp email) {
        this.email = email;
    }
}
