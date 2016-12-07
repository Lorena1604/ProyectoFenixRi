/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.PagoEstudiante;
import co.edu.fenixri.backend.facade.PagoEstudianteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Oscar Garzon
 */
@Named(value = "pagoEstudianteControlador")
@RequestScoped
public class PagoEstudianteControlador {

    @EJB
    private PagoEstudianteFacadeLocal pagoEstudianteFacadeLocal;

    private PagoEstudiante pagoEstudiante;

    public PagoEstudianteControlador() {
    }

    public PagoEstudiante getPagoEstudiante() {
        return pagoEstudiante;
    }

    public void setPagoEstudiante(PagoEstudiante pagoEstudiante) {
        this.pagoEstudiante = pagoEstudiante;
    }

    @PostConstruct
    public void init() {
        pagoEstudiante = new PagoEstudiante();
    }

        public void registroPagoEstudiante() {
        pagoEstudianteFacadeLocal.create(pagoEstudiante);
    }

    public List<PagoEstudiante> listaPagoEstudiante() {
        return this.pagoEstudianteFacadeLocal.findAll();
    }

/*    public void eliminarPagoEstudiante(PagoEstudiante pagoEstudiante) {
        pagoEstudianteFacadeLocal.remove(pagoEstudiante);
    }

    public String redireccion(PagoEstudiante p) {
        pagoEstudiante = p;
        return "actualizarPagoEstudiante";
    }

    public void actualizarUsuario(PagoEstudiante pagoEstudiante) {
        pagoEstudianteFacadeLocal.edit(pagoEstudiante);
    }*/

}
