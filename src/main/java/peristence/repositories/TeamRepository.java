package peristence.repositories;

import peristence.daos.TeamDao;
import utils.database.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {

    private static final TeamRepository INSTANCE = new TeamRepository();
    private static final String TEAM_TABLE = "teams";
    private static final String TEAM_NAME_COL = "team_name";
    private static final String ACTIVITY_COL = "activity";

    private TeamRepository() {

    }

    public static TeamRepository getInstance() {
        return INSTANCE;
    }

    public List<TeamDao> getAll() throws SQLException {
        String query = "SELECT * FROM " + TEAM_TABLE + ";";
        return mapInList(getFromDb(query));
    }

    private ResultSet getFromDb(String query) throws SQLException {
        Statement statement = Connection.getInstance().getConnection().createStatement();
        return statement.executeQuery(query);
    }

    private List<TeamDao> mapInList(ResultSet resultSet) throws SQLException {
        List<TeamDao> teamDaos = new ArrayList<>();
        while(resultSet.next()) {
            TeamDao teamDao = new TeamDao();
            teamDao.setTeamName(resultSet.getString(TEAM_NAME_COL));
            teamDao.setTeamActivity(resultSet.getString(ACTIVITY_COL));
            teamDaos.add(teamDao);
        }
        return teamDaos;
    }

    public void insert(TeamDao teamDao) throws SQLException {
        String query = "INSERT INTO " + TEAM_TABLE
                + "(" + TEAM_NAME_COL +", " + ACTIVITY_COL +") "
                + "VALUES ('" + teamDao.getTeamName() + "'"
                + ", '" + teamDao.getTeamActivity() + "');";
        Statement statement = Connection.getInstance().getConnection().createStatement();
        statement.executeUpdate(query);
    }

}
