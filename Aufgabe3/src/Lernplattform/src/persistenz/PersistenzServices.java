package persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by patrick_steinhauer on 03.12.2014.
 */
public class PersistenzServices implements IPersistenzServices{

    private Connection connection;

    private static PersistenzServices instance = null;

    public static PersistenzServices getInstance() {
        if(instance == null) {
            instance = new PersistenzServices();
        }
        return instance;
    }

    @Override
    public boolean login(String username, String password) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager
                    .getConnection(
                            "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf09",
                            username, password);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
