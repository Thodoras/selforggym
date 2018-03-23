package domain.mappers;

import peristence.daos.TeamDao;
import dtos.TeamDto;

import java.util.ArrayList;
import java.util.List;

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

    public List<TeamDao> mapListTeamDtoToListTeamDao(List<TeamDto> teamDtos) {
        List<TeamDao> teamDaos = new ArrayList<>();
        for (TeamDto teamDto : teamDtos) {
            teamDaos.add(mapTeamDtoToTeamDao(teamDto));
        }
        return teamDaos;
    }

    public TeamDto mapTeamDaoToTeamDto(TeamDao teamDao) {
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamName(teamDao.getTeamName());
        teamDto.setTeamActivity(teamDao.getTeamActivity());
        return teamDto;
    }

    public List<TeamDto> mapListTeamDaoToListTeamDto(List<TeamDao> teamDaos) {
        List<TeamDto> teamDtos = new ArrayList<>();
        for (TeamDao teamDao : teamDaos) {
            teamDtos.add(mapTeamDaoToTeamDto(teamDao));
        }
        return teamDtos;
    }
}
