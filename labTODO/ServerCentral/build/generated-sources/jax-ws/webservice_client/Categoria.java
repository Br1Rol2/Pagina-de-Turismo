
package webservice_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para categoria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="categoria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actividades" type="{http://webservice/}actividadTuristica" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nombreCat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paquetes" type="{http://webservice/}paquete" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoria", propOrder = {
    "actividades",
    "nombreCat",
    "paquetes"
})
public class Categoria {

    @XmlElement(nillable = true)
    protected List<ActividadTuristica> actividades;
    protected String nombreCat;
    @XmlElement(nillable = true)
    protected List<Paquete> paquetes;

    /**
     * Gets the value of the actividades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActividadTuristica }
     * 
     * 
     */
    public List<ActividadTuristica> getActividades() {
        if (actividades == null) {
            actividades = new ArrayList<ActividadTuristica>();
        }
        return this.actividades;
    }

    /**
     * Obtiene el valor de la propiedad nombreCat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCat() {
        return nombreCat;
    }

    /**
     * Define el valor de la propiedad nombreCat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCat(String value) {
        this.nombreCat = value;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Paquete }
     * 
     * 
     */
    public List<Paquete> getPaquetes() {
        if (paquetes == null) {
            paquetes = new ArrayList<Paquete>();
        }
        return this.paquetes;
    }

}
