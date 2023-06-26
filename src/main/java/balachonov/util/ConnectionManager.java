package balachonov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static balachonov.util.Constants.*;

public final class ConnectionManager {


    static {
        loadConnection();
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    Properties.get(URL_KEY),
                    Properties.get(USERNAME_KEY),
                    Properties.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(ERR);
        }
    }

    private ConnectionManager() {
    }
}
