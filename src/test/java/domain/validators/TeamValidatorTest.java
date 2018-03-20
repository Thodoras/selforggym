package domain.validators;

import dtos.TeamDto;
import org.junit.Test;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamValidatorTest {

    private TeamValidator teamValidator = TeamValidator.getInstance();

    @Test
    public void testValidateTeamDtoWhenHappyPath() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn("foo");
        when(teamDto.getTeamActivity()).thenReturn("bar");

        Throwable throwable = catchThrowable(()->teamValidator.validateTeamDto(teamDto));

        assertThat(throwable).isNull();
    }

    @Test
    public void testValidateTeamDtoWhenMissingTeamName() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn(null);
        when(teamDto.getTeamActivity()).thenReturn("bar");

        Throwable throwable = catchThrowable(()->teamValidator.validateTeamDto(teamDto));

        assertThat(throwable)
                .isInstanceOf(MissingFieldException.class)
                .hasMessage("Team name cannot be empty!");
    }

    @Test
    public void testValidateTeamDtoWhenMissingActivity() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn("foo");
        when(teamDto.getTeamActivity()).thenReturn(null);

        Throwable throwable = catchThrowable(()->teamValidator.validateTeamDto(teamDto));

        assertThat(throwable)
                .isInstanceOf(MissingFieldException.class)
                .hasMessage("Activity name cannot be empty!");
    }

    @Test
    public void testValidateTeamDtoWhenTeamNameDoesNotSatisfyRegex() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn("1foo");
        when(teamDto.getTeamActivity()).thenReturn("bar");

        Throwable throwable = catchThrowable(()->teamValidator.validateTeamDto(teamDto));

        assertThat(throwable)
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("Team name should start with a letter and have at least two characters");
    }

    @Test
    public void testValidateTeamDtoWhenActivityDoesNotSatisfyRegex() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn("foo");
        when(teamDto.getTeamActivity()).thenReturn("b");

        Throwable throwable = catchThrowable(()->teamValidator.validateTeamDto(teamDto));

        assertThat(throwable)
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("Activity name should start with a letter and have at least two characters");
    }
}
