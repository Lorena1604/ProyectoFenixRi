/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.convertidores;


import co.edu.fenixri.backend.entidades.Localidad;
import co.edu.fenixri.backend.facade.LocalidadFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "localidadConvertidor")
@SessionScoped
public class LocalidadConvertidor implements Converter{

   
    public LocalidadConvertidor() {
    }
    @EJB
    private LocalidadFacadeLocal localidadFacade;
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Localidad> localidades = this.localidadFacade.findAll();
        for (Localidad objeto : localidades) {
            if (objeto.getIdLocalidad()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Localidad) objeto).getIdLocalidad().toString();
        } else {
            return "";
        }
    }
}
