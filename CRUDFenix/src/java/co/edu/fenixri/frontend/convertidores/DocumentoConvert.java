/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.convertidores;

import co.edu.fenixri.backend.entidades.TipoDocumento;
import co.edu.fenixri.backend.facade.TipoDocumentoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author SENA
 */
@FacesConverter(value = "documentoConvert")
@SessionScoped
public class DocumentoConvert implements Converter{

    /**
     * Creates a new instance of DocumentoConvert
     */
    @EJB
    private TipoDocumentoFacadeLocal documentoFacade;
    public DocumentoConvert() {
    }
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<TipoDocumento> tipos = this.documentoFacade.findAll();
        for (TipoDocumento objeto : tipos) {
            if (objeto.getIdtipoDocumentos() == Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((TipoDocumento) objeto).getIdtipoDocumentos().toString();
        } else {
            return "";
        }
    }

}
