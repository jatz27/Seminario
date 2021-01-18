package com.mycompany.model;

import com.mycompany.model.Bloque;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> descripcion;
    public static volatile SingularAttribute<Actividad, Integer> idActividad;
    public static volatile SingularAttribute<Actividad, Integer> punteo;
    public static volatile SingularAttribute<Actividad, Bloque> idBloque;

}