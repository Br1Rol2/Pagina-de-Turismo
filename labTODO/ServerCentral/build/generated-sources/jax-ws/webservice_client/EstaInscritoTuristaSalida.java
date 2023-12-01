
package webservice_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estaInscritoTuristaSalida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estaInscritoTuristaSalida"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mailTurista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estaInscritoTuristaSalida", propOrder = {
    "mailTurista",
    "nombreSalida"
})
public class EstaInscritoTuristaSalida {

    protected String mailTurista;
    protected String nombreSalida;

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

}
