/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import static ebmsapp.dao.ContractDAO.Factory;
import ebmsapp.entities.Client;
import ebmsapp.entities.Consumption;
import ebmsapp.entities.Contract;
import ebmsapp.interfaces.IConsumption;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
public class ConsumptionDAO implements IConsumption{
    
    private static SessionFactory factory;

    public ConsumptionDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    @Override
    public void Save(String clt, Consumption consumption) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
        Session session=factory.openSession();
        Transaction tx = null;
        
        try {
            
            tx = session.beginTransaction();
            
           List<Client> ls = session.createQuery("FROM Client as clt WHERE clt.firstname = ?").setString(0, clt).list();
             
             for (Client c : ls) {
               session.persist(consumption);
               c.getConsumptions().add(consumption);
               consumption.setClient(c);
           }
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(Consumption consumption) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
        Session session=factory.openSession();
        Transaction tx = null;
        
        try {
            
            tx = session.beginTransaction();
            session.delete(consumption);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(Consumption consumption) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
        Session session=factory.openSession();
        Transaction tx = null;
        
        try {
            
            tx = session.beginTransaction();
            session.update(consumption);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
         Session session=factory.openSession();
         Transaction tx = null;
        
        try {
            
             tx = session.beginTransaction();
            List client = session.createQuery("FROM Client").list();
            for (Iterator iterator1 = client.iterator(); iterator1.hasNext();){
            Client clt = (Client) iterator1.next(); 
            Set con = clt.getConsumptions();
            for (Iterator iterator2 = con.iterator(); iterator2.hasNext();){
               Consumption c = (Consumption) iterator2.next(); 
            }
         }
            tx.commit();
            return client;
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public List<Consumption> find(String val) {
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       Session session = Factory.openSession();
         Transaction t = null;
         
         try {
             t = session.beginTransaction();
             Query qr = session.createQuery("From Client WHERE firstname LIKE :firstname");
             qr.setString("firstname", "%"+val+"%");
             List ls = qr.list();
                for (Iterator iterator1 = ls.iterator(); iterator1.hasNext();){
                Client clt = (Client) iterator1.next(); 
                Set con = clt.getConsumptions();
                for (Iterator iterator2 = con.iterator(); iterator2.hasNext();){
                   Contract c = (Contract) iterator2.next(); 
                }
            }
            t.commit();
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
