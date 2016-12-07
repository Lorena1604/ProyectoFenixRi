/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Estado;
import co.edu.fenixri.backend.entidades.Localidad;
import co.edu.fenixri.backend.entidades.Telefono;
import co.edu.fenixri.backend.entidades.TipoDocumento;
import co.edu.fenixri.backend.entidades.Usuario;
import co.edu.fenixri.backend.facade.EstadoFacadeLocal;
import co.edu.fenixri.backend.facade.LocalidadFacadeLocal;
import co.edu.fenixri.backend.facade.TelefonoFacadeLocal;
import co.edu.fenixri.backend.facade.TipoDocumentoFacadeLocal;
import co.edu.fenixri.backend.facade.UsuarioFacadeLocal;
import co.edu.fenixri.backend.negocio.SessionBeanLogin;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "usuarioControlador")
@RequestScoped
public class UsuarioControlador {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private TelefonoFacadeLocal telefonoFacade;
    @EJB
    private TipoDocumentoFacadeLocal tipoDocumentoFacade;
    @EJB
    private EstadoFacadeLocal estadoFacade;
    @EJB
    private LocalidadFacadeLocal localidadFacade;

    @PersistenceContext
    EntityManager em;

    private Usuario usuario;
    private Telefono telefono;
    private List<TipoDocumento> tipoDocumento;
    private List<Estado> estado;
    private List<Localidad> localidad;

    public UsuarioControlador() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public List<TipoDocumento> getTipoDocumento() {
        tipoDocumento = tipoDocumentoFacade.findAll();
        return tipoDocumento;
    }

    public void setTipoDocumento(List<TipoDocumento> tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Estado> getEstado() {
        estado = estadoFacade.findAll();
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public List<Localidad> getLocalidad() {
        return localidadFacade.findAll();
    }

    public void setLocalidad(List<Localidad> localidad) {
        this.localidad = localidad;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        telefono = new Telefono();

    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDFenixPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }

   
    public String registrarUsuario(){
        String respuesta = null;
        try{
            
          telefono.setIdUsuario(usuario);
          telefonoFacade.create(telefono);
          usuarioFacade.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Usuario registrado exitosamente"));
            respuesta = "index?Faces-redirect=true";
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Error al registrar el usuario"));
        }
        
        return respuesta;
    }

    
    public List<Usuario> listarUsuarios() {
        return usuarioFacade.findAll();
    }

    public void eliminarUsuario(Usuario r) {
        usuarioFacade.remove(r);

    }

    public String modificar(Usuario item) {
        this.usuario = item;
        return "modificarUsuario";
    }

    public void modificarUsuario() {
        usuarioFacade.edit(usuario);
    }
 
}
