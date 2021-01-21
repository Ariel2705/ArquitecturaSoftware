
package ec.edu.espe.examtwo.repository;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2.payara-p2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProductoWS", targetNamespace = "http://ws.examone.espe.edu.ec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductoWS {


    /**
     * 
     * @param codigo
     * @param cantidad
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "existenciaProducto", targetNamespace = "http://ws.examone.espe.edu.ec/", className = "ec.edu.espe.examtwo.repository.ExistenciaProducto")
    @Action(input = "http://ws.examone.espe.edu.ec/ProductoWS/existenciaProducto")
    public void existenciaProducto(
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "cantidad", targetNamespace = "")
        Integer cantidad);

    /**
     * 
     * @return
     *     returns java.util.List<ec.edu.espe.examtwo.repository.Producto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarProducto", targetNamespace = "http://ws.examone.espe.edu.ec/", className = "ec.edu.espe.examtwo.repository.ListarProducto")
    @ResponseWrapper(localName = "listarProductoResponse", targetNamespace = "http://ws.examone.espe.edu.ec/", className = "ec.edu.espe.examtwo.repository.ListarProductoResponse")
    @Action(input = "http://ws.examone.espe.edu.ec/ProductoWS/listarProductoRequest", output = "http://ws.examone.espe.edu.ec/ProductoWS/listarProductoResponse")
    public List<Producto> listarProducto();

}
