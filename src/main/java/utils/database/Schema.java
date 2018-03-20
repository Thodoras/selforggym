package utils.database;

import java.sql.SQLException;
import java.sql.Statement;

public class Schema {

    private static final Schema INSTANCE = new Schema();

    private Schema() {

    }

    public static Schema getInstance() {
        return INSTANCE;
    }

    private String[] migrations = {"CREATE TABLE IF NOT EXISTS teams (" +
            "team_name text PRIMARY KEY," +
            "activity text);"
    };

    public void migrate() {
        try {
            Statement statement = Connection.getInstance().getConnection().createStatement();
            for (String migration : migrations) {
                statement.executeUpdate(migration);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
