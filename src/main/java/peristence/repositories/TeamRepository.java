package peristence.repositories;

import peristence.daos.TeamDao;
import utils.database.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class TeamRepository {

    private static final TeamRepository INSTANCE = new TeamRepository();

    private TeamRepository() {

    }

    public static TeamRepository getInstance() {
        return INSTANCE;
    }

    public void insert(TeamDao teamDao) throws SQLException {
        String query = "INSERT INTO " + teamDao.getTableName()
                + "(team_name, activity) "
                + "VALUES ('" + teamDao.getTeamName()
                + "', '" + teamDao.getTeamActivity() + "');";
        Statement statement = Connection.getInstance().getConnection().createStatement();
        statement.executeUpdate(query);
    }

}
