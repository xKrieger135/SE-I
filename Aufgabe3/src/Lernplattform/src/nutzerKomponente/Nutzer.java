package nutzerKomponente;

import lernkartenKomponente.ILernkarte;
import lernkartenKomponente.LernkartenKomponente;

import java.util.List;

/**
 * Created by patrick_steinhauer on 01.12.2014.
 */
public class Nutzer implements INutzer{

    private NutzerKennung nutzerKennung;
    private String name;
    private String vorname;
    private EmailDatentyp email;
    private List<ILernkarte> erstellteLernkarten;
    private LernkartenKomponente lernkartenKomponente;

    public NutzerKennung getNutzerKennung() {
        return nutzerKennung;
    }

    public void setNutzerKennung(NutzerKennung nutzerKennung) {
        this.nutzerKennung = nutzerKennung;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public EmailDatentyp getEmail() {
        return email;
    }

    @Override
    public NutzerKennung getNutzerkennung() {
        return null;
    }

    public void setEmail(EmailDatentyp email) {
        this.email = email;
    }

    public List<ILernkarte> getErstellteLernkarten() {
        return erstellteLernkarten;
    }

    public void setErstellteLernkarten(List<ILernkarte> erstellteLernkarten) {
        this.erstellteLernkarten = erstellteLernkarten;
    }
}
