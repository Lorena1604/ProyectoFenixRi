/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;

import co.edu.fenixri.backend.entidades.Eps;
import co.edu.fenixri.backend.facade.EpsFacadeLocal;
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
@FacesConverter(value = "epsConvertidor")
@SessionScoped
public class EpsConvertidor implements Converter {

    /**
     * Creates a new instance of EpsConvertidor
     */
    public EpsConvertidor() {
    }

    @EJB
    private EpsFacadeLocal epsFacade;

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Eps> localidades = this.epsFacade.findAll();
        for (Eps objeto : localidades) {
            if (objeto.getIdEps()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

        @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Eps) objeto).getIdEps().toString();
        } else {
            return "";
        }
    }
    
    
}
