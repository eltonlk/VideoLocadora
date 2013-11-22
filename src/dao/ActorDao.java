package dao;

//import model.Actor;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import util.HibernateUtil;

public class ActorDao extends GenericDao {
    
//    public static Boolean save(Actor actor) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        
//        try {
//            if (actor.getActorId() == null) {
//                session.save(actor);
//            } else {
//                session.merge(actor);
//            }
//            
//            transaction.commit();
//            
//            return true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        } finally {
//            session.clear();
//        }         
//        
//        return false;
//    }

}
