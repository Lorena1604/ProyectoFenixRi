/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;

import co.edu.fenixri.backend.entidades.Sugerencia;
import co.edu.fenixri.backend.facade.SugerenciaFacadeLocal;
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
@FacesConverter(value = "sugerenciaConvertidor")
@SessionScoped
public class SugerenciaConvertidor implements Converter {

    public SugerenciaConvertidor() {
    }

    @EJB
    private SugerenciaFacadeLocal sugerenciaFacade;

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Sugerencia> sugerencias = this.sugerenciaFacade.findAll();
        for (Sugerencia objeto : sugerencias) {
            if (objeto.getIdSugerencia()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }
    
        @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Sugerencia) objeto).getIdSugerencia().toString();
        } else {
            return "";
        }
    }

}
