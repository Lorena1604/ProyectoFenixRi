/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Cinturon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface CinturonFacadeLocal {

    void create(Cinturon cinturon);

    void edit(Cinturon cinturon);

    void remove(Cinturon cinturon);

    Cinturon find(Object id);

    List<Cinturon> findAll();

    List<Cinturon> findRange(int[] range);

    int count();
    
}
