/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Asistencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface AsistenciaFacadeLocal {

    void create(Asistencia asistencia);

    void edit(Asistencia asistencia);

    void remove(Asistencia asistencia);

    Asistencia find(Object id);

    List<Asistencia> findAll();

    List<Asistencia> findRange(int[] range);

    int count();
    
}
