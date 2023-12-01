package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.ActividadTuristica;
import logica.Paquete;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-20T17:34:34", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SetAttribute<Categoria, Paquete> paquetes;
    public static volatile SingularAttribute<Categoria, String> nombreCat;
    public static volatile SetAttribute<Categoria, ActividadTuristica> actividades;

}