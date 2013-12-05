package util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDao<T, ID extends Serializable> {

    private final Class<T> klass;

    public GenericDao() {
        this.klass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }    
    
    public List<T> list() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            List list = session.createCriteria(klass).list();

            return (List<T>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        return null;
   }
    
    public Boolean save(T object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            session.flush();
            session.clear();
            session.saveOrUpdate(object);
            
            transaction.commit();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        } 
        return false;
    }
    
    public Boolean merge(T object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            session.merge(object);
            
            transaction.commit();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return false;
    }    
    
    public Boolean destroy(T object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            session.flush();
            session.clear();
            session.delete(object);
            System.out.println("1");
            transaction.commit();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return false;
    }
    
}
    
//    
//    
//
//    public Class<T> getObjectClass() {
//        return this.oClass;
//    }
//
//    
//
//    public void delete(T objeto) {
//        try {
//            HibernateUtility.beginTransaction();
//            HibernateUtility.getSession().flush();
//            HibernateUtility.getSession().clear();
//            HibernateUtility.getSession().delete(objeto);
//            HibernateUtility.commitTransaction();
//            HibernateUtility.closeSession();
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//
//    public void deleteItem(T objeto) {
//        try {
//            HibernateUtility.beginTransaction();
//            HibernateUtility.getSession().delete(objeto);
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//    
//    public List<T> list() {
//        try {
//            List list = HibernateUtility.getSession().createCriteria(oClass).list();
//            //HibernateUtility.closeSession();
//            return (List<T>) list;
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//
//    public T getById(Serializable id) {
//        try {
//            return (T) HibernateUtility.getSession().get(oClass, id);
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//
//    public T getById(Serializable id, boolean lock) {
//        try {
//            if (lock) {
//                return (T) HibernateUtility.getSession().get(oClass, id, LockOptions.UPGRADE);
//            } else {
//                return (T) HibernateUtility.getSession().get(oClass, id);
//            }
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//
//    public List<T> listCriterio(String subClazz, Map<String, Object> filtrosConsulta, int tipoConsulta) {
//        List<T> lista = new ArrayList<T>();
//        Set entradas = filtrosConsulta.entrySet();
//
//        try {
//            Criteria crit = HibernateUtility.getSession().createCriteria(oClass);
//            if (subClazz == null) {
//                for (Iterator it = entradas.iterator(); it.hasNext();) {
//                    Entry object = (Entry) it.next();
//                    if (object.getValue() instanceof Enum) {
//                        crit.add(Restrictions.eq(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 0) {
//                        crit.add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
//                    } else if (tipoConsulta == 1) {
//                        crit.add(Restrictions.eq(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 2) {
//                        crit.add(Restrictions.gt(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 3) {
//                        crit.add(Restrictions.ge(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 4) {
//                        crit.add(Restrictions.lt(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 5) {
//                        crit.add(Restrictions.le(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 2) {
//                        crit.add(Restrictions.ne(object.getKey().toString(), object.getValue()));
//                    }
//                }
//            } else {
//                for (Iterator it = entradas.iterator(); it.hasNext();) {
//                    Entry object = (Entry) it.next();
//                    //crit.createCriteria(subClazz).add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
//                    if (object.getValue() instanceof Enum) {
//                    } else if (tipoConsulta == 0) {
//                        crit.createCriteria(subClazz).add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
//                    } else if (tipoConsulta == 1) {
//                        crit.createCriteria(subClazz).add(Restrictions.eq(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 2) {
//                        crit.createCriteria(subClazz).add(Restrictions.gt(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 3) {
//                        crit.createCriteria(subClazz).add(Restrictions.ge(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 4) {
//                        crit.createCriteria(subClazz).add(Restrictions.lt(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 5) {
//                        crit.createCriteria(subClazz).add(Restrictions.le(object.getKey().toString(), object.getValue()));
//                    } else if (tipoConsulta == 2) {
//                        crit.createCriteria(subClazz).add(Restrictions.ne(object.getKey().toString(), object.getValue()));
//                    }
//                }
//            }
//            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//            crit.setMaxResults(20);
//            lista = (List<T>) crit.list();
//            //HibernateUtility.closeSession();
//            return lista;
//        } catch (HibernateException hibernateException) {
//            cancel();
//            throw hibernateException;
//        }
//    }
//
//    public List<T> consultaHQL(String consulta) {
//        return (List<T>) HibernateUtility.getSession().createQuery(consulta).list();
//    }
//
//    public void cancel() {
//        HibernateUtil.rollbackTransaction();
//        HibernateUtil.closeSession();
//    }
//}