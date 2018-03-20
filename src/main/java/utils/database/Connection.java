package utils.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String URL = "jdbc:sqlite:selforg.db";
    private static final Connection INSTANCE = new Connection();

    private java.sql.Connection connection;

    private Connection() {

    }

    public static Connection getInstance() {
        return INSTANCE;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL);
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
