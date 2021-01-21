
package ec.edu.espe.examtwo.repository;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.espe.examtwo.repository package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ExistenciaProducto_QNAME = new QName("http://ws.examone.espe.edu.ec/", "existenciaProducto");
    private final static QName _ListarProducto_QNAME = new QName("http://ws.examone.espe.edu.ec/", "listarProducto");
    private final static QName _ListarProductoResponse_QNAME = new QName("http://ws.examone.espe.edu.ec/", "listarProductoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.espe.examtwo.repository
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExistenciaProducto }
     * 
     */
    public ExistenciaProducto createExistenciaProducto() {
        return new ExistenciaProducto();
    }

    /**
     * Create an instance of {@link ListarProducto }
     * 
     */
    public ListarProducto createListarProducto() {
        return new ListarProducto();
    }

    /**
     * Create an instance of {@link ListarProductoResponse }
     * 
     */
    public ListarProductoResponse createListarProductoResponse() {
        return new ListarProductoResponse();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExistenciaProducto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExistenciaProducto }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.examone.espe.edu.ec/", name = "existenciaProducto")
    public JAXBElement<ExistenciaProducto> createExistenciaProducto(ExistenciaProducto value) {
        return new JAXBElement<ExistenciaProducto>(_ExistenciaProducto_QNAME, ExistenciaProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProducto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProducto }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.examone.espe.edu.ec/", name = "listarProducto")
    public JAXBElement<ListarProducto> createListarProducto(ListarProducto value) {
        return new JAXBElement<ListarProducto>(_ListarProducto_QNAME, ListarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.examone.espe.edu.ec/", name = "listarProductoResponse")
    public JAXBElement<ListarProductoResponse> createListarProductoResponse(ListarProductoResponse value) {
        return new JAXBElement<ListarProductoResponse>(_ListarProductoResponse_QNAME, ListarProductoResponse.class, null, value);
    }

}
