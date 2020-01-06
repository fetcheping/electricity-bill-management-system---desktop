/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.User;

/**
 *
 * @author Thug17
 */
public interface IUser {
    
    public void save(User user);
    public void Edit(User user);
    public User login(String username, String password);
}
