package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Respuesta;
import co.edu.fenixri.backend.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Instructor.class)
public class Instructor_ { 

    public static volatile SingularAttribute<Instructor, Integer> idInstructor;
    public static volatile SingularAttribute<Instructor, byte[]> licenciaDeportiva;
    public static volatile ListAttribute<Instructor, Respuesta> respuestaList;
    public static volatile SingularAttribute<Instructor, Usuario> usuario;

}