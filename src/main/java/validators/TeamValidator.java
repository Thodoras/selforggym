package validators;

import dtos.TeamDto;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import java.util.regex.Pattern;

public class TeamValidator {

    private static final Pattern nameInputPattern = Pattern.compile("^[a-zA-z]([a-zA-Z0-9-_](\\s)?)+$");

    private TeamDto teamDto;

    public TeamValidator(TeamDto teamDto) {
        this.teamDto = teamDto;
    }

    public void validateTeamDto() throws MissingFieldException, InvalidInputException {
        validateTeamName();
        validateTeamActivity();
    }

    private void validateTeamName() throws MissingFieldException, InvalidInputException {
        if (!hasValue(teamDto.getTeamName())) {
            throw new MissingFieldException("Team name cannot be empty!");
        }
        if (!nameInputPattern.matcher(teamDto.getTeamName()).matches()) {
            throw new InvalidInputException("Team name should start with a letter and have at least two characters");
        }
    }

    private void validateTeamActivity() throws MissingFieldException, InvalidInputException {
        if (!hasValue(teamDto.getTeamActivity())) {
            throw new MissingFieldException("Activity name cannot be empty!");
        }
        if (!nameInputPattern.matcher(teamDto.getTeamActivity()).matches()) {
            throw new InvalidInputException("Activity name should start with a letter and have at least two characters");
        }
    }

    private boolean hasValue(String str) {
        return str != null && !str.isEmpty();
    }
}
