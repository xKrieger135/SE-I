package lernkartenKomponente;

import antwortKomponente.AntwortKomponente;
import nutzerKomponente.*;
import persistenz.IPersistenzServices;
import persistenz.PersistenzServices;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrick_steinhauer on 03.12.2014.
 */
public class LernkartenkomponenteDAO  {
    //TODO JDBC Operationen hier machen und an Lernkartenkomponente weiterreichen

    private Connection connection;

    private static LernkartenkomponenteDAO instance = null;
    private INutzerKomponentenDAO iNutzerKomponentenDAO = NutzerKomponentenDAO.getInstance();

    public static LernkartenkomponenteDAO getInstance() {
        if(instance == null) {
            instance = new LernkartenkomponenteDAO();
        }
        return instance;
    }


    public boolean login() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager
                    .getConnection(
                            "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf09",
                            "", "");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public List<IModul> getModulListe() {
        List<IModul> listeMitModulen = new ArrayList<IModul>();

        try {
            login();
            String select = "SELECT * FROM MODUL";
            PreparedStatement pstmt = connection.prepareStatement(select);
            ResultSet resultset = pstmt.executeQuery();

            while(resultset.next()) {
                Modul modul = new Modul();
                modul.setModulID(resultset.getInt("MODULID"));
                modul.setModulName(resultset.getString("MODULNAME"));
                modul.setModulBeschreibung(resultset.getString("MODULBESCHREIBUNG"));
                listeMitModulen.add(modul);

            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeMitModulen;
    }

    public List<ILernkarte> getListeDerLernkarten() {
        List<ILernkarte> lernkartenListe = new ArrayList<ILernkarte>();

        try {
            login();
            String select = "SELECT * FROM LERNKARTE";
            PreparedStatement pstmt = connection.prepareStatement(select);
            ResultSet resultset = pstmt.executeQuery();

            while(resultset.next()) {
                Lernkarte lernkarte = new Lernkarte();
                Modul modul = new Modul();
                lernkarte.setLernkartenID(resultset.getInt("LERNKARTENID"));
                lernkarte.setLernkartenName(resultset.getString("LERNKARTENNAME"));
                lernkarte.setUeberprueft(resultset.getString("LERNKARTEUEBERPRUEFT"));
                lernkartenListe.add(lernkarte);

            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lernkartenListe;
    }

    public Lernkarte getLernkarte(String lernkartenName) {
        Lernkarte lernkarte = new Lernkarte();
        try {
            login();
            String select = "SELECT * FROM LERNKARTE WHERE LERNKARTENNAME = '" + lernkartenName + "'";
            PreparedStatement pstmt = connection.prepareStatement(select);
            ResultSet resultset = pstmt.executeQuery();

            while(resultset.next()) {
                lernkarte.setLernkartenID(resultset.getInt("LERNKARTENID"));
                lernkarte.setLernkartenName(resultset.getString("LERNKARTENNAME"));
                lernkarte.setUeberprueft(resultset.getString("LERNKARTEUEBERPRUEFT"));
                lernkarte.setFrage(resultset.getString("LERNKARTENFRAGE"));
                lernkarte.setAntwort(resultset.getString("LERNKARTENANTWORT"));
                lernkarte.setUeberprueft(resultset.getString("LERNKARTEUEBERPRUEFT"));
//                lernkarte.setNutzer(iNutzerKomponentenDAO.getNutzerVonLernkarte(lernkarte.getErsteller().getNutzerID()));
                lernkarte.setNutzer(iNutzerKomponentenDAO.getNutzerVonLernkarte(resultset.getInt("LERNKARTENERSTELLER")));
            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lernkarte;
    }

    //------------------------------------------------------------------------------------------------------------------




}
