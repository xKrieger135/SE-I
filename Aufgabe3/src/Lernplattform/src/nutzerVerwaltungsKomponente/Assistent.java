package nutzerVerwaltungsKomponente;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Assistent extends Nutzer{

    public void Assistent(String vorName, String nachName, String personalKennung, String email) {
        if (NutzerKennung.isValidKennung(personalKennung) && (EmailDatentyp.isValidEmail(email))) {
            setVorname(vorName);
            setName(nachName);
            setNutzerKennung(new NutzerKennung(personalKennung));
            setEmail(new EmailDatentyp(email));
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Änderung der Nutzerkennung möglich?
    public void setPersonalnummer(NutzerKennung personalNummer) {
        setNutzerKennung(personalNummer);
    }


    public NutzerKennung getPersonalnummer() {
        return getNutzerKennung();
    }

}
