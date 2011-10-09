package sportsbook.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sportsbook.types.Game;

public class GameDAO extends AbstractDAOImpl<Game, Long> implements AbstractDAO<Game, Long> {
    Session session;
    Transaction tx;

    @Override
    protected Class getDomainClass() {
       return Game.class;
    }

    public void post(Game game) {
       super.post(game);
    }

    public void post(Game[] games) {
        for (Game g: games) {
            super.post(g);
        }
    }

    public Game get(Long id) {
        return super.get(id);
    }
}
