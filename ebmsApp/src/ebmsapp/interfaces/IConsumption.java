/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.Consumption;
import java.util.List;

/**
 *
 * @author Thug17
 */
public interface IConsumption {
    public void Save(String clt, Consumption consumption);
    public void delete(Consumption consumption);
    public void update(Consumption consumption);
    public List findAll();
    public List find(String val);
}
