/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.idPermiso = :idPermiso"),
    @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Permiso.findByUrlPermiso", query = "SELECT p FROM Permiso p WHERE p.urlPermiso = :urlPermiso"),
    @NamedQuery(name = "Permiso.findByIdPermidoPadre", query = "SELECT p FROM Permiso p WHERE p.idPermidoPadre = :idPermidoPadre")})
public class Permiso implements Serializable {

    @OneToMany(mappedBy = "idPermisoPadre", fetch = FetchType.LAZY)
    private List<Permiso> permisoList;
    @JoinColumn(name = "idPermisoPadre", referencedColumnName = "idPermiso")
    @ManyToOne(fetch = FetchType.LAZY)
    private Permiso idPermisoPadre;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermiso")
    private Integer idPermiso;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 120)
    @Column(name = "urlPermiso")
    private String urlPermiso;
    @Column(name = "idPermidoPadre")
    private Integer idPermidoPadre;
    @JoinTable(name = "asignarpermisos", joinColumns = {
        @JoinColumn(name = "idPermiso", referencedColumnName = "idPermiso")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlPermiso() {
        return urlPermiso;
    }

    public void setUrlPermiso(String urlPermiso) {
        this.urlPermiso = urlPermiso;
    }

    public Integer getIdPermidoPadre() {
        return idPermidoPadre;
    }

    public void setIdPermidoPadre(Integer idPermidoPadre) {
        this.idPermidoPadre = idPermidoPadre;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Permiso[ idPermiso=" + idPermiso + " ]";
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getIdPermisoPadre() {
        return idPermisoPadre;
    }

    public void setIdPermisoPadre(Permiso idPermisoPadre) {
        this.idPermisoPadre = idPermisoPadre;
    }
    
}
