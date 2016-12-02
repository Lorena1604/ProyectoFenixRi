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
@Table(name = "rendimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rendimiento.findAll", query = "SELECT r FROM Rendimiento r"),
    @NamedQuery(name = "Rendimiento.findByIdRendimiento", query = "SELECT r FROM Rendimiento r WHERE r.idRendimiento = :idRendimiento"),
    @NamedQuery(name = "Rendimiento.findByDescripcion", query = "SELECT r FROM Rendimiento r WHERE r.descripcion = :descripcion")})
public class Rendimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRendimiento")
    private Integer idRendimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRendimiento", fetch = FetchType.LAZY)
    private List<Evolucion> evolucionList;

    public Rendimiento() {
    }

    public Rendimiento(Integer idRendimiento) {
        this.idRendimiento = idRendimiento;
    }

    public Rendimiento(Integer idRendimiento, String descripcion) {
        this.idRendimiento = idRendimiento;
        this.descripcion = descripcion;
    }

    public Integer getIdRendimiento() {
        return idRendimiento;
    }

    public void setIdRendimiento(Integer idRendimiento) {
        this.idRendimiento = idRendimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Evolucion> getEvolucionList() {
        return evolucionList;
    }

    public void setEvolucionList(List<Evolucion> evolucionList) {
        this.evolucionList = evolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRendimiento != null ? idRendimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rendimiento)) {
            return false;
        }
        Rendimiento other = (Rendimiento) object;
        if ((this.idRendimiento == null && other.idRendimiento != null) || (this.idRendimiento != null && !this.idRendimiento.equals(other.idRendimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Rendimiento[ idRendimiento=" + idRendimiento + " ]";
    }
    
}
