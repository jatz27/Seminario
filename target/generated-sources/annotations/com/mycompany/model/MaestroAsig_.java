package com.mycompany.model;

import com.mycompany.model.Grado;
import com.mycompany.model.Maestro;
import com.mycompany.model.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(MaestroAsig.class)
public class MaestroAsig_ { 

    public static volatile SingularAttribute<MaestroAsig, Grado> idGrado;
    public static volatile SingularAttribute<MaestroAsig, Maestro> idMaestro;
    public static volatile SingularAttribute<MaestroAsig, Integer> idMaestroAsig;
    public static volatile SingularAttribute<MaestroAsig, Seccion> idSeccion;

}