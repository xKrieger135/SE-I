package nutzerKomponente;

import lernkartenKomponente.ILernkarte;
import lernkartenKomponente.Lernkarte;
import lernkartenKomponente.Modul;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paddy-Gaming on 08.12.2014.
 */
public class NutzerKomponentenDAO implements INutzerKomponentenDAO{
    private Connection connection;

    private static NutzerKomponentenDAO instance = null;

    public static NutzerKomponentenDAO getInstance() {
        if(instance == null) {
            instance = new NutzerKomponentenDAO();
        }
        return instance;
    }

    @Override
    public boolean login() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager
                    .getConnection(
                            "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf09",
                            "","");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public INutzer getNutzerVonLernkarte(int id) {
        Nutzer nutzerEinerBestimmtenLernkarte = new Nutzer();

        try {
            login();
            String select = "SELECT * FROM INUTZER nutzer, LERNKARTE lk WHERE nutzer.NUTZERID = " + id + " AND lk.LERNKARTENID = " + id + "";
            PreparedStatement pstmt = connection.prepareStatement(select);
            ResultSet resultset = pstmt.executeQuery();

            while(resultset.next()) {
                nutzerEinerBestimmtenLernkarte.setName(resultset.getString("NAME"));
//                nutzerEinerBestimmtenLernkarte.setEmail(new EmailDatentyp(resultset.getString("EMAIL")));
                nutzerEinerBestimmtenLernkarte.setNutzerID(resultset.getInt("NUTZERID"));
            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nutzerEinerBestimmtenLernkarte;
    }}
