
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para excedeLimiteInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="excedeLimiteInscripcion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantTurista" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "excedeLimiteInscripcion", propOrder = {
    "nombreSalida",
    "cantTurista"
})
public class ExcedeLimiteInscripcion {

    protected String nombreSalida;
    protected int cantTurista;

    /**
     * Obtiene el valor de la propiedad nombreSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSalida() {
        return nombreSalida;
    }

    /**
     * Define el valor de la propiedad nombreSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSalida(String value) {
        this.nombreSalida = value;
    }

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

}
