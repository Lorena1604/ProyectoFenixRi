package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Ficha;
import co.edu.fenixri.backend.entidades.Respuesta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T22:03:07")
@StaticMetamodel(Sugerencia.class)
public class Sugerencia_ { 

    public static volatile SingularAttribute<Sugerencia, Date> fecha;
    public static volatile SingularAttribute<Sugerencia, Ficha> ficha;
    public static volatile SingularAttribute<Sugerencia, Integer> idSugerencia;
    public static volatile ListAttribute<Sugerencia, Respuesta> respuestaList;
    public static volatile SingularAttribute<Sugerencia, String> sugerencia;

}