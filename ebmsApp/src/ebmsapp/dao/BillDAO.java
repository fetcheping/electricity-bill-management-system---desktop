/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import static ebmsapp.dao.ContractDAO.Factory;
import ebmsapp.entities.Bill;
import ebmsapp.entities.Client;
import ebmsapp.entities.Contract;
import ebmsapp.interfaces.IBill;
import java.net.PasswordAuthentication;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Thug17
 */
public class BillDAO implements IBill{
    
    private static SessionFactory Factory;

    public BillDAO() {
        Factory = new Configuration().configure().buildSessionFactory();
    }
    
    

    @Override
    public void Save(String clt, Bill bill) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Session session = Factory.openSession();
        Transaction tx=null;
        
        try {
            
             tx = session.beginTransaction();
             
             UserDAO u = new UserDAO();
            // User l = u.login(clt, clt)
            
             List<Client> ls = session.createQuery("FROM Client as clt WHERE clt.firstname = ?").setString(0, clt).list();
             
             for (Client c : ls) {
               session.persist(bill);
               c.getBills().add(bill);
               bill.setClient(c);
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
    public void delete(Bill bill) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Session session = Factory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.delete(bill);
            t.commit();
        } catch (HibernateException e) {
            if(t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(Bill bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            Set bill = clt.getBills();
            for (Iterator iterator2 = bill.iterator(); iterator2.hasNext();){
               Bill b = (Bill) iterator2.next(); 
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
    public List find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
