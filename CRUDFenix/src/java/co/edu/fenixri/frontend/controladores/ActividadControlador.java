/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.frontend.controladores;


import co.edu.fenixri.backend.entidades.Actividad;
import co.edu.fenixri.backend.entidades.TipoActividad;
import co.edu.fenixri.backend.facade.ActividadFacadeLocal;
import co.edu.fenixri.backend.facade.TipoActividadFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author morales
 */
@Named(value = "actividadControlador")
@RequestScoped
public class ActividadControlador {

    /**
     * Creates a new instance of ActividadControlador
     */
    @EJB
    private ActividadFacadeLocal actividadFacade;
    @EJB
    private TipoActividadFacadeLocal tipoActividadFacade;
    private Actividad actividad;
    private List<TipoActividad> tipoActividad;
    
    public ActividadControlador() {
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<TipoActividad> getTipoActividad() {
        tipoActividad   = tipoActividadFacade.findAll();
        
        return tipoActividad;
    }

    public void setTipoActividad(List<TipoActividad> tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
    @PostConstruct
    public void init(){
        actividad = new Actividad();
        
    }
    public String registrarActividad(){
        String salida = "";
        try{
         actividadFacade.create(actividad);
        }catch(Exception e){
          salida = "Error " + e.getMessage();
        }
        return salida;
    }
    public List<Actividad> listarUsuarios() {
        return actividadFacade.findAll();
    }

    public void removerActividad(Actividad r) {
        actividadFacade.remove(r);

    }
    public String actualizarActividad(Actividad acti)
    {
        this.actividad=acti;
        return "Actualizar";
    }
    
/*    public void actualizarProfesor()
    {
        try
        {
            FacesContext objFacesContext=FacesContext.getCurrentInstance();
            ExternalContext objExternalContext=objFacesContext.getExternalContext();
            Map parametros=objExternalContext.getRequestParameterMap();
            
            Actividad objActividad =new Actividad();
            objActividad.setFechaYhoraDeActividad(parametros.get("fechaYhoraDeActividad"));
            objActividad.setLugar(""+parametros.get("lugar"));
            objActividad.setDescripcionActividad(""+parametros.get("descripcionActividad"));
            TipoActividad objTipo = new TipoActividad();
            objTipo.setIdtipoActividad(Integer.parseInt(""+parametros.get("descripcion")));
            objActividad.setIdActividad(objTipo);
            actividadFacade.edit(objActividad);
            this.actividad = new Actividad();
            estado=3;  
          
        }
        catch(Exception ex)
        {
            estado=4;
        }
    }*/
    
}
