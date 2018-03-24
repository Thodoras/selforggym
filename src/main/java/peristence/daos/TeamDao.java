package peristence.daos;

public class TeamDao {

    private int id;
    private String teamName;
    private String teamActivity;

    public int getId() {
        return id;
    }

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

}
