
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificarDatosUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificarDatosUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuevoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuevoApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuevaFechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imagenP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificarDatosUsuario", propOrder = {
    "mail",
    "nuevoNombre",
    "nuevoApellido",
    "nuevaFechaNacimiento",
    "imagenP"
})
public class ModificarDatosUsuario {

    protected String mail;
    protected String nuevoNombre;
    protected String nuevoApellido;
    protected String nuevaFechaNacimiento;
    protected String imagenP;

    /**
     * Obtiene el valor de la propiedad mail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Define el valor de la propiedad mail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Obtiene el valor de la propiedad nuevoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuevoNombre() {
        return nuevoNombre;
    }

    /**
     * Define el valor de la propiedad nuevoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuevoNombre(String value) {
        this.nuevoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad nuevoApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuevoApellido() {
        return nuevoApellido;
    }

    /**
     * Define el valor de la propiedad nuevoApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuevoApellido(String value) {
        this.nuevoApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad nuevaFechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuevaFechaNacimiento() {
        return nuevaFechaNacimiento;
    }

    /**
     * Define el valor de la propiedad nuevaFechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuevaFechaNacimiento(String value) {
        this.nuevaFechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad imagenP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagenP() {
        return imagenP;
    }

    /**
     * Define el valor de la propiedad imagenP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagenP(String value) {
        this.imagenP = value;
    }

}
