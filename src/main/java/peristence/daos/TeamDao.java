package peristence.daos;

public class TeamDao {

    private static final String tableName = "teams";

    private String teamName;
    private String teamActivity;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamActivity() {
        return teamActivity;
    }

    public void setTeamActivity(String teamActivity) {
        this.teamActivity = teamActivity;
    }

    public String getTableName() {
        return tableName;
    }

}
