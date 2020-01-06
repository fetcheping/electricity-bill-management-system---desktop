/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import ebmsapp.entities.Cities;
import ebmsapp.interfaces.ICity;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Thug17
 */
public class CityDAO implements ICity{

    private static SessionFactory Factory;

    public CityDAO() {
        Factory = new Configuration().configure().buildSessionFactory();
    }
    
    
    @Override
    public List<Cities> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        Session session = Factory.openSession();
        Transaction t=null;
        try {
            
            t = session.beginTransaction();
            List<Cities> cities = session.createQuery("From Cities").list();
            t.commit();
            return cities;
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }
    
}
