
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para confirmarInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="confirmarInscripcion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantTurista" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="costogral" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmarInscripcion", propOrder = {
    "cantTurista",
    "costogral",
    "tipo"
})
public class ConfirmarInscripcion {

    protected int cantTurista;
    protected double costogral;
    protected String tipo;

    /**
     * Obtiene el valor de la propiedad cantTurista.
     * 
     */
    public int getCantTurista() {
        return cantTurista;
    }

    /**
     * Define el valor de la propiedad cantTurista.
     * 
     */
    public void setCantTurista(int value) {
        this.cantTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad costogral.
     * 
     */
    public double getCostogral() {
        return costogral;
    }

    /**
     * Define el valor de la propiedad costogral.
     * 
     */
    public void setCostogral(double value) {
        this.costogral = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
