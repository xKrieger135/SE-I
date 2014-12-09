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
public class NutzerKomponentenDAO {
    private Connection connection;

    private static NutzerKomponentenDAO instance = null;

    public static NutzerKomponentenDAO getInstance() {
        if(instance == null) {
            instance = new NutzerKomponentenDAO();
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

    public INutzer getNutzerAnhandSeinerLernkarte() {
        Nutzer nutzerEinerBestimmtenLernkarte = new Nutzer();

        try {
            login();
            String select = "SELECT * FROM INUTZER in, LERNKARTE lk WHERE in.LERNKARTENID = lk.LERNKARTENID";
            PreparedStatement pstmt = connection.prepareStatement(select);
            ResultSet resultset = pstmt.executeQuery();

            while(resultset.next()) {
            nutzerEinerBestimmtenLernkarte.setVorname(resultset.getString("VORNAME"));
            nutzerEinerBestimmtenLernkarte.setName(resultset.getString("NAME"));
            nutzerEinerBestimmtenLernkarte.setEmail(new EmailDatentyp(resultset.getString("EMAIl")));
            nutzerEinerBestimmtenLernkarte.setErstellteLernkarten();

            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nutzerEinerBestimmtenLernkarte;
    }
}
