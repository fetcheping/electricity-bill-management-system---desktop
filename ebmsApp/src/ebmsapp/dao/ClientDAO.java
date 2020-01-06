/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import ebmsapp.entities.Cities;
import ebmsapp.entities.Client;
import ebmsapp.interfaces.IClient;
import java.util.List;
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
public class ClientDAO implements IClient{

    private static SessionFactory Factory;

    public ClientDAO() {
        Factory = new Configuration().configure().buildSessionFactory();
    }
    
    
    @Override
    public void Save(String city, Client client) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         Session session = Factory.openSession();
         Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
             List<Cities> resultlist = session.createQuery("From Cities as city where city.name = ?").setString(0, city).list();
             
             for (Cities c : resultlist) {
               //Client clt = new Client();
               session.persist(client);
               c.getClients().add(client);
               client.setCities(c);
           }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Client> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = Factory.openSession();
        Transaction t=null;
        try {
            
            t = session.beginTransaction();
            List<Client> client = session.createQuery("From Client").list();
            t.commit();
            return client;
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void Update(Client client) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(client);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(Client client) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.delete(client);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Client> find(String value) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         Session session = Factory.openSession();
         Transaction t = null;
         
         try {
             t = session.beginTransaction();
             Query qr = session.createQuery("From Client WHERE firstname LIKE :firstname");
             qr.setString("firstname", "%"+value+"%");
             List<Client> ls = qr.list();
             return ls;
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
             session.close();
         }
        return null;
    }
   
}
