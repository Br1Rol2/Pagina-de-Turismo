
package webservice_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para turista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="turista"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://webservice/}usuario"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actsFavoritas" type="{http://webservice/}actividadTuristica" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="inscripciongeneral" type="{http://webservice/}inscripcionGeneral" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="inscripcionpaquete" type="{http://webservice/}inscripcionPaquete" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "turista", propOrder = {
    "actsFavoritas",
    "inscripciongeneral",
    "inscripcionpaquete",
    "nacionalidad"
})
public class Turista
    extends Usuario
{

    @XmlElement(nillable = true)
    protected List<ActividadTuristica> actsFavoritas;
    @XmlElement(nillable = true)
    protected List<InscripcionGeneral> inscripciongeneral;
    @XmlElement(nillable = true)
    protected List<InscripcionPaquete> inscripcionpaquete;
    protected String nacionalidad;

    /**
     * Gets the value of the actsFavoritas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actsFavoritas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActsFavoritas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActividadTuristica }
     * 
     * 
     */
    public List<ActividadTuristica> getActsFavoritas() {
        if (actsFavoritas == null) {
            actsFavoritas = new ArrayList<ActividadTuristica>();
        }
        return this.actsFavoritas;
    }

    /**
     * Gets the value of the inscripciongeneral property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inscripciongeneral property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripciongeneral().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InscripcionGeneral }
     * 
     * 
     */
    public List<InscripcionGeneral> getInscripciongeneral() {
        if (inscripciongeneral == null) {
            inscripciongeneral = new ArrayList<InscripcionGeneral>();
        }
        return this.inscripciongeneral;
    }

    /**
     * Gets the value of the inscripcionpaquete property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inscripcionpaquete property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripcionpaquete().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InscripcionPaquete }
     * 
     * 
     */
    public List<InscripcionPaquete> getInscripcionpaquete() {
        if (inscripcionpaquete == null) {
            inscripcionpaquete = new ArrayList<InscripcionPaquete>();
        }
        return this.inscripcionpaquete;
    }

    /**
     * Obtiene el valor de la propiedad nacionalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Define el valor de la propiedad nacionalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

}
