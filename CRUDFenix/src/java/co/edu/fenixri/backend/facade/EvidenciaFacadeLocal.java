/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Evidencia;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EvidenciaFacadeLocal {

    void create(Evidencia evidencia);

    void edit(Evidencia evidencia);

    void remove(Evidencia evidencia);

    Evidencia find(Object id);

    List<Evidencia> findAll();

    List<Evidencia> findRange(int[] range);

    int count();

    String importDataFromFile(String fileName) throws SQLException;
}
