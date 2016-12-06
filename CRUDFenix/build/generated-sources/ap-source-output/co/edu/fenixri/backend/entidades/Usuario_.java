package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Estado;
import co.edu.fenixri.backend.entidades.Localidad;
import co.edu.fenixri.backend.entidades.TipoDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T22:03:07")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<Usuario, Estado> estado;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Long> identificacion;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, Localidad> idLocalidad;
    public static volatile SingularAttribute<Usuario, String> nombres;

}