package lernkartenKomponente;

import antwortKomponente.IAntwortKomponenteServices;
import com.sun.org.apache.xpath.internal.SourceTree;
import nutzerKomponente.INutzer;
import nutzerKomponente.INutzerKomponenteServices;
import persistenz.IPersistenzServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class LernkartenKomponente implements ILernkartenKomponenteServices {
    private IAntwortKomponenteServices antwortKomponentenServices;
    private INutzerKomponenteServices nutzer;
    private List<ILernkarte> lernkarte;
    private List<IModul> vorhandeneModule;
    private SingleChoice singleChoice;

    public LernkartenKomponente(IPersistenzServices persistenzServices, IAntwortKomponenteServices antwortKomponentenServices, INutzerKomponenteServices nutzer) {
        this.antwortKomponentenServices = antwortKomponentenServices;
        this.nutzer = nutzer;
    }

    public LernkartenKomponente() {

    }

    @Override
    public IModul erstelleModul(String modulName, String modulBeschreibung) {
        IModul modul = new Modul(modulName, modulBeschreibung);
        modul.setModulName(modulName);
        modul.setModulBeschreibung(modulBeschreibung);
        vorhandeneModule.add(modul);
        return modul;
    }

    @Override
    public List<IModul> getModulListe() {
        List<IModul> listeMitModulen = new ArrayList<IModul>();
        for (int i = 0; i < vorhandeneModule.size() - 1; i++) {
            listeMitModulen.add(vorhandeneModule.get(i));
        }
        return listeMitModulen;
    }

    @Override
    public List<ILernkarte> getListeDerLernkarten() {
        return null;
    }

    @Override
    public ILernkarte erstelleLernkarte(IModul modul, String lernkartenName, AufgabenTyp aufgabenTyp) {
        ILernkarte lernkarte = new Lernkarte(lernkartenName, modul, aufgabenTyp);
        return lernkarte;
    }

    @Override
    public List<ILernkarte> getListeDerUnkorrigiertenLernkarten() {
        return null;
    }

    @Override
    public int speichereLernkarte(ILernkarte lernkarte) {

        //TODO JDBC machen speichert lernkarte und gibt einen integer mit der id zurück für den user.
        return 0;
    }

    @Override
    public String toString() {
        return "LernkartenKomponente{" +
                "antwortKomponentenServices=" + antwortKomponentenServices +
                ", nutzer=" + nutzer +
                ", lernkarte=" + lernkarte +
                ", singleChoice=" + singleChoice +
                '}';
    }

    public static void main(String[] args) {
        String modulname = "ABC";
        String modulbeschreibung = "ABABABABABAB";
        IModul modul = new Modul(modulname, modulbeschreibung);

        LernkartenKomponente lk = new LernkartenKomponente();

        List<IModul> m = new ArrayList<IModul>();
        m.add(lk.erstelleModul(modul.getModulName(), modul.getModulBeschreibung()));

        String lernkartenName = "PADDY";
        ILernkarte lks = new Lernkarte(lernkartenName ,modul, AufgabenTyp.SINGLECHOICE);
        List<ILernkarte> lernk = new ArrayList<ILernkarte>();
        lernk.add(lk.erstelleLernkarte(modul,lks.getLernkartenName(), AufgabenTyp.SINGLECHOICE));

        System.out.println(lernk.get(0).toString());
        System.out.println(m.get(0).toString());

    }

}
