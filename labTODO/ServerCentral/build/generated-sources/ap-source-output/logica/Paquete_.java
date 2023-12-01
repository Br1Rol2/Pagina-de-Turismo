package logica;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.ActividadTuristica;
import logica.Categoria;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-20T17:34:34", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> nombrePaquete;
    public static volatile SingularAttribute<Paquete, String> descri;
    public static volatile SingularAttribute<Paquete, LocalDate> alta;
    public static volatile SingularAttribute<Paquete, Integer> descuento;
    public static volatile CollectionAttribute<Paquete, Categoria> categorias;
    public static volatile CollectionAttribute<Paquete, ActividadTuristica> actTuristica;
    public static volatile SingularAttribute<Paquete, Integer> validez;
    public static volatile SingularAttribute<Paquete, String> imagen;

}