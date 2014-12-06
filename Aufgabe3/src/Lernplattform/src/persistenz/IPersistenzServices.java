package persistenz;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public interface IPersistenzServices {

    boolean login(String username, String password);

    void closeConnection() throws SQLException;
}
