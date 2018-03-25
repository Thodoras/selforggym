package domain.flows;

import domain.mappers.TeamMapper;
import domain.validators.TeamValidator;
import dtos.TeamDto;
import peristence.daos.TeamDao;
import peristence.repositories.TeamRepository;
import utils.exceptions.InputAlreadyExistsException;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.sql.SQLException;
import java.util.List;

public class TeamFlow {

    private static final TeamFlow INSTANCE = new TeamFlow();

    private TeamValidator teamValidator = TeamValidator.getInstance();
    private TeamMapper teamMapper = TeamMapper.getInstance();
    private TeamRepository teamRepository = TeamRepository.getInstance();

    private TeamFlow() {

    }

    public static TeamFlow getInstance() {
        return INSTANCE;
    }

    public void addTeam(TeamDto teamDto) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException
            , SQLException {
        teamValidator.validateTeamDto(teamDto);
        TeamDao teamDao = teamMapper.mapTeamDtoToTeamDao(teamDto);
        teamRepository.insert(teamDao);
    }

    public List<TeamDto> getAllTeams() throws SQLException {
        List<TeamDao> teamDaos = teamRepository.getAll();
        return teamMapper.mapListTeamDaoToListTeamDto(teamDaos);
    }

    public void updateTeam(TeamDto oldDto, TeamDto newDto) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException
            , SQLException {
        teamValidator.validateTeamDto(newDto);
        TeamDao oldDao = teamMapper.mapTeamDtoToTeamDao(oldDto);
        TeamDao newDao = teamMapper.mapTeamDtoToTeamDao(newDto);
        teamRepository.update(oldDao, newDao);
    }

    public void deleteTeam(TeamDto teamDto) throws SQLException {
        TeamDao teamDao = teamMapper.mapTeamDtoToTeamDao(teamDto);
        teamRepository.delete(teamDao);
    }
}
