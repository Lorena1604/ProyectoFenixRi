/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.TipoActividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface TipoActividadFacadeLocal {

    void create(TipoActividad tipoActividad);

    void edit(TipoActividad tipoActividad);

    void remove(TipoActividad tipoActividad);

    TipoActividad find(Object id);

    List<TipoActividad> findAll();

    List<TipoActividad> findRange(int[] range);

    int count();
    
}
