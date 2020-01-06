/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.Contract;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thug17
 */
public interface IContract {
    public void Save(String clt, Contract contract);
    public void Update(Contract contract);
    public void delete(Contract contract);
    public List findAll();
    public List find(String val);
    
}
