/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.Client;
import java.util.List;

/**
 *
 * @author Thug17
 */
public interface IClient {
    public void Save(String city, Client client);
    public List<Client> findAll();
    public void Update(Client client);
    public void delete(Client client);
    public List<Client> find(String value);
    
}
