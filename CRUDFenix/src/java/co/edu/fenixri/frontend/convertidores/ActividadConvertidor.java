/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;

import co.edu.fenixri.backend.entidades.Actividad;
import co.edu.fenixri.backend.facade.ActividadFacadeLocal;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Oscar Daniel Garzon
 */
@FacesConverter(value = "actividadConvertidor")
@SessionScoped
public class ActividadConvertidor implements Converter {

    /**
     * Creates a new instance of ActividadConvertidor
     */
    @EJB
    private ActividadFacadeLocal actividadFacadeLocal;

    public ActividadConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Actividad> actividades = this.actividadFacadeLocal.findAll();
        for (Actividad objeto : actividades) {
            if (objeto.getIdActividad()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Actividad) objeto).getIdActividad().toString();
        } else {
            return "";
        }
    }

}
