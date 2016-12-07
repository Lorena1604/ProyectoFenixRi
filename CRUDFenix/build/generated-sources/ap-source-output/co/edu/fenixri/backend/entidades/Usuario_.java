package co.edu.fenixri.backend.entidades;

import co.edu.fenixri.backend.entidades.Estado;
import co.edu.fenixri.backend.entidades.Ficha;
import co.edu.fenixri.backend.entidades.Instructor;
import co.edu.fenixri.backend.entidades.Localidad;
import co.edu.fenixri.backend.entidades.PagoEstudiante;
import co.edu.fenixri.backend.entidades.Rol;
import co.edu.fenixri.backend.entidades.Telefono;
import co.edu.fenixri.backend.entidades.TipoDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-12-07T08:14:42")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, Estado> estado;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile ListAttribute<Usuario, Telefono> telefonoList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Long> identificacion;
    public static volatile ListAttribute<Usuario, Rol> rolList;
    public static volatile ListAttribute<Usuario, Ficha> fichaList;
    public static volatile SingularAttribute<Usuario, Localidad> idLocalidad;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile SingularAttribute<Usuario, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<Usuario, Instructor> instructor;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile ListAttribute<Usuario, PagoEstudiante> pagoEstudianteList;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;

}