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
        return mapInList(readFromDb(query));
    }

    public List<TeamDao> getByName(String name) throws SQLException {
        String query = "SELECT * FROM " + TEAM_TABLE + " WHERE " + TEAM_NAME_COL + " = '" + name + "';";
        return mapInList(readFromDb(query));
    }

    private ResultSet readFromDb(String query) throws SQLException {
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
        writeToDb(query);
    }

    public void update(TeamDao oldDao, TeamDao newDao) throws SQLException {
        String query = "UPDATE " + TEAM_TABLE + " "
                + "SET " + TEAM_NAME_COL + " = '" + newDao.getTeamName() + "', "
                         + ACTIVITY_COL + " = '" + newDao.getTeamActivity() + "' "
                + "WHERE " + TEAM_NAME_COL + " = '" + oldDao.getTeamName() + "';";
        writeToDb(query);
    }

    public void delete(TeamDao teamDao) throws SQLException {
        String query = "DELETE FROM " + TEAM_TABLE + " "
                + "WHERE " + TEAM_NAME_COL + " = '" + teamDao.getTeamName() + "';";
        writeToDb(query);
    }

    private void writeToDb(String query) throws SQLException {
        Statement statement = Connection.getInstance().getConnection().createStatement();
        statement.executeUpdate(query);
    }

}
