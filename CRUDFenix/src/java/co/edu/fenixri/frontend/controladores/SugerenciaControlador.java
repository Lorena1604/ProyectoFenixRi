/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Sugerencia;
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

    //METODOS
    public void registroSugerencia() {
        sugerenciaFacadeLocal.create(sugerencia);
    }

    public List<Sugerencia> listaSugerencias() {
        return this.sugerenciaFacadeLocal.findAll();
    }

    public void eliminarSugerencia(Sugerencia sugerencia) {
        sugerenciaFacadeLocal.remove(sugerencia);
    }

    public String redireccion(Sugerencia s) {
        sugerencia = s;
        return "actualizarUsuario";
    }

    public void actualizarSugerencia(Sugerencia sugerencia) {
        sugerenciaFacadeLocal.edit(sugerencia);
    }

}
