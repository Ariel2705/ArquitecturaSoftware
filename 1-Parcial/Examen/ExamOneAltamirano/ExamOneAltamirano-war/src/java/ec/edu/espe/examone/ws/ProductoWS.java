/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examone.ws;

import ec.edu.espe.examone.model.Producto;
import ec.edu.espe.examone.services.ProductoService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hecto
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    @EJB
    private ProductoService service;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "listarProducto")
    public List<Producto> listarProducto() {
        return service.listarProducto();
    }

    @WebMethod(operationName = "existenciaProducto")
    @Oneway
    public void existenciaProducto(@WebParam(name = "codigo") String codigo, @WebParam(name = "cantidad") Integer cantidad) {
        service.existenciaProducto(codigo, cantidad);
    }
    
}
