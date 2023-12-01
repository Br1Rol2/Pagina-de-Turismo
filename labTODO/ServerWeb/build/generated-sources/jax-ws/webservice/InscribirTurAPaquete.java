
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InscribirTurAPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InscribirTurAPaquete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="costoPaquete1" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="cantidad1" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vencimiento1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaCompra1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InscribirTurAPaquete", propOrder = {
    "nombreP1",
    "email1",
    "costoPaquete1",
    "cantidad1",
    "vencimiento1",
    "fechaCompra1"
})
public class InscribirTurAPaquete {

    protected String nombreP1;
    protected String email1;
    protected float costoPaquete1;
    protected int cantidad1;
    protected String vencimiento1;
    protected String fechaCompra1;

    /**
     * Obtiene el valor de la propiedad nombreP1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreP1() {
        return nombreP1;
    }

    /**
     * Define el valor de la propiedad nombreP1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreP1(String value) {
        this.nombreP1 = value;
    }

    /**
     * Obtiene el valor de la propiedad email1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * Define el valor de la propiedad email1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail1(String value) {
        this.email1 = value;
    }

    /**
     * Obtiene el valor de la propiedad costoPaquete1.
     * 
     */
    public float getCostoPaquete1() {
        return costoPaquete1;
    }

    /**
     * Define el valor de la propiedad costoPaquete1.
     * 
     */
    public void setCostoPaquete1(float value) {
        this.costoPaquete1 = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad1.
     * 
     */
    public int getCantidad1() {
        return cantidad1;
    }

    /**
     * Define el valor de la propiedad cantidad1.
     * 
     */
    public void setCantidad1(int value) {
        this.cantidad1 = value;
    }

    /**
     * Obtiene el valor de la propiedad vencimiento1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVencimiento1() {
        return vencimiento1;
    }

    /**
     * Define el valor de la propiedad vencimiento1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVencimiento1(String value) {
        this.vencimiento1 = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCompra1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCompra1() {
        return fechaCompra1;
    }

    /**
     * Define el valor de la propiedad fechaCompra1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCompra1(String value) {
        this.fechaCompra1 = value;
    }

}
