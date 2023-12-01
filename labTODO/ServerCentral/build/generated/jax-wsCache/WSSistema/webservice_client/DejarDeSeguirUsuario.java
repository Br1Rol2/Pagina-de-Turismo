
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dejarDeSeguirUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dejarDeSeguirUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usr" type="{http://webservice/}usuario" minOccurs="0"/&gt;
 *         &lt;element name="noseguir" type="{http://webservice/}usuario" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dejarDeSeguirUsuario", propOrder = {
    "usr",
    "noseguir"
})
public class DejarDeSeguirUsuario {

    protected Usuario usr;
    protected Usuario noseguir;

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
     * Obtiene el valor de la propiedad noseguir.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getNoseguir() {
        return noseguir;
    }

    /**
     * Define el valor de la propiedad noseguir.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setNoseguir(Usuario value) {
        this.noseguir = value;
    }

}
