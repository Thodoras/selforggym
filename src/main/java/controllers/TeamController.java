package controllers;

import dtos.TeamDto;

public class TeamController {

    public void addTeam(TeamDto teamDto) {
        System.out.println(teamDto.getTeamActivity());
        System.out.println(teamDto.getTeamName());
    }

}
