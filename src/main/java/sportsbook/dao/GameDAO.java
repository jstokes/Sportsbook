package sportsbook.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sportsbook.types.Game;
import sportsbook.util.HibernateUtil;

import java.util.List;

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

    public Game[] getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        Query qry = session.createQuery("select * from Game");
        qry.setMaxResults(1000);
        List games = qry.list();
        return (Game[]) games.toArray();
    }
}
