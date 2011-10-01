package com.scorebook.dao;

import com.scorebook.parser.java.Game;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GameDAO {
    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("testing add record");
            session = sessionFactory.openSession();
            Game game = new Game();
            game.setAway(1);
            game.setHome_score(14);
            game.setHome(2);
            game.setAway_score(17);
            session.save(game);
            System.out.println("Done adding");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
