/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.PagoEstudiante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface PagoEstudianteFacadeLocal {

    void create(PagoEstudiante pagoEstudiante);

    void edit(PagoEstudiante pagoEstudiante);

    void remove(PagoEstudiante pagoEstudiante);

    PagoEstudiante find(Object id);

    List<PagoEstudiante> findAll();

    List<PagoEstudiante> findRange(int[] range);

    int count();
    
}
