/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.facade;

import co.edu.fenixri.backend.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "CRUDFenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario autenticarUsuario(int idUsuarioRegistrado, String password){
        Usuario usuario = null;
        
        Query consulta = em.createNamedQuery("SELECT u.identificacion, u.nombres, u.apellidos from usuarios u where identificacion=? and contrasena=?");
        consulta.setParameter(1, idUsuarioRegistrado);
        consulta.setParameter(2, password);
        return usuario;
    }
    
}
