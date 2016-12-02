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
@Table(name = "tipodocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdtipoDocumentos", query = "SELECT t FROM TipoDocumento t WHERE t.idtipoDocumentos = :idtipoDocumentos"),
    @NamedQuery(name = "TipoDocumento.findByTipoDeDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDeDocumento = :tipoDeDocumento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoDocumentos")
    private Integer idtipoDocumentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipoDeDocumento")
    private String tipoDeDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idtipoDocumentos) {
        this.idtipoDocumentos = idtipoDocumentos;
    }

    public TipoDocumento(Integer idtipoDocumentos, String tipoDeDocumento) {
        this.idtipoDocumentos = idtipoDocumentos;
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Integer getIdtipoDocumentos() {
        return idtipoDocumentos;
    }

    public void setIdtipoDocumentos(Integer idtipoDocumentos) {
        this.idtipoDocumentos = idtipoDocumentos;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDocumentos != null ? idtipoDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idtipoDocumentos == null && other.idtipoDocumentos != null) || (this.idtipoDocumentos != null && !this.idtipoDocumentos.equals(other.idtipoDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.fenixri.backend.controladores.TipoDocumento[ idtipoDocumentos=" + idtipoDocumentos + " ]";
    }
    
}
