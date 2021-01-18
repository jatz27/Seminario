/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Alexis
 */
@Entity
@Table(name = "bloque_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloqueC.findAll", query = "SELECT b FROM BloqueC b")
    , @NamedQuery(name = "BloqueC.findByIdBloqueC", query = "SELECT b FROM BloqueC b WHERE b.idBloqueC = :idBloqueC")
    , @NamedQuery(name = "BloqueC.findByDescripcion", query = "SELECT b FROM BloqueC b WHERE b.descripcion = :descripcion")})
public class BloqueC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BLOQUE_C")
    private Integer idBloqueC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBloqueCat")
    private List<Bloque> bloqueList;

    public BloqueC() {
    }

    public BloqueC(Integer idBloqueC) {
        this.idBloqueC = idBloqueC;
    }

    public BloqueC(Integer idBloqueC, String descripcion) {
        this.idBloqueC = idBloqueC;
        this.descripcion = descripcion;
    }

    public Integer getIdBloqueC() {
        return idBloqueC;
    }

    public void setIdBloqueC(Integer idBloqueC) {
        this.idBloqueC = idBloqueC;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Bloque> getBloqueList() {
        return bloqueList;
    }

    public void setBloqueList(List<Bloque> bloqueList) {
        this.bloqueList = bloqueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBloqueC != null ? idBloqueC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloqueC)) {
            return false;
        }
        BloqueC other = (BloqueC) object;
        if ((this.idBloqueC == null && other.idBloqueC != null) || (this.idBloqueC != null && !this.idBloqueC.equals(other.idBloqueC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.BloqueC[ idBloqueC=" + idBloqueC + " ]";
    }
    
}
