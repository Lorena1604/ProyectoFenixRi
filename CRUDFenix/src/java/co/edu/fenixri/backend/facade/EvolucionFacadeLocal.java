/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Evolucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EvolucionFacadeLocal {

    void create(Evolucion evolucion);

    void edit(Evolucion evolucion);

    void remove(Evolucion evolucion);

    Evolucion find(Object id);

    List<Evolucion> findAll();

    List<Evolucion> findRange(int[] range);

    int count();
    
}
