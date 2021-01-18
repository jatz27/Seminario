package com.mycompany.model;

import com.mycompany.model.Actividad;
import com.mycompany.model.Alumno;
import com.mycompany.model.BloqueC;
import com.mycompany.model.Grado;
import com.mycompany.model.Materia;
import com.mycompany.model.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-15T17:19:18")
@StaticMetamodel(Bloque.class)
public class Bloque_ { 

    public static volatile SingularAttribute<Bloque, Alumno> idAlumno;
    public static volatile ListAttribute<Bloque, Actividad> actividadList;
    public static volatile SingularAttribute<Bloque, Materia> idMateria;
    public static volatile SingularAttribute<Bloque, Integer> punteo;
    public static volatile SingularAttribute<Bloque, Grado> idGrado;
    public static volatile SingularAttribute<Bloque, Integer> idBloque;
    public static volatile SingularAttribute<Bloque, BloqueC> idBloqueCat;
    public static volatile SingularAttribute<Bloque, Seccion> idSeccion;

}