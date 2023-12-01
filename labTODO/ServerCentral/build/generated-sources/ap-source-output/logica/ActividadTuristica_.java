package logica;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Categoria;
import logica.Departamento;
import logica.EstadoActividad;
import logica.Paquete;
import logica.Proveedor;
import logica.SalidasTuristicas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-20T17:34:34", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ActividadTuristica.class)
public class ActividadTuristica_ { 

    public static volatile SingularAttribute<ActividadTuristica, String> descripcion;
    public static volatile SingularAttribute<ActividadTuristica, EstadoActividad> estado;
    public static volatile SingularAttribute<ActividadTuristica, String> urlVideo;
    public static volatile SingularAttribute<ActividadTuristica, LocalDate> fechaAlta;
    public static volatile SingularAttribute<ActividadTuristica, Long> cantVisitas;
    public static volatile CollectionAttribute<ActividadTuristica, Categoria> categorias;
    public static volatile SingularAttribute<ActividadTuristica, Integer> duracionHoras;
    public static volatile SingularAttribute<ActividadTuristica, String> imagen;
    public static volatile CollectionAttribute<ActividadTuristica, SalidasTuristicas> salidastur;
    public static volatile SingularAttribute<ActividadTuristica, String> nombre;
    public static volatile CollectionAttribute<ActividadTuristica, Paquete> paquete;
    public static volatile SingularAttribute<ActividadTuristica, Double> costoPorTurista;
    public static volatile SingularAttribute<ActividadTuristica, String> ciudad;
    public static volatile SingularAttribute<ActividadTuristica, Departamento> departamento;
    public static volatile SingularAttribute<ActividadTuristica, Proveedor> proveedor;

}