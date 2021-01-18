package com.mycompany.model;

import com.mycompany.model.MaestroAsig;
import com.mycompany.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile SingularAttribute<Maestro, String> segundoNombre;
    public static volatile SingularAttribute<Maestro, String> apellidoCasada;
    public static volatile SingularAttribute<Maestro, String> tercerNombre;
    public static volatile ListAttribute<Maestro, Usuario> usuarioList;
    public static volatile SingularAttribute<Maestro, String> primerNombre;
    public static volatile SingularAttribute<Maestro, String> primerApellido;
    public static volatile SingularAttribute<Maestro, Integer> idMaestro;
    public static volatile ListAttribute<Maestro, MaestroAsig> maestroAsigList;
    public static volatile SingularAttribute<Maestro, String> correo;
    public static volatile SingularAttribute<Maestro, String> segundoApellido;
    public static volatile SingularAttribute<Maestro, String> telefono;

}