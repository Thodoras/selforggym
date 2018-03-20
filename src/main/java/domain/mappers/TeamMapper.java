package domain.mappers;

import peristence.daos.TeamDao;
import dtos.TeamDto;

public class TeamMapper {

    private static final TeamMapper INSTANCE = new TeamMapper();

    private TeamMapper() {

    }

    public static TeamMapper getInstance() {
        return INSTANCE;
    }

    public TeamDao mapTeamDtoToTeamDao(TeamDto teamDto) {
        TeamDao teamDao = new TeamDao();
        teamDao.setTeamName(teamDto.getTeamName());
        teamDao.setTeamActivity(teamDto.getTeamActivity());
        return teamDao;
    }
}
