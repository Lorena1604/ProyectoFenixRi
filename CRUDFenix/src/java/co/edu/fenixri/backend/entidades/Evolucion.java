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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "evoluciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evolucion.findAll", query = "SELECT e FROM Evolucion e"),
    @NamedQuery(name = "Evolucion.findByIdEvolucion", query = "SELECT e FROM Evolucion e WHERE e.idEvolucion = :idEvolucion"),
    @NamedQuery(name = "Evolucion.findByFechaEvolucion", query = "SELECT e FROM Evolucion e WHERE e.fechaEvolucion = :fechaEvolucion"),
    @NamedQuery(name = "Evolucion.findByPeso", query = "SELECT e FROM Evolucion e WHERE e.peso = :peso"),
    @NamedQuery(name = "Evolucion.findByEstatura", query = "SELECT e FROM Evolucion e WHERE e.estatura = :estatura")})
public class Evolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvolucion")
    private Integer idEvolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEvolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaEvolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estatura")
    private String estatura;
    @JoinColumn(name = "idCinturon", referencedColumnName = "idCinturon")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cinturon idCinturon;
    @JoinColumn(name = "idFicha", referencedColumnName = "idFicha")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @JoinColumn(name = "idRendimiento", referencedColumnName = "idRendimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rendimiento idRendimiento;

    public Evolucion() {
    }

    public Evolucion(Integer idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public Evolucion(Integer idEvolucion, Date fechaEvolucion, String peso, String estatura) {
        this.idEvolucion = idEvolucion;
        this.fechaEvolucion = fechaEvolucion;
        this.peso = peso;
        this.estatura = estatura;
    }

    public Integer getIdEvolucion() {
        return idEvolucion;
    }

    public void setIdEvolucion(Integer idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public Date getFechaEvolucion() {
        return fechaEvolucion;
    }

    public void setFechaEvolucion(Date fechaEvolucion) {
        this.fechaEvolucion = fechaEvolucion;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public Cinturon getIdCinturon() {
        return idCinturon;
    }

    public void setIdCinturon(Cinturon idCinturon) {
        this.idCinturon = idCinturon;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public Rendimiento getIdRendimiento() {
        return idRendimiento;
    }

    public void setIdRendimiento(Rendimiento idRendimiento) {
        this.idRendimiento = idRendimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvolucion != null ? idEvolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evolucion)) {
            return false;
        }
        Evolucion other = (Evolucion) object;
        if ((this.idEvolucion == null && other.idEvolucion != null) || (this.idEvolucion != null && !this.idEvolucion.equals(other.idEvolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Evolucion[ idEvolucion=" + idEvolucion + " ]";
    }
    
}
