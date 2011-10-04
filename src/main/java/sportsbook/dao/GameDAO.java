package sportsbook.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sportsbook.types.Game;
import sportsbook.util.HibernateUtil;

public class GameDAO {
    Session session;
    Transaction tx;

    public void postToDB(Game[] games) {
        for (Game g: games) {
            postToDB(g);
        }
    }

    public void postToDB(Game game) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(game);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Game getGameByID(long id) {
        return null;
    }
}
