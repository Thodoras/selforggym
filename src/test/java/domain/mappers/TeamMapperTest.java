package domain.mappers;

import dtos.TeamDto;
import org.junit.Before;
import org.junit.Test;
import peristence.daos.TeamDao;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamMapperTest {

    private static final String TEAM_NAME = "team name";
    private static final String TEAM_ACTIVITY = "team activity";

    private TeamMapper teamMapper = TeamMapper.getInstance();
    private TeamDto teamDto = new TeamDto();
    private TeamDao teamDao = new TeamDao();

    @Before
    public void setup() {
        teamDto.setTeamName(TEAM_NAME);
        teamDto.setTeamActivity(TEAM_ACTIVITY);
        teamDao.setTeamName(TEAM_NAME);
        teamDao.setTeamActivity(TEAM_ACTIVITY);
    }

    @Test
    public void testMapTeamDtoToTeamDao() {
        TeamDto teamDto = mock(TeamDto.class);
        when(teamDto.getTeamName()).thenReturn(TEAM_NAME);
        when(teamDto.getTeamActivity()).thenReturn(TEAM_ACTIVITY);

        TeamDao expected = teamMapper.mapTeamDtoToTeamDao(teamDto);
        TeamDao actual = teamDao;

        assertThat(expected).isEqualToComparingFieldByField(actual);
    }

    @Test
    public void testMapTeamDaoToTeamDto() {
        TeamDao teamDao = mock(TeamDao.class);
        when(teamDao.getTeamName()).thenReturn(TEAM_NAME);
        when(teamDao.getTeamActivity()).thenReturn(TEAM_ACTIVITY);

        TeamDto expected = teamMapper.mapTeamDaoToTeamDto(teamDao);
        TeamDto actual = teamDto;

        assertThat(expected).isEqualToComparingFieldByField(actual);
    }

}
