package domain.mappers;

import dtos.TeamDto;
import org.junit.Test;
import peristence.daos.TeamDao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamMapperTest {

    private TeamMapper teamMapper = TeamMapper.getInstance();

    @Test
    public void testMapTeamDtoToTeamDao() {
        String teamName = "foo";
        String teamActivity = "bar";
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn(teamName);
        when(teamDto.getTeamActivity()).thenReturn(teamActivity);

        TeamDao expected = teamMapper.mapTeamDtoToTeamDao(teamDto);
        TeamDao actual = new TeamDao();
        actual.setTeamName(teamName);
        actual.setTeamActivity(teamActivity);

        assertThat(expected).isEqualToComparingFieldByField(actual);
    }
}
