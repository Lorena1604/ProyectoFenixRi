package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Permiso;
import co.edu.fenixri.backend.entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:30:54")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile SingularAttribute<Permiso, String> descripcion;
    public static volatile SingularAttribute<Permiso, Integer> idPermiso;
    public static volatile SingularAttribute<Permiso, String> urlPermiso;
    public static volatile SingularAttribute<Permiso, Integer> idPermidoPadre;
    public static volatile ListAttribute<Permiso, Rol> rolList;
    public static volatile SingularAttribute<Permiso, String> nombre;
    public static volatile ListAttribute<Permiso, Permiso> permisoList;
    public static volatile SingularAttribute<Permiso, Permiso> idPermisoPadre;

}