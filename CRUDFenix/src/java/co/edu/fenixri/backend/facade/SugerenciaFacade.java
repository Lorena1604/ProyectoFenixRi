/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Sugerencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class SugerenciaFacade extends AbstractFacade<Sugerencia> implements SugerenciaFacadeLocal {

    @PersistenceContext(unitName = "CRUDFenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SugerenciaFacade() {
        super(Sugerencia.class);
    }
    
}
