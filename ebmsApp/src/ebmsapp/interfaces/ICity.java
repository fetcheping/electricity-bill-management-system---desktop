/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebmsapp.interfaces;

import ebmsapp.entities.Cities;
import java.util.List;

/**
 *
 * @author Thug17
 */
public interface ICity {
    public List<Cities> findAll();
}
