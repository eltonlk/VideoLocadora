package dao;

import java.util.List;
import model.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class MovieDao extends util.GenericDao<Movie, java.io.Serializable> {

    @Override
    public List<Movie> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            List list = session.createCriteria(Movie.class).addOrder(Order.asc("title")).list();

            return (List<Movie>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
   }

   public boolean exists(Movie movie) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Criteria c = session.createCriteria(Movie.class);

            if (movie.getMovieId()!= null) {
                c.add(Restrictions.not(Restrictions.idEq(movie.getMovieId())));
            }

            c.add( Restrictions.eq("title", movie.getTitle()) );

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
