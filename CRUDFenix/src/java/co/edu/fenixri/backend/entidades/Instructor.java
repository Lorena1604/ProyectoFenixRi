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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByIdentificacion", query = "SELECT i FROM Instructor i WHERE i.identificacion = :identificacion")})
public class Instructor implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInstructor")
    private Integer idInstructor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "licenciaDeportiva")
    private byte[] licenciaDeportiva;
    @JoinColumn(name = "idInstructor", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion")
    private Integer identificacion;
    @JoinColumn(name = "identificacion", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor", fetch = FetchType.LAZY)
    private List<Respuesta> respuestaList;

    public Instructor() {
    }

    public Instructor(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Instructor(Integer identificacion, byte[] licenciaDeportiva) {
        this.identificacion = identificacion;
        this.licenciaDeportiva = licenciaDeportiva;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Instructor[ identificacion=" + identificacion + " ]";
    }

    public Instructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Instructor(Integer idInstructor, byte[] licenciaDeportiva) {
        this.idInstructor = idInstructor;
        this.licenciaDeportiva = licenciaDeportiva;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public byte[] getLicenciaDeportiva() {
        return licenciaDeportiva;
    }

    public void setLicenciaDeportiva(byte[] licenciaDeportiva) {
        this.licenciaDeportiva = licenciaDeportiva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstructor != null ? idInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idInstructor == null && other.idInstructor != null) || (this.idInstructor != null && !this.idInstructor.equals(other.idInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.entidades.Instructor[ idInstructor=" + idInstructor + " ]";
    }
    
}
