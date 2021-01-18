package com.mycompany.model;

import com.mycompany.model.Alumno;
import com.mycompany.model.Bloque;
import com.mycompany.model.MaestroAsig;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Grado.class)
public class Grado_ { 

    public static volatile SingularAttribute<Grado, String> descripcion;
    public static volatile ListAttribute<Grado, Bloque> bloqueList;
    public static volatile SingularAttribute<Grado, Integer> idGrado;
    public static volatile ListAttribute<Grado, MaestroAsig> maestroAsigList;
    public static volatile ListAttribute<Grado, Alumno> alumnoList;

}