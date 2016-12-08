/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Evidencia;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class EvidenciaFacade extends AbstractFacade<Evidencia> implements EvidenciaFacadeLocal {

    @PersistenceContext(unitName = "CRUDFenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvidenciaFacade() {
        super(Evidencia.class);
    }

    @Override
    public String importDataFromFile(String fileName) throws SQLException {
        int salida = 0;
        String msg;
        //para mas detalles revisa LOAD DATA LOCAL INFILE en Mysql
        String query = "LOAD DATA LOCAL INFILE '" + fileName + "' INTO TABLE evidencias  FIELDS TERMINATED BY ',' "
                + " IGNORE 1 LINES  (documentos, idActividad) ";  //campos de la tabla. los auto_increment no se colocan
        salida = em.createNativeQuery(query).executeUpdate();
        if (salida > 0) {
            msg = "Se cargaron exitosamente " + salida + " registros a la tabla";
        } else if (salida == 0) {
            msg = "No se han cargado los datos. Verifique que no hayan sido cargados previamente a la tabla ";
        } else {
            msg = "Inexperado. Contacte al servidor!";
        }
        return msg;
    }

}
