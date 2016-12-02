/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Ficha;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface FichaFacadeLocal {

    void create(Ficha ficha);

    void edit(Ficha ficha);

    void remove(Ficha ficha);

    Ficha find(Object id);

    List<Ficha> findAll();

    List<Ficha> findRange(int[] range);

    int count();
    
}
