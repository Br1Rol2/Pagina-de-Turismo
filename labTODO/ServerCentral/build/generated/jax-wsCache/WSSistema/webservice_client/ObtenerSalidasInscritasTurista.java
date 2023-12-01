
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerSalidasInscritasTurista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerSalidasInscritasTurista"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="correoTurista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerSalidasInscritasTurista", propOrder = {
    "correoTurista"
})
public class ObtenerSalidasInscritasTurista {

    protected String correoTurista;

    /**
     * Obtiene el valor de la propiedad correoTurista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoTurista() {
        return correoTurista;
    }

    /**
     * Define el valor de la propiedad correoTurista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoTurista(String value) {
        this.correoTurista = value;
    }

}
