package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Asistencia;
import co.edu.fenixri.backend.entidades.Evidencia;
import co.edu.fenixri.backend.entidades.TipoActividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-06T21:36:22")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, TipoActividad> tipoDeActividad;
    public static volatile SingularAttribute<Actividad, Integer> idActividad;
    public static volatile SingularAttribute<Actividad, Date> fechaYhoraDeActividad;
    public static volatile SingularAttribute<Actividad, String> lugar;
    public static volatile ListAttribute<Actividad, Evidencia> evidenciaList;
    public static volatile SingularAttribute<Actividad, String> descripcionActividad;
    public static volatile ListAttribute<Actividad, Asistencia> asistenciaList;

}