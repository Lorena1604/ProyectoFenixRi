/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Rendimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface RendimientoFacadeLocal {

    void create(Rendimiento rendimiento);

    void edit(Rendimiento rendimiento);

    void remove(Rendimiento rendimiento);

    Rendimiento find(Object id);

    List<Rendimiento> findAll();

    List<Rendimiento> findRange(int[] range);

    int count();
    
}
