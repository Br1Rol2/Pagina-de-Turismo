
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getFechaAltaPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getFechaAltaPaquete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombrePaq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFechaAltaPaquete", propOrder = {
    "nombrePaq"
})
public class GetFechaAltaPaquete {

    protected String nombrePaq;

    /**
     * Obtiene el valor de la propiedad nombrePaq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePaq() {
        return nombrePaq;
    }

    /**
     * Define el valor de la propiedad nombrePaq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePaq(String value) {
        this.nombrePaq = value;
    }

}
