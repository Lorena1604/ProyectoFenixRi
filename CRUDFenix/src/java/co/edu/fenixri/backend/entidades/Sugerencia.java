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
@Table(name = "sugerencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sugerencia.findAll", query = "SELECT s FROM Sugerencia s"),
    @NamedQuery(name = "Sugerencia.findByIdSugerencia", query = "SELECT s FROM Sugerencia s WHERE s.idSugerencia = :idSugerencia"),
    @NamedQuery(name = "Sugerencia.findByFecha", query = "SELECT s FROM Sugerencia s WHERE s.fecha = :fecha")})
public class Sugerencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSugerencia")
    private Integer idSugerencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sugerencia")
    private String sugerencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSugerencia", fetch = FetchType.LAZY)
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "ficha", referencedColumnName = "idFicha")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha ficha;

    public Sugerencia() {
    }

    public Sugerencia(Integer idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public Sugerencia(Integer idSugerencia, String sugerencia, Date fecha) {
        this.idSugerencia = idSugerencia;
        this.sugerencia = sugerencia;
        this.fecha = fecha;
    }

    public Integer getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(Integer idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSugerencia != null ? idSugerencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sugerencia)) {
            return false;
        }
        Sugerencia other = (Sugerencia) object;
        if ((this.idSugerencia == null && other.idSugerencia != null) || (this.idSugerencia != null && !this.idSugerencia.equals(other.idSugerencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Sugerencia[ idSugerencia=" + idSugerencia + " ]";
    }
    
}
