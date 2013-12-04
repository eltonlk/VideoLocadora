package dao;

import java.util.List;
import model.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CountryDao extends util.GenericDao<Country, java.io.Serializable> {

    @Override
    public List<Country> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            List list = session.createCriteria(Country.class).addOrder(Order.asc("name")).list();
            
            return (List<Country>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        return null;
   }
    
   public boolean exists(Country country) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            Criteria c = session.createCriteria(Country.class);
            
            if (country.getCountryId() != null) {
                c.add(Restrictions.not(Restrictions.idEq(country.getCountryId())));
            }
            
            c.add( Restrictions.eq("name", country.getName()) );
            
            List list = c.list();
            
            return !list.isEmpty();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return false;
   }
    
}
