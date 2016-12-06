/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.negocio;

import co.edu.fenixri.backend.entidades.Usuario;
import co.edu.fenixri.backend.facade.UsuarioFacadeLocal;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.http.HttpConversationContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class SessionBeanLogin {
    
     @Inject
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;
    private FacesContext facesContext;
    private HttpServletRequest hsr;
    private FacesMessage facesMessage;
    private RequestContext rc;
    
    public SessionBeanLogin() {
        facesContext = FacesContext.getCurrentInstance();
        hsr = (HttpServletRequest) (HttpConversationContext) facesContext.getExternalContext().getRequest();
    }
    
     public boolean validarUsuario(int userName, String password){
       usuario= usuarioFacadeLocal.autenticarUsuario(userName, password);
        if (usuario!=null) {
            hsr.getSession().setAttribute("userLogin", usuario);
            return true;
        }else{
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Datos erroneos","Revise los campos"));
            return false;
        }
      
    }
     
      public void cerrarSesion(){
        hsr.getSession().removeAttribute("userLogin");
        hsr.getSession().invalidate();
    }
   
}
