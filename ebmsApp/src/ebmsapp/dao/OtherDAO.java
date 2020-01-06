/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.dao;

import ebmsapp.entities.Bill;
import ebmsapp.entities.Client;
import ebmsapp.interfaces.IOther;
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
public class OtherDAO implements IOther{
    
    private static SessionFactory factory;

    public OtherDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    

    @Override
    public int countClient() {
        
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            
            tx = session.beginTransaction();
            
            List<Client> clients = session.createQuery("From Client").list();
            
            int countClient = clients.size();
            
            return countClient;
            
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    }

    @Override
    public int countConsumption() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countUnpaidBill() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            
            tx = session.beginTransaction();
            
            List<Bill> bill = session.createQuery("From Bill as bill where bill.process = 'unpaid' ").list();
            
            int countClient = bill.size();
            
            return countClient;
            
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return 0;
    }
    
}
