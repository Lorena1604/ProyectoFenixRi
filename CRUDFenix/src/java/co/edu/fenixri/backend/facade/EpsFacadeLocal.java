/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Eps;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EpsFacadeLocal {

    void create(Eps eps);

    void edit(Eps eps);

    void remove(Eps eps);

    Eps find(Object id);

    List<Eps> findAll();

    List<Eps> findRange(int[] range);

    int count();
    
}
