/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fenixri.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "evidencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e"),
    @NamedQuery(name = "Evidencia.findByIdEvidencias", query = "SELECT e FROM Evidencia e WHERE e.idEvidencias = :idEvidencias")})
public class Evidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvidencias")
    private Integer idEvidencias;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "documentos")
    private byte[] documentos;
    @JoinColumn(name = "idActividad", referencedColumnName = "idActividad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Actividad idActividad;

    public Evidencia() {
    }

    public Evidencia(Integer idEvidencias) {
        this.idEvidencias = idEvidencias;
    }

    public Evidencia(Integer idEvidencias, byte[] documentos) {
        this.idEvidencias = idEvidencias;
        this.documentos = documentos;
    }

    public Integer getIdEvidencias() {
        return idEvidencias;
    }

    public void setIdEvidencias(Integer idEvidencias) {
        this.idEvidencias = idEvidencias;
    }

    public byte[] getDocumentos() {
        return documentos;
    }

    public void setDocumentos(byte[] documentos) {
        this.documentos = documentos;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidencias != null ? idEvidencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidencia)) {
            return false;
        }
        Evidencia other = (Evidencia) object;
        if ((this.idEvidencias == null && other.idEvidencias != null) || (this.idEvidencias != null && !this.idEvidencias.equals(other.idEvidencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.Evidencia[ idEvidencias=" + idEvidencias + " ]";
    }
    
}
