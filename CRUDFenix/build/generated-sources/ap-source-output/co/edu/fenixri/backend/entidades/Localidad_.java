package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Localidad.class)
public class Localidad_ { 

    public static volatile SingularAttribute<Localidad, String> descripcion;
    public static volatile ListAttribute<Localidad, Usuario> usuarioList;
    public static volatile SingularAttribute<Localidad, Integer> idLocalidad;

}