/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Sugerencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface SugerenciaFacadeLocal {

    void create(Sugerencia sugerencia);

    void edit(Sugerencia sugerencia);

    void remove(Sugerencia sugerencia);

    Sugerencia find(Object id);

    List<Sugerencia> findAll();

    List<Sugerencia> findRange(int[] range);

    int count();
    
}
