
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para quedanPuestosPaqAct complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="quedanPuestosPaqAct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mailTur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombrePaq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="actividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quedanPuestosPaqAct", propOrder = {
    "mailTur",
    "nombrePaq",
    "actividad",
    "cantidad"
})
public class QuedanPuestosPaqAct {

    protected String mailTur;
    protected String nombrePaq;
    protected String actividad;
    protected int cantidad;

    /**
     * Obtiene el valor de la propiedad mailTur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailTur() {
        return mailTur;
    }

    /**
     * Define el valor de la propiedad mailTur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailTur(String value) {
        this.mailTur = value;
    }

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

    /**
     * Obtiene el valor de la propiedad actividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * Define el valor de la propiedad actividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividad(String value) {
        this.actividad = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

}
