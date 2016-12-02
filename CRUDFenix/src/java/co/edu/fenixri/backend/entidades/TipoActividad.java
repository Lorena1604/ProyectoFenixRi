/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tipoactividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t"),
    @NamedQuery(name = "TipoActividad.findByIdtipoActividad", query = "SELECT t FROM TipoActividad t WHERE t.idtipoActividad = :idtipoActividad"),
    @NamedQuery(name = "TipoActividad.findByDescripcion", query = "SELECT t FROM TipoActividad t WHERE t.descripcion = :descripcion")})
public class TipoActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoActividad")
    private Integer idtipoActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeActividad", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;

    public TipoActividad() {
    }

    public TipoActividad(Integer idtipoActividad) {
        this.idtipoActividad = idtipoActividad;
    }

    public TipoActividad(Integer idtipoActividad, String descripcion) {
        this.idtipoActividad = idtipoActividad;
        this.descripcion = descripcion;
    }

    public Integer getIdtipoActividad() {
        return idtipoActividad;
    }

    public void setIdtipoActividad(Integer idtipoActividad) {
        this.idtipoActividad = idtipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoActividad != null ? idtipoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.idtipoActividad == null && other.idtipoActividad != null) || (this.idtipoActividad != null && !this.idtipoActividad.equals(other.idtipoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.TipoActividad[ idtipoActividad=" + idtipoActividad + " ]";
    }
    
}
