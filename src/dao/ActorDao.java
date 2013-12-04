package dao;

import java.util.List;
import model.Actor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ActorDao extends util.GenericDao<Actor, java.io.Serializable> {

    @Override
    public List<Actor> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            List list = session.createCriteria(Actor.class).addOrder(Order.asc("name")).list();
            
            return (List<Actor>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        return null;
   }
    
   public boolean exists(Actor actor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            Criteria c = session.createCriteria(Actor.class);
            
            if (actor.getActorId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(actor.getActorId())));
            }
            
            c.add( Restrictions.eq("name", actor.getName()) );
            
            List list = c.list();
            
            return !list.isEmpty();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return false;
   }
   
}
