/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;


import co.edu.fenixri.backend.entidades.Ficha;
import co.edu.fenixri.backend.facade.FichaFacadeLocal;

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
@FacesConverter(value = "fichaConvertidor")
@SessionScoped
public class FichaConvertidor implements Converter {

    /**
     * Creates a new instance of ActividadConvert
     */
    @EJB
    private FichaFacadeLocal fichaFacadeLocal;
    public FichaConvertidor() {
    }
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Ficha> fichas = this.fichaFacadeLocal.findAll();
        for (Ficha objeto : fichas) {
            if (objeto.getIdFicha()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Ficha) objeto).getIdFicha().toString();
        } else {
            return "";
        }
    }

    
}
