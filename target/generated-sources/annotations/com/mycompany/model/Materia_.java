package com.mycompany.model;

import com.mycompany.model.Bloque;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, String> descripcion;
    public static volatile ListAttribute<Materia, Bloque> bloqueList;
    public static volatile SingularAttribute<Materia, Integer> idMateria;

}