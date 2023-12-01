
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para toggleActFavorita complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="toggleActFavorita"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="correoUsr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="favorito" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toggleActFavorita", propOrder = {
    "correoUsr",
    "nombreAct",
    "favorito"
})
public class ToggleActFavorita {

    protected String correoUsr;
    protected String nombreAct;
    protected boolean favorito;

    /**
     * Obtiene el valor de la propiedad correoUsr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoUsr() {
        return correoUsr;
    }

    /**
     * Define el valor de la propiedad correoUsr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoUsr(String value) {
        this.correoUsr = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAct() {
        return nombreAct;
    }

    /**
     * Define el valor de la propiedad nombreAct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAct(String value) {
        this.nombreAct = value;
    }

    /**
     * Obtiene el valor de la propiedad favorito.
     * 
     */
    public boolean isFavorito() {
        return favorito;
    }

    /**
     * Define el valor de la propiedad favorito.
     * 
     */
    public void setFavorito(boolean value) {
        this.favorito = value;
    }

}
