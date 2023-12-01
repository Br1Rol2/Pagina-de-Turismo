
package webservice_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actividadTuristica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actividadTuristica"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantVisitas" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="categorias" type="{http://webservice/}categoria" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="costoPorTurista" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="departamento" type="{http://webservice/}departamento" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="duracionHoras" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estado" type="{http://webservice/}estadoActividad" minOccurs="0"/&gt;
 *         &lt;element name="fechaAlta" type="{http://webservice/}localDate" minOccurs="0"/&gt;
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paquete" type="{http://webservice/}paquete" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="proveedor" type="{http://webservice/}proveedor" minOccurs="0"/&gt;
 *         &lt;element name="salidastur" type="{http://webservice/}salidasTuristicas" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actividadTuristica", propOrder = {
    "cantVisitas",
    "categorias",
    "ciudad",
    "costoPorTurista",
    "departamento",
    "descripcion",
    "duracionHoras",
    "estado",
    "fechaAlta",
    "imagen",
    "nombre",
    "paquete",
    "proveedor",
    "salidastur",
    "urlVideo"
})
public class ActividadTuristica {

    protected long cantVisitas;
    @XmlElement(nillable = true)
    protected List<Categoria> categorias;
    protected String ciudad;
    protected double costoPorTurista;
    protected Departamento departamento;
    protected String descripcion;
    protected int duracionHoras;
    @XmlSchemaType(name = "string")
    protected EstadoActividad estado;
    protected LocalDate fechaAlta;
    protected String imagen;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<Paquete> paquete;
    protected Proveedor proveedor;
    @XmlElement(nillable = true)
    protected List<SalidasTuristicas> salidastur;
    protected String urlVideo;

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
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Categoria }
     * 
     * 
     */
    public List<Categoria> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<Categoria>();
        }
        return this.categorias;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad costoPorTurista.
     * 
     */
    public double getCostoPorTurista() {
        return costoPorTurista;
    }

    /**
     * Define el valor de la propiedad costoPorTurista.
     * 
     */
    public void setCostoPorTurista(double value) {
        this.costoPorTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link Departamento }
     *     
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Departamento }
     *     
     */
    public void setDepartamento(Departamento value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad duracionHoras.
     * 
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Define el valor de la propiedad duracionHoras.
     * 
     */
    public void setDuracionHoras(int value) {
        this.duracionHoras = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoActividad }
     *     
     */
    public EstadoActividad getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoActividad }
     *     
     */
    public void setEstado(EstadoActividad value) {
        this.estado = value;
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
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the paquete property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquete property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquete().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Paquete }
     * 
     * 
     */
    public List<Paquete> getPaquete() {
        if (paquete == null) {
            paquete = new ArrayList<Paquete>();
        }
        return this.paquete;
    }

    /**
     * Obtiene el valor de la propiedad proveedor.
     * 
     * @return
     *     possible object is
     *     {@link Proveedor }
     *     
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Define el valor de la propiedad proveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Proveedor }
     *     
     */
    public void setProveedor(Proveedor value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the salidastur property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salidastur property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalidastur().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalidasTuristicas }
     * 
     * 
     */
    public List<SalidasTuristicas> getSalidastur() {
        if (salidastur == null) {
            salidastur = new ArrayList<SalidasTuristicas>();
        }
        return this.salidastur;
    }

    /**
     * Obtiene el valor de la propiedad urlVideo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Define el valor de la propiedad urlVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

}
