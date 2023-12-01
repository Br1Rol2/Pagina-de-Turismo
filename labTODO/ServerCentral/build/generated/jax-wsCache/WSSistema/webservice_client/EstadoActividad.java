
package webservice_client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoActividad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>
 * &lt;simpleType name="estadoActividad"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AGREGADA"/&gt;
 *     &lt;enumeration value="CONFIRMADA"/&gt;
 *     &lt;enumeration value="RECHAZADA"/&gt;
 *     &lt;enumeration value="FINALIZADA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "estadoActividad")
@XmlEnum
public enum EstadoActividad {

    AGREGADA,
    CONFIRMADA,
    RECHAZADA,
    FINALIZADA;

    public String value() {
        return name();
    }

    public static EstadoActividad fromValue(String v) {
        return valueOf(v);
    }

}
