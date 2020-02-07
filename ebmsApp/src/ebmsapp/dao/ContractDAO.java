/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import ebmsapp.entities.Cities;
import ebmsapp.entities.Client;
import ebmsapp.entities.Contract;
import ebmsapp.interfaces.IContract;
import java.util.Date;
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
public class ContractDAO implements IContract{
    
    public static SessionFactory Factory;

    public ContractDAO() {
        Factory = new Configuration().configure().buildSessionFactory();
    }
    
    

    @Override
    public void Save(String clt, Contract contract) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        Session session = Factory.openSession();
         Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
           List<Client> ls = session.createQuery("FROM Client as clt WHERE clt.firstname = ?").setString(0, clt).list();
             
             for (Client c : ls) {
               session.persist(contract);
               c.getContracts().add(contract);
               contract.setClient(c);
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
    public void Update(Contract contract) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(contract);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(Contract contract) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.delete(contract);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }

    }

    @Override
    public List findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         Session session = Factory.openSession();
         Transaction tx = null;
       
        try {
            tx = session.beginTransaction();
            List client = session.createQuery("FROM Client").list();
            for (Iterator iterator1 = client.iterator(); iterator1.hasNext();){
            Client clt = (Client) iterator1.next(); 
            Set articles = clt.getContracts();
            for (Iterator iterator2 = articles.iterator(); iterator2.hasNext();){
               Contract c = (Contract) iterator2.next(); 
            }
         }
            tx.commit();
            return client;
           
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
        return null;
    }

    @Override
    public List find(String val) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         Session session = Factory.openSession();
         Transaction t = null;
         
         try {
             t = session.beginTransaction();
             Query qr = session.createQuery("From Client WHERE firstname LIKE :firstname");
             qr.setString("firstname", "%"+val+"%");
             List ls = qr.list();
                for (Iterator iterator1 = ls.iterator(); iterator1.hasNext();){
                Client clt = (Client) iterator1.next(); 
                Set articles = clt.getContracts();
                for (Iterator iterator2 = articles.iterator(); iterator2.hasNext();){
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
    
     public Contract findone(String value) {
        
         Session session = Factory.openSession();
         Transaction t = null;
         
         try {
             t = session.beginTransaction();
             Contract cl = (Contract)session.createQuery("From Contract WHERE contractNumber = ?").setString(0, value).uniqueResult();
             return cl;
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
             session.close();
         }
        return null;
    }
}
