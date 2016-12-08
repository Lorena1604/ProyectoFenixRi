/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Eps;
import co.edu.fenixri.backend.entidades.Ficha;
import co.edu.fenixri.backend.entidades.Usuario;
import co.edu.fenixri.backend.facade.EpsFacadeLocal;
import co.edu.fenixri.backend.facade.FichaFacadeLocal;
import co.edu.fenixri.backend.facade.UsuarioFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Oscar Daniel Garzon
 */
@Named(value = "fichaControlador")
@RequestScoped
public class fichaControlador {

    /**
     * Creates a new instance of fichaControlador
     */
    @EJB
    private FichaFacadeLocal fichaFacadeLocal;
    private Ficha ficha;

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> usuarios;

    @EJB
    private EpsFacadeLocal epsFacadeLocal;
    private List<Eps> epss;

    
    private Part fileUpload;
    private String texto;
    String url = "";

    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

    
    
    public fichaControlador() {
        this.url = servletContext.getRealPath("/jpg/");
    }

    @PostConstruct
    public void init() {
        ficha = new Ficha();
    }

//GETTERS Y SETTERS    
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioFacadeLocal.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Eps> getEpss() {
        epss = epsFacadeLocal.findAll();
        return epss;
    }

    public void setEpss(List<Eps> epss) {
        this.epss = epss;
    }

    
    
    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Part getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(Part fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //METODOS
    public String registrarFicha() {
        String salida = "";
        try {
            fichaFacadeLocal.create(ficha);
        } catch (Exception e) {
            salida = "Error " + e.getMessage();
        }
        return salida;
    }

    public List<Ficha> listarFicha() {
        return fichaFacadeLocal.findAll();
    }

    public void eliminarFicha(Ficha ficha) {
        fichaFacadeLocal.remove(ficha);

    }

    public String redireccion(Ficha f) {
        this.ficha = f;
        return "actualizarFicha";
    }

    public void actualizarFicha(Ficha ficha) {
        fichaFacadeLocal.edit(ficha);
    }

    
    
        /**
     * En este médoto se recibe el evento desde primefaces en donde viene el archivo que se desea subir
     * Previamente se ha definido la ruta de la carpeta referente al proyecto con la variable url
     * El proceso es tomar el archivo que se cargar en terminos de Inputstream y se crea y se escribe en un nuevo archivo
     * en la ruta en el servidor
     * @param event 
     */
    
    
    public void cargarArchivo(FileUploadEvent event) {

        try {
            InputStream in = event.getFile().getInputstream();
            //si se desea cambiar el nombre del archivo generado se cambia este atributo event.getFile().getFileName()
            OutputStream out = new FileOutputStream(new File(url, event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);

            }
            in.close();
            out.flush();
            out.close();
            FacesMessage msg = new FacesMessage("archivo creado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error al cargar el archivo", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    /**
     * Este método lista el contenido de la carpeta y lo devolvemos como un
     * arraylist para pintar en una tabla si se desea traer mas datos del
     * archivo, se debe crear una clase con los atributos
     *
     * @return
     */
    public ArrayList<String> listarContenido() {
        File directorio = new File(url);
        ArrayList<String> archivos = new ArrayList<>();
        if (directorio.exists()) {
            File[] ficheros = directorio.listFiles();
            for (File fichero : ficheros) {
                archivos.add(servletContext.getContextPath() + "/jpg/" + fichero.getName());
            }
        } else {
            archivos.add("no existe");
        }
        return archivos;
    }

}
