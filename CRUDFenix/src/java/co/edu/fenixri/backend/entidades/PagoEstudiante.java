/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pagosestudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoEstudiante.findAll", query = "SELECT p FROM PagoEstudiante p"),
    @NamedQuery(name = "PagoEstudiante.findByIdpago", query = "SELECT p FROM PagoEstudiante p WHERE p.idpago = :idpago"),
    @NamedQuery(name = "PagoEstudiante.findByFechaPago", query = "SELECT p FROM PagoEstudiante p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "PagoEstudiante.findByMonto", query = "SELECT p FROM PagoEstudiante p WHERE p.monto = :monto"),
    @NamedQuery(name = "PagoEstudiante.findByMensualidad", query = "SELECT p FROM PagoEstudiante p WHERE p.mensualidad = :mensualidad")})
public class PagoEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private int monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensualidad")
    @Temporal(TemporalType.DATE)
    private Date mensualidad;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idEstudiante;

    public PagoEstudiante() {
    }

    public PagoEstudiante(Integer idpago) {
        this.idpago = idpago;
    }

    public PagoEstudiante(Integer idpago, Date fechaPago, int monto, Date mensualidad) {
        this.idpago = idpago;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.mensualidad = mensualidad;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(Date mensualidad) {
        this.mensualidad = mensualidad;
    }

    public Usuario getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Usuario idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoEstudiante)) {
            return false;
        }
        PagoEstudiante other = (PagoEstudiante) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.PagoEstudiante[ idpago=" + idpago + " ]";
    }
    
}
