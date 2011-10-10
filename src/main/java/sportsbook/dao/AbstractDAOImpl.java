package sportsbook.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sportsbook.util.HibernateUtil;

import java.io.Serializable;

public abstract class AbstractDAOImpl<T extends Serializable, KeyType extends Serializable> {

    Session session;
    Transaction tx;
    protected Class<T> domainClass = getDomainClass();

    protected abstract Class<T> getDomainClass();

    public void post(T t) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if (t != null) {
                tx = session.beginTransaction();
                session.saveOrUpdate(t);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public T get(long id) {
        T res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            res = (T) session.get(domainClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return res;
    }


}
