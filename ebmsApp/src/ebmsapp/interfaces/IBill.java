/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.Bill;
import java.util.List;

/**
 *
 * @author Thug17
 */
public interface IBill {
    public void Save(String clt, Bill bill);
    public void delete(Bill bill);
    public void update(Bill bill);
    public List findAll();
    public void print();
}
