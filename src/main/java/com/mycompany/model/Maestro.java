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
@Table(name = "maestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m")
    , @NamedQuery(name = "Maestro.findByIdMaestro", query = "SELECT m FROM Maestro m WHERE m.idMaestro = :idMaestro")
    , @NamedQuery(name = "Maestro.findByPrimerNombre", query = "SELECT m FROM Maestro m WHERE m.primerNombre = :primerNombre")
    , @NamedQuery(name = "Maestro.findBySegundoNombre", query = "SELECT m FROM Maestro m WHERE m.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Maestro.findByTercerNombre", query = "SELECT m FROM Maestro m WHERE m.tercerNombre = :tercerNombre")
    , @NamedQuery(name = "Maestro.findByPrimerApellido", query = "SELECT m FROM Maestro m WHERE m.primerApellido = :primerApellido")
    , @NamedQuery(name = "Maestro.findBySegundoApellido", query = "SELECT m FROM Maestro m WHERE m.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Maestro.findByApellidoCasada", query = "SELECT m FROM Maestro m WHERE m.apellidoCasada = :apellidoCasada")
    , @NamedQuery(name = "Maestro.findByTelefono", query = "SELECT m FROM Maestro m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "Maestro.findByCorreo", query = "SELECT m FROM Maestro m WHERE m.correo = :correo")})
public class Maestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MAESTRO")
    private Integer idMaestro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "TERCER_NOMBRE")
    private String tercerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "APELLIDO_CASADA")
    private String apellidoCasada;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestro")
    private List<MaestroAsig> maestroAsigList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestro")
    private List<Usuario> usuarioList;

    public Maestro() {
    }

    public Maestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public Maestro(Integer idMaestro, String primerNombre, String primerApellido) {
        this.idMaestro = idMaestro;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Integer getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<MaestroAsig> getMaestroAsigList() {
        return maestroAsigList;
    }

    public void setMaestroAsigList(List<MaestroAsig> maestroAsigList) {
        this.maestroAsigList = maestroAsigList;
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
        hash += (idMaestro != null ? idMaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maestro)) {
            return false;
        }
        Maestro other = (Maestro) object;
        if ((this.idMaestro == null && other.idMaestro != null) || (this.idMaestro != null && !this.idMaestro.equals(other.idMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Maestro[ idMaestro=" + idMaestro + " ]";
    }
    
}
