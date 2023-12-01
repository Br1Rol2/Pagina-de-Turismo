
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para inscripcionSalida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inscripcionSalida"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mailTurista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantTurista" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaInscr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inscripcionSalida", propOrder = {
    "mailTurista",
    "idSalida",
    "cantTurista",
    "fechaInscr"
})
public class InscripcionSalida {

    protected String mailTurista;
    protected String idSalida;
    protected int cantTurista;
    protected String fechaInscr;

    /**
     * Obtiene el valor de la propiedad mailTurista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailTurista() {
        return mailTurista;
    }

    /**
     * Define el valor de la propiedad mailTurista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailTurista(String value) {
        this.mailTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad idSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSalida() {
        return idSalida;
    }

    /**
     * Define el valor de la propiedad idSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSalida(String value) {
        this.idSalida = value;
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

    /**
     * Obtiene el valor de la propiedad fechaInscr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInscr() {
        return fechaInscr;
    }

    /**
     * Define el valor de la propiedad fechaInscr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInscr(String value) {
        this.fechaInscr = value;
    }

}
