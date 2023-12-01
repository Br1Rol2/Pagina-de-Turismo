
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getVencimientoInscripcionPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getVencimientoInscripcionPaquete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inscr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVencimientoInscripcionPaquete", propOrder = {
    "inscr"
})
public class GetVencimientoInscripcionPaquete {

    protected Long inscr;

    /**
     * Obtiene el valor de la propiedad inscr.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInscr() {
        return inscr;
    }

    /**
     * Define el valor de la propiedad inscr.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInscr(Long value) {
        this.inscr = value;
    }

}
