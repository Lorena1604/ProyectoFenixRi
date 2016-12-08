/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Ficha;
import co.edu.fenixri.backend.entidades.Instructor;
import co.edu.fenixri.backend.entidades.Sugerencia;
import co.edu.fenixri.backend.facade.FichaFacadeLocal;
import co.edu.fenixri.backend.facade.InstructorFacadeLocal;
import co.edu.fenixri.backend.facade.SugerenciaFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Oscar Garzon
 */
@Named(value = "sugerenciaControlador")
@RequestScoped
public class SugerenciaControlador implements Serializable {

    /**
     * Creates a new instance of SugerenciaControlador
     */
    @EJB
    private SugerenciaFacadeLocal sugerenciaFacadeLocal;
    
    private Sugerencia sugerencia;
    
    @EJB
    private FichaFacadeLocal fichaFacadeLocal;
    private List<Ficha> fichas;
    

    
    public SugerenciaControlador() {
    }
    
    @PostConstruct
    public void init() {
        this.sugerencia = new Sugerencia();
    }

    //SETTER'S Y GETTER'S
    public Sugerencia getSugerencia() {
        return sugerencia;
    }
    
    public void setSugerencia(Sugerencia sugerencia) {
        this.sugerencia = sugerencia;
    }
    
    public List<Ficha> getFichas() {
        fichas = fichaFacadeLocal.findAll();
        return fichas;
    }
    
    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    
    //METODOS
    public String registroSugerencia() {
        String salida = "";
        try {
            sugerenciaFacadeLocal.create(sugerencia);
        } catch (Exception e) {
            salida = "Error " + e.getMessage();
        }
        return salida;
    }
    
    public List<Sugerencia> listaSugerencias() {
        return sugerenciaFacadeLocal.findAll();
    }
    
    public void eliminarSugerencia(Sugerencia sugerencia) {
        sugerenciaFacadeLocal.remove(sugerencia);
    }
    
    public String redireccion(Sugerencia s) {
        sugerencia = s;
        return "actualizarSugerencia";
    }
    
    public void actualizarSugerencia(Sugerencia sugerencia) {
        sugerenciaFacadeLocal.edit(sugerencia);
        
    }
    
}
