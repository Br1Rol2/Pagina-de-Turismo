
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para seguirUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="seguirUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usr" type="{http://webservice/}usuario" minOccurs="0"/&gt;
 *         &lt;element name="seguir" type="{http://webservice/}usuario" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "seguirUsuario", propOrder = {
    "usr",
    "seguir"
})
public class SeguirUsuario {

    protected Usuario usr;
    protected Usuario seguir;

    /**
     * Obtiene el valor de la propiedad usr.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getUsr() {
        return usr;
    }

    /**
     * Define el valor de la propiedad usr.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setUsr(Usuario value) {
        this.usr = value;
    }

    /**
     * Obtiene el valor de la propiedad seguir.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getSeguir() {
        return seguir;
    }

    /**
     * Define el valor de la propiedad seguir.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setSeguir(Usuario value) {
        this.seguir = value;
    }

}
