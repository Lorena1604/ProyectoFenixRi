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
@Table(name = "cinturones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cinturon.findAll", query = "SELECT c FROM Cinturon c"),
    @NamedQuery(name = "Cinturon.findByIdCinturon", query = "SELECT c FROM Cinturon c WHERE c.idCinturon = :idCinturon"),
    @NamedQuery(name = "Cinturon.findByCinturon", query = "SELECT c FROM Cinturon c WHERE c.cinturon = :cinturon"),
    @NamedQuery(name = "Cinturon.findByRango", query = "SELECT c FROM Cinturon c WHERE c.rango = :rango")})
public class Cinturon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCinturon")
    private Integer idCinturon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cinturon")
    private String cinturon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rango")
    private String rango;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCinturon", fetch = FetchType.LAZY)
    private List<Evolucion> evolucionList;

    public Cinturon() {
    }

    public Cinturon(Integer idCinturon) {
        this.idCinturon = idCinturon;
    }

    public Cinturon(Integer idCinturon, String cinturon, String rango) {
        this.idCinturon = idCinturon;
        this.cinturon = cinturon;
        this.rango = rango;
    }

    public Integer getIdCinturon() {
        return idCinturon;
    }

    public void setIdCinturon(Integer idCinturon) {
        this.idCinturon = idCinturon;
    }

    public String getCinturon() {
        return cinturon;
    }

    public void setCinturon(String cinturon) {
        this.cinturon = cinturon;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
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
        hash += (idCinturon != null ? idCinturon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinturon)) {
            return false;
        }
        Cinturon other = (Cinturon) object;
        if ((this.idCinturon == null && other.idCinturon != null) || (this.idCinturon != null && !this.idCinturon.equals(other.idCinturon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Cinturon[ idCinturon=" + idCinturon + " ]";
    }
    
}
