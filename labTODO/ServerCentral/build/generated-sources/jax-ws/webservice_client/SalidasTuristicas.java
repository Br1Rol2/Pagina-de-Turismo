
package webservice_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para salidasTuristicas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="salidasTuristicas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actividadAsociada" type="{http://webservice/}actividadTuristica" minOccurs="0"/&gt;
 *         &lt;element name="cantInscritos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantVisitas" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="cantidadMaximaTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaAlta" type="{http://webservice/}localDate" minOccurs="0"/&gt;
 *         &lt;element name="fechaSalida" type="{http://webservice/}localDate" minOccurs="0"/&gt;
 *         &lt;element name="hora" type="{http://webservice/}localTime" minOccurs="0"/&gt;
 *         &lt;element name="imagenSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="inscripciongeneral" type="{http://webservice/}inscripcionGeneral" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "salidasTuristicas", propOrder = {
    "actividadAsociada",
    "cantInscritos",
    "cantVisitas",
    "cantidadMaximaTuristas",
    "fechaAlta",
    "fechaSalida",
    "hora",
    "imagenSalida",
    "inscripciongeneral",
    "lugar",
    "nombreSalida"
})
public class SalidasTuristicas {

    protected ActividadTuristica actividadAsociada;
    protected int cantInscritos;
    protected long cantVisitas;
    protected int cantidadMaximaTuristas;
    protected LocalDate fechaAlta;
    protected LocalDate fechaSalida;
    protected LocalTime hora;
    protected String imagenSalida;
    @XmlElement(nillable = true)
    protected List<InscripcionGeneral> inscripciongeneral;
    protected String lugar;
    protected String nombreSalida;

    /**
     * Obtiene el valor de la propiedad actividadAsociada.
     * 
     * @return
     *     possible object is
     *     {@link ActividadTuristica }
     *     
     */
    public ActividadTuristica getActividadAsociada() {
        return actividadAsociada;
    }

    /**
     * Define el valor de la propiedad actividadAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link ActividadTuristica }
     *     
     */
    public void setActividadAsociada(ActividadTuristica value) {
        this.actividadAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad cantInscritos.
     * 
     */
    public int getCantInscritos() {
        return cantInscritos;
    }

    /**
     * Define el valor de la propiedad cantInscritos.
     * 
     */
    public void setCantInscritos(int value) {
        this.cantInscritos = value;
    }

    /**
     * Obtiene el valor de la propiedad cantVisitas.
     * 
     */
    public long getCantVisitas() {
        return cantVisitas;
    }

    /**
     * Define el valor de la propiedad cantVisitas.
     * 
     */
    public void setCantVisitas(long value) {
        this.cantVisitas = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadMaximaTuristas.
     * 
     */
    public int getCantidadMaximaTuristas() {
        return cantidadMaximaTuristas;
    }

    /**
     * Define el valor de la propiedad cantidadMaximaTuristas.
     * 
     */
    public void setCantidadMaximaTuristas(int value) {
        this.cantidadMaximaTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaAlta(LocalDate value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaSalida(LocalDate value) {
        this.fechaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link LocalTime }
     *     
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTime }
     *     
     */
    public void setHora(LocalTime value) {
        this.hora = value;
    }

    /**
     * Obtiene el valor de la propiedad imagenSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagenSalida() {
        return imagenSalida;
    }

    /**
     * Define el valor de la propiedad imagenSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagenSalida(String value) {
        this.imagenSalida = value;
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
     * Obtiene el valor de la propiedad lugar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Define el valor de la propiedad lugar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugar(String value) {
        this.lugar = value;
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
