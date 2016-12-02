/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "fichas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByIdFicha", query = "SELECT f FROM Ficha f WHERE f.idFicha = :idFicha"),
    @NamedQuery(name = "Ficha.findByNumeroRegistro", query = "SELECT f FROM Ficha f WHERE f.numeroRegistro = :numeroRegistro"),
    @NamedQuery(name = "Ficha.findByFechaIngreso", query = "SELECT f FROM Ficha f WHERE f.fechaIngreso = :fechaIngreso")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFicha")
    private Integer idFicha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numeroRegistro")
    private String numeroRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Lob
    @Column(name = "fotoUsuario")
    private byte[] fotoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha", fetch = FetchType.LAZY)
    private List<Sugerencia> sugerenciaList;
    @OneToMany(mappedBy = "ficha", fetch = FetchType.LAZY)
    private List<Asistencia> asistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private List<Evolucion> evolucionList;
    @JoinColumn(name = "epsUsuario", referencedColumnName = "idEps")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eps epsUsuario;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Ficha() {
    }

    public Ficha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Ficha(Integer idFicha, String numeroRegistro, Date fechaIngreso) {
        this.idFicha = idFicha;
        this.numeroRegistro = numeroRegistro;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public byte[] getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(byte[] fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    @XmlTransient
    public List<Sugerencia> getSugerenciaList() {
        return sugerenciaList;
    }

    public void setSugerenciaList(List<Sugerencia> sugerenciaList) {
        this.sugerenciaList = sugerenciaList;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @XmlTransient
    public List<Evolucion> getEvolucionList() {
        return evolucionList;
    }

    public void setEvolucionList(List<Evolucion> evolucionList) {
        this.evolucionList = evolucionList;
    }

    public Eps getEpsUsuario() {
        return epsUsuario;
    }

    public void setEpsUsuario(Eps epsUsuario) {
        this.epsUsuario = epsUsuario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicha != null ? idFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Ficha[ idFicha=" + idFicha + " ]";
    }
    
}
