package sportsbook.dao;

import sportsbook.types.Team;

public class TeamDAO extends AbstractDAOImpl<Team, Long> implements AbstractDAO<Team, Long> {

    public Team get(Long id) {
        return super.get(id);
    }

    public void post(Team team) {
        super.post(team);
    }

    @Override
    protected Class<Team> getDomainClass() {
        return Team.class;
    }
}
