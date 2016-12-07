package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(PagoEstudiante.class)
public class PagoEstudiante_ { 

    public static volatile SingularAttribute<PagoEstudiante, Integer> monto;
    public static volatile SingularAttribute<PagoEstudiante, Integer> idpago;
    public static volatile SingularAttribute<PagoEstudiante, Usuario> idEstudiante;
    public static volatile SingularAttribute<PagoEstudiante, Date> mensualidad;
    public static volatile SingularAttribute<PagoEstudiante, Date> fechaPago;

}