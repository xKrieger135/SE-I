package nutzerKomponente;

import antwortKomponente.IAntwortKomponenteServices;
import lernkartenKomponente.ILernkartenKomponenteServices;
import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Nutzerkomponente implements INutzerKomponenteServices {
    private ILernkartenKomponenteServices lernkartenKomponenteServices;
    private IAntwortKomponenteServices antwortKomponenteServices;
    private NutzerKomponentenDAO nutzerKomponentenDAO;

    public Nutzerkomponente(IPersistenzServices persistenzServices, ILernkartenKomponenteServices lernkartenKomponenteServices, IAntwortKomponenteServices antwortKomponenteServices) {
        this.lernkartenKomponenteServices = lernkartenKomponenteServices;
        this.antwortKomponenteServices = antwortKomponenteServices;
    }

}
