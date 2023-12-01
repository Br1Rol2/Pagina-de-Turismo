
package webservice_client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UsuarioRepetidoException", targetNamespace = "http://webservice/")
public class UsuarioRepetidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UsuarioRepetidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UsuarioRepetidoException_Exception(String message, UsuarioRepetidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UsuarioRepetidoException_Exception(String message, UsuarioRepetidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservice_client.UsuarioRepetidoException
     */
    public UsuarioRepetidoException getFaultInfo() {
        return faultInfo;
    }

}