package dao;

import java.util.List;
import model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class PersonDao extends util.GenericDao<Person, java.io.Serializable> {

    @Override
    public List<Person> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            List list = session.createCriteria(Person.class).addOrder(Order.asc("name")).list();

            return (List<Person>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
   }

    public List<Person> list(String kind) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Criteria c = session.createCriteria(Person.class);
            c.add( Restrictions.eq("kind", kind) );
            c.addOrder( Order.asc("name") );
            List list = c.list();

            return (List<Person>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
   }    
    
   public boolean exists(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Criteria c = session.createCriteria(Person.class);

            if (person.getPersonId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(person.getPersonId())));
            }

            c.add( Restrictions.eq("legal_name", person.getLegalName()) );

            List list = c.list();

            return !list.isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        return false;
   }

}

