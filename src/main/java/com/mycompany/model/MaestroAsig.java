/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "maestro_asig")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaestroAsig.findAll", query = "SELECT m FROM MaestroAsig m")
    , @NamedQuery(name = "MaestroAsig.findByIdMaestroAsig", query = "SELECT m FROM MaestroAsig m WHERE m.idMaestroAsig = :idMaestroAsig")})
public class MaestroAsig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MAESTRO_ASIG")
    private Integer idMaestroAsig;
    @JoinColumn(name = "ID_GRADO", referencedColumnName = "ID_GRADO")
    @ManyToOne(optional = false)
    private Grado idGrado;
    @JoinColumn(name = "ID_MAESTRO", referencedColumnName = "ID_MAESTRO")
    @ManyToOne(optional = false)
    private Maestro idMaestro;
    @JoinColumn(name = "ID_SECCION", referencedColumnName = "ID_SECCION")
    @ManyToOne(optional = false)
    private Seccion idSeccion;

    public MaestroAsig() {
    }

    public MaestroAsig(Integer idMaestroAsig) {
        this.idMaestroAsig = idMaestroAsig;
    }

    public Integer getIdMaestroAsig() {
        return idMaestroAsig;
    }

    public void setIdMaestroAsig(Integer idMaestroAsig) {
        this.idMaestroAsig = idMaestroAsig;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public Maestro getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Maestro idMaestro) {
        this.idMaestro = idMaestro;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaestroAsig != null ? idMaestroAsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaestroAsig)) {
            return false;
        }
        MaestroAsig other = (MaestroAsig) object;
        if ((this.idMaestroAsig == null && other.idMaestroAsig != null) || (this.idMaestroAsig != null && !this.idMaestroAsig.equals(other.idMaestroAsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.MaestroAsig[ idMaestroAsig=" + idMaestroAsig + " ]";
    }
    
}
