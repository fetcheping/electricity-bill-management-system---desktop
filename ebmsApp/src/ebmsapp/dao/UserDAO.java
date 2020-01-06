/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import ebmsapp.entities.User;
import ebmsapp.interfaces.IUser;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Thug17
 */
public class UserDAO implements IUser{
    
    private static SessionFactory Factory;

    public UserDAO() {
        Factory = new Configuration().configure().buildSessionFactory();
    }
    
    

    @Override
    public void save(User user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(user);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    
     @Override
    public User login(String username, String password) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query qr = session.createQuery("From User as u where u.username =:username and u.password =:password");
            qr.setString("username", username);
            qr.setString("password", password);
            t.rollback();
            return (User)qr.uniqueResult();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void Edit(User user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
         Session session = Factory.openSession();
         Transaction t = null;
            try {
                t = session.beginTransaction();
                session.update(user);
                t.commit();
            } catch (HibernateException e) {
                if(t!=null) t.rollback();
                e.printStackTrace();
            }finally{
                session.close();
            }
    }
    
}
