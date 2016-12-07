package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Evolucion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-06T21:48:09")
@StaticMetamodel(Rendimiento.class)
public class Rendimiento_ { 

    public static volatile SingularAttribute<Rendimiento, String> descripcion;
    public static volatile ListAttribute<Rendimiento, Evolucion> evolucionList;
    public static volatile SingularAttribute<Rendimiento, Integer> idRendimiento;

}