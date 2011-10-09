package sportsbook.dao;

import sportsbook.types.League;

public class LeaugeDAO extends AbstractDAOImpl<League, Long> implements AbstractDAO<League, Long> {


    public League get(Long id) {
        return super.get(id);
    }

    public void post(League league) {
        super.post(league);
    }

    @Override
    protected Class getDomainClass() {
       return League.class;
    }
}
