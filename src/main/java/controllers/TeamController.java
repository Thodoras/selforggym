package controllers;

import domain.flows.TeamFlow;
import dtos.TeamDto;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.sql.SQLException;

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
            , SQLException {
        teamFlow.addTeam(teamDto);
    }

}
