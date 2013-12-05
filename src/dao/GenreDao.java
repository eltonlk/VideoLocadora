package dao;

import java.util.List;
import model.Genre;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class GenreDao extends util.GenericDao<Genre, java.io.Serializable> {

    @Override
    public List<Genre> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            List list = session.createCriteria(Genre.class).addOrder(Order.asc("name")).list();

            return (List<Genre>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
   }

   public boolean exists(Genre genre) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Criteria c = session.createCriteria(Genre.class);

            if (genre.getGenreId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(genre.getGenreId())));
            }

            c.add( Restrictions.eq("name", genre.getName()) );

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

