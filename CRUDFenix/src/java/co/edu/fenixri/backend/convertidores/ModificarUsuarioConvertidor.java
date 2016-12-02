/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.convertidores;

import co.edu.fenixri.backend.entidades.Estado;
import co.edu.fenixri.backend.entidades.Usuario;
import co.edu.fenixri.backend.facade.EstadoFacadeLocal;
import co.edu.fenixri.backend.facade.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "modificarUsuarioConvertidor")
@SessionScoped
public class ModificarUsuarioConvertidor implements Converter{

   
    public ModificarUsuarioConvertidor() {
    }
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Usuario> usuarios = this.usuarioFacade.findAll();
        for (Usuario objeto : usuarios) {
            if (objeto.getIdUsuario()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Usuario) objeto).getIdUsuario().toString();
        } else {
            return "";
        }
    }
}
