package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Instructor;
import co.edu.fenixri.backend.entidades.Sugerencia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, Instructor> idInstructor;
    public static volatile SingularAttribute<Respuesta, Sugerencia> idSugerencia;
    public static volatile SingularAttribute<Respuesta, String> respuesta;
    public static volatile SingularAttribute<Respuesta, Integer> idrespuesta;
    public static volatile SingularAttribute<Respuesta, Date> fechaRespuesta;

}