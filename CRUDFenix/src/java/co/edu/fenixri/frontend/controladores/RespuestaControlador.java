/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Instructor;
import co.edu.fenixri.backend.entidades.Respuesta;
import co.edu.fenixri.backend.entidades.Sugerencia;
import co.edu.fenixri.backend.facade.InstructorFacadeLocal;
import co.edu.fenixri.backend.facade.RespuestaFacadeLocal;
import co.edu.fenixri.backend.facade.SugerenciaFacadeLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Oscar Daniel Garzon
 */
@Named(value = "respuestaControlador")
@RequestScoped
public class RespuestaControlador implements Serializable {

    /**
     * Creates a new instance of RespuestaControlador
     */
    @EJB
    private RespuestaFacadeLocal respuestaFacade;
    private Respuesta respuesta;

    @EJB
    private SugerenciaFacadeLocal sugerenciaFacade;
    private List<Sugerencia> sugerencias;

    @EJB
    private InstructorFacadeLocal instructorFacade;
    private List<Instructor> instructores;

    public RespuestaControlador() {
    }

    @PostConstruct
    public void init() {
        respuesta = new Respuesta();
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public List<Sugerencia> getSugerencias() {
        sugerencias = sugerenciaFacade.findAll();
        return sugerencias;
    }

    public void setSugerencias(List<Sugerencia> sugerencias) {
        this.sugerencias = sugerencias;
    }

    public List<Instructor> getInstructores() {
        instructores = instructorFacade.findAll();
        return instructores;
    }

    public void setInstructores(List<Instructor> instructores) {
        this.instructores = instructores;
    }

    //METODOS
    public String registrarRespuesta() {
        String salida = "";
        try {
            respuestaFacade.create(respuesta);
        } catch (Exception e) {
            salida = "Error " + e.getMessage();
        }
        return salida;
    }

    public List<Respuesta> listarRespuesta() {
        return respuestaFacade.findAll();
    }

    public void eliminarRespuesta(Respuesta respuesta) {
        respuestaFacade.remove(respuesta);

    }

    public String redireccion(Respuesta r) {
        this.respuesta = r;
        return "actualizarRespuesta";
    }

    public void actualizarRespuesta(Respuesta respuesta) {
        respuestaFacade.edit(respuesta);
    }

}
