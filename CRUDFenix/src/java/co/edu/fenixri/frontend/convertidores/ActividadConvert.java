/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;


import co.edu.fenixri.backend.entidades.TipoActividad;
import co.edu.fenixri.backend.facade.TipoActividadFacadeLocal;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author morales
 */
@FacesConverter(value = "actividadConvert")
@SessionScoped
public class ActividadConvert implements Converter {

    /**
     * Creates a new instance of ActividadConvert
     */
    @EJB
    private TipoActividadFacadeLocal actividadFacade;
    public ActividadConvert() {
    }
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<TipoActividad> tipos = this.actividadFacade.findAll();
        for (TipoActividad objeto : tipos) {
            if (objeto.getIdtipoActividad() == Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((TipoActividad) objeto).getIdtipoActividad().toString();
        } else {
            return "";
        }
    }

    
}
