package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Actividad;
import co.edu.fenixri.backend.entidades.Ficha;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, Integer> idAsistencia;
    public static volatile SingularAttribute<Asistencia, Ficha> ficha;
    public static volatile SingularAttribute<Asistencia, Actividad> actividad;

}