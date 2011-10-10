package sportsbook.dao;
import org.hibernate.Query;
import sportsbook.types.Team;
import sportsbook.util.HibernateUtil;

public class TeamDAO extends AbstractDAOImpl<Team, Long> implements AbstractDAO<Team, Long> {

    public Team get(Long id) {
        return super.get(id);
    }

    public void post(Team team) {
        super.post(team);
    }

    public int getByESPN(int espnID, String league) {
        System.out.println("---------------------------------------------");
        System.out.println("GETBYESPN:" + espnID + ":" + league);
        session = HibernateUtil.getSessionFactory().openSession();
        Query qry = session.createQuery("from Team where espn_id=" + espnID + "and league='"
                + league +"'");
        qry.setMaxResults(1);
        Team t = (Team) qry.uniqueResult();
        return (int) t.getId();
    }

    @Override
    protected Class<Team> getDomainClass() {
        return Team.class;
    }


}
