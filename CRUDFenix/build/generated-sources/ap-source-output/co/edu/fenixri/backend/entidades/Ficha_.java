package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Asistencia;
import co.edu.fenixri.backend.entidades.Eps;
import co.edu.fenixri.backend.entidades.Evolucion;
import co.edu.fenixri.backend.entidades.Sugerencia;
import co.edu.fenixri.backend.entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Ficha.class)
public class Ficha_ { 

    public static volatile SingularAttribute<Ficha, Integer> idFicha;
    public static volatile SingularAttribute<Ficha, Date> fechaIngreso;
    public static volatile SingularAttribute<Ficha, byte[]> fotoUsuario;
    public static volatile ListAttribute<Ficha, Sugerencia> sugerenciaList;
    public static volatile ListAttribute<Ficha, Evolucion> evolucionList;
    public static volatile SingularAttribute<Ficha, Usuario> idUsuario;
    public static volatile SingularAttribute<Ficha, Eps> epsUsuario;
    public static volatile SingularAttribute<Ficha, String> numeroRegistro;
    public static volatile ListAttribute<Ficha, Asistencia> asistenciaList;

}