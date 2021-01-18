package com.mycompany.model;

import com.mycompany.model.Bloque;
import com.mycompany.model.Grado;
import com.mycompany.model.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:17")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Integer> idAlumno;
    public static volatile SingularAttribute<Alumno, String> segundoNombre;
    public static volatile SingularAttribute<Alumno, String> tercerNombre;
    public static volatile ListAttribute<Alumno, Bloque> bloqueList;
    public static volatile SingularAttribute<Alumno, String> primerNombre;
    public static volatile SingularAttribute<Alumno, String> primerApellido;
    public static volatile SingularAttribute<Alumno, Grado> idGrado;
    public static volatile SingularAttribute<Alumno, String> segundoApellido;
    public static volatile SingularAttribute<Alumno, String> telefono;
    public static volatile SingularAttribute<Alumno, Seccion> idSeccion;

}