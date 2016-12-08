/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;

import co.edu.fenixri.backend.entidades.Actividad;
import co.edu.fenixri.backend.entidades.Evidencia;
import co.edu.fenixri.backend.facade.ActividadFacadeLocal;
import co.edu.fenixri.backend.facade.EvidenciaFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
@Named(value = "evidenciaControlador")
@RequestScoped
public class EvidenciaControlador implements Serializable {

    /**
     * Creates a new instance of EvidenciControlador
     */
    @EJB
    private EvidenciaFacadeLocal evidenciaFacadeLocal;
    private Evidencia evidencia;

    @EJB
    private ActividadFacadeLocal actividadFacadeLocal;
    private List<Actividad> actividades;

    private Part fileUpload;
    private String texto;
    String url = "";

    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

    public EvidenciaControlador() {
        this.url = servletContext.getRealPath("/pdf/");
    }

    @PostConstruct
    public void init() {
        this.evidencia = new Evidencia();
    }

    //SETTER'S Y GETTER'S
    public Evidencia getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(Evidencia evidencia) {
        this.evidencia = evidencia;
    }

    public List<Actividad> getActividades() {
        actividades = actividadFacadeLocal.findAll();
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
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
    public String registroEvidencia() {
        String salida = "";
        try {
            evidenciaFacadeLocal.create(evidencia);
        } catch (Exception e) {
            salida = "Error " + e.getMessage();
        }
        return salida;
    }

    public List<Evidencia> listaEvidencias() {
        return evidenciaFacadeLocal.findAll();
    }

    public void eliminarEvidencia(Evidencia evidencia) {
        evidenciaFacadeLocal.remove(evidencia);
    }

    public String redireccion(Evidencia e) {
        evidencia = e;
        return "actualizarEvidencia";
    }

    public void actualizarEvidencia(Evidencia evidencia) {
        evidenciaFacadeLocal.edit(evidencia);

    }

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
                archivos.add(servletContext.getContextPath() + "/pdf/" + fichero.getName());
            }
        } else {
            archivos.add("no existe");
        }
        return archivos;
    }

}
