package com.mycompany.model;

import com.mycompany.model.Alumno;
import com.mycompany.model.Bloque;
import com.mycompany.model.MaestroAsig;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, String> descripcion;
    public static volatile ListAttribute<Seccion, Bloque> bloqueList;
    public static volatile ListAttribute<Seccion, MaestroAsig> maestroAsigList;
    public static volatile ListAttribute<Seccion, Alumno> alumnoList;
    public static volatile SingularAttribute<Seccion, Integer> idSeccion;

}