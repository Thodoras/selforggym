package controllers;

import domain.flows.TeamFlow;
import dtos.TeamDto;
import utils.exceptions.InputAlreadyExistsException;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.sql.SQLException;
import java.util.List;

public class TeamController {

    private static final TeamController INSTANCE = new TeamController();

    private TeamFlow teamFlow = TeamFlow.getInstance();

    private TeamController() {

    }

    public static TeamController getInstance() {
        return INSTANCE;
    }

    public void addTeam(TeamDto teamDto) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException
            , SQLException {
        teamFlow.addTeam(teamDto);
    }

    public List<TeamDto> getAllTeams() throws SQLException {
        return teamFlow.getAllTeams();
    }

    public void updateTeam(TeamDto oldDto, TeamDto newDto) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException
            , SQLException {
        teamFlow.updateTeam(oldDto, newDto);
    }

    public void deleteTeam(TeamDto teamDto) throws SQLException {
        teamFlow.deleteTeam(teamDto);
    }

}
