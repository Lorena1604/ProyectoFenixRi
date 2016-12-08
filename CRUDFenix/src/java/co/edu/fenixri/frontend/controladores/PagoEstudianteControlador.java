/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.PagoEstudiante;
import co.edu.fenixri.backend.entidades.Usuario;
import co.edu.fenixri.backend.facade.PagoEstudianteFacadeLocal;
import co.edu.fenixri.backend.facade.UsuarioFacadeLocal;
import java.util.Calendar;
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

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> usuarios;

    public PagoEstudianteControlador() {
    }

    @PostConstruct
    public void init() {
        pagoEstudiante = new PagoEstudiante();
    }

    public PagoEstudiante getPagoEstudiante() {
        return pagoEstudiante;
    }

    public void setPagoEstudiante(PagoEstudiante pagoEstudiante) {
        this.pagoEstudiante = pagoEstudiante;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioFacadeLocal.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
/*        Calendar c = Calendar.getInstance();

    c.setTime (PagoEstudiante.mensualidad);

    c.set (Calendar.DAY, 
    01);
    fromDate  = c.getTime();
*/
    
    
//METODOS
    public String registrarPagoEstudiante() {
        String salida = "";
        try {
            pagoEstudianteFacadeLocal.create(pagoEstudiante);
        } catch (Exception e) {
            salida = "Error " + e.getMessage();
        }
        return salida;
    }

    public List<PagoEstudiante> listarPagoEstudiante() {
        return pagoEstudianteFacadeLocal.findAll();
    }

    public void eliminarPagoEstudiante(PagoEstudiante pagoEstudiante) {
        pagoEstudianteFacadeLocal.remove(pagoEstudiante);

    }

    public String redireccion(PagoEstudiante p) {
        this.pagoEstudiante = p;
        return "actualizarPagoEstudiante";
    }

    public void actualizarPagoEstudiante(PagoEstudiante pagoEstudiante) {
        pagoEstudianteFacadeLocal.edit(pagoEstudiante);
    }

}
