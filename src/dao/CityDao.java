package dao;

import java.util.List;
import model.Actor;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CityDao extends util.GenericDao<City, java.io.Serializable> {

    @Override
    public List<City> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            List list = session.createCriteria(Actor.class).addOrder(Order.asc("name")).list();
            
            return (List<City>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        return null;
   }
    
   public boolean exists(City city) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            Criteria c = session.createCriteria(Actor.class);
            
            if (city.getCityId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(city.getCityId())));
            }
            
            c.add( Restrictions.eq("name", city.getName()) );
            c.add( Restrictions.eq("state_id", city.getState().getStateId()) );
            
            List list = c.list();
            
            return !list.isEmpty();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return false;
   }
    
}
