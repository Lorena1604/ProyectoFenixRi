/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Rendimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class RendimientoFacade extends AbstractFacade<Rendimiento> implements RendimientoFacadeLocal {

    @PersistenceContext(unitName = "CRUDFenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RendimientoFacade() {
        super(Rendimiento.class);
    }
    
}
