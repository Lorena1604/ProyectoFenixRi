package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T18:34:25")
@StaticMetamodel(Evidencia.class)
public class Evidencia_ { 

    public static volatile SingularAttribute<Evidencia, Integer> idEvidencias;
    public static volatile SingularAttribute<Evidencia, byte[]> documentos;
    public static volatile SingularAttribute<Evidencia, Actividad> idActividad;

}