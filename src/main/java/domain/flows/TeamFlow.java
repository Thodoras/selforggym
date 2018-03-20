package domain.flows;

import domain.mappers.TeamMapper;
import domain.validators.TeamValidator;
import dtos.TeamDto;
import peristence.daos.TeamDao;
import peristence.repositories.TeamRepository;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.sql.SQLException;

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
            , SQLException {
        teamValidator.validateTeamDto(teamDto);
        TeamDao teamDao = teamMapper.mapTeamDtoToTeamDao(teamDto);
        teamRepository.insert(teamDao);
    }
}
