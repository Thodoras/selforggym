package domain.validators;

import dtos.TeamDto;
import peristence.repositories.TeamRepository;
import utils.exceptions.InputAlreadyExistsException;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class TeamValidator {

    private static final TeamValidator INSTANCE = new TeamValidator();

    private static final Pattern nameInputPattern = Pattern.compile("^[a-zA-z]([a-zA-Z0-9-_](\\s)?)+$");

    private TeamValidator() {

    }

    public static TeamValidator getInstance() {
        return INSTANCE;
    }

    public void validateTeamDto(TeamDto teamDto) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException {
        validateTeamName(teamDto.getTeamName());
        validateTeamActivity(teamDto.getTeamActivity());
    }

    private void validateTeamName(String teamName) throws MissingFieldException
            , InvalidInputException
            , InputAlreadyExistsException {
        if (!hasValue(teamName)) {
            throw new MissingFieldException("Team name cannot be empty!");
        }
        if (!nameInputPattern.matcher(teamName).matches()) {
            throw new InvalidInputException("Team name should start with a letter and have at least two characters");
        }
        if (alreadyExists(teamName)) {
            throw new InputAlreadyExistsException("Team name already exists try another one!");
        }
    }

    private void validateTeamActivity(String activityName) throws MissingFieldException
            , InvalidInputException {
        if (!hasValue(activityName)) {
            throw new MissingFieldException("Activity name cannot be empty!");
        }
        if (!nameInputPattern.matcher(activityName).matches()) {
            throw new InvalidInputException("Activity name should start with a letter and have at least two characters");
        }
    }

    private boolean hasValue(String str) {
        return str != null && !str.isEmpty();
    }

    private Boolean alreadyExists(String teamName) {
        try {
            return !TeamRepository.getInstance().getByName(teamName).isEmpty();
        } catch (SQLException e) {

        }
        return null;
    }
}
