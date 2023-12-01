
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para selectActFromDB complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="selectActFromDB"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selectActFromDB", propOrder = {
    "nombreact"
})
public class SelectActFromDB {

    protected String nombreact;

    /**
     * Obtiene el valor de la propiedad nombreact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreact() {
        return nombreact;
    }

    /**
     * Define el valor de la propiedad nombreact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreact(String value) {
        this.nombreact = value;
    }

}
