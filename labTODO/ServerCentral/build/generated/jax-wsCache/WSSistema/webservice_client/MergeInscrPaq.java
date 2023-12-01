
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para mergeInscrPaq complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="mergeInscrPaq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ins" type="{http://webservice/}inscripcionPaquete" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mergeInscrPaq", propOrder = {
    "ins"
})
public class MergeInscrPaq {

    protected InscripcionPaquete ins;

    /**
     * Obtiene el valor de la propiedad ins.
     * 
     * @return
     *     possible object is
     *     {@link InscripcionPaquete }
     *     
     */
    public InscripcionPaquete getIns() {
        return ins;
    }

    /**
     * Define el valor de la propiedad ins.
     * 
     * @param value
     *     allowed object is
     *     {@link InscripcionPaquete }
     *     
     */
    public void setIns(InscripcionPaquete value) {
        this.ins = value;
    }

}
