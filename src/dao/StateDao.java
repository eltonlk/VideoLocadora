package dao;

import java.util.List;
import model.State;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class StateDao extends util.GenericDao<State, java.io.Serializable> {

    @Override
    public List<State> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            List list = session.createCriteria(State.class).addOrder(Order.asc("name")).list();

            return (List<State>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
   }

   public boolean exists(State state) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Criteria c = session.createCriteria(State.class);

            if (state.getStateId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(state.getStateId())));
            }

            c.add( Restrictions.eq("name", state.getName()) );
            c.add( Restrictions.eq("country_id", state.getCountry().getCountryId()) );

            List list = c.list();

            return !list.isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
   }

}

