package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Telefono.class)
public class Telefono_ { 

    public static volatile SingularAttribute<Telefono, Integer> idTelefono;
    public static volatile SingularAttribute<Telefono, Long> numero;
    public static volatile SingularAttribute<Telefono, Usuario> idUsuario;

}