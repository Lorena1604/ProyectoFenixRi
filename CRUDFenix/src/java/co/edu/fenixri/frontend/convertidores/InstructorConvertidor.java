/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;

import co.edu.fenixri.backend.entidades.Instructor;
import co.edu.fenixri.backend.facade.InstructorFacadeLocal;
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
@FacesConverter(value = "instructorConvertidor")
@SessionScoped
public class InstructorConvertidor implements Converter{
    
        @EJB        
    private InstructorFacadeLocal instructorFacade;
        
    /**
     * Creates a new instance of instructorConvertidor
     */
    public InstructorConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Instructor> instructores = this.instructorFacade.findAll();
        for (Instructor objeto : instructores) {
            if (objeto.getIdInstructor()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Instructor) objeto).getIdInstructor().toString();
        } else {
            return "";
        }
    }
}
