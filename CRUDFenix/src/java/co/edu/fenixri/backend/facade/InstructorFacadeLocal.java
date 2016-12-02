/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Instructor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface InstructorFacadeLocal {

    void create(Instructor instructor);

    void edit(Instructor instructor);

    void remove(Instructor instructor);

    Instructor find(Object id);

    List<Instructor> findAll();

    List<Instructor> findRange(int[] range);

    int count();
    
}
