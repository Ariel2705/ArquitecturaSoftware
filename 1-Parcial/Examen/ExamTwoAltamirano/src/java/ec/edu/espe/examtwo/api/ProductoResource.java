/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examtwo.api;

import ec.edu.espe.examtwo.model.Producto;
import ec.edu.espe.examtwo.repository.ProductoWS;
import ec.edu.espe.examtwo.repository.ProductoWS_Service;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hecto
 */
@Path("producto")
public class ProductoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.examtwo.repository.ProductoResource
     * @return an instance of java.lang.String
     */
    @GET
        @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getJson() {
        ProductoWS_Service service = new ProductoWS_Service();
        ProductoWS port = service.getProductoWSPort();
        List<ec.edu.espe.examtwo.repository.Producto> productos = port.listarProducto();
        List<Producto> productosModel = new ArrayList<>();
        for(ec.edu.espe.examtwo.repository.Producto producto : productos){
            productosModel.add(this.buildProducto(producto));
        }
        return productosModel;
    }

    /**
     * PUT method for updating or creating an instance of ProductoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    private Producto buildProducto(ec.edu.espe.examtwo.repository.Producto producto){
        Producto produc = new Producto();
        produc.setCodigo(producto.getCodigo());
        produc.setNombre(producto.getNombre());
        produc.setExistencia(producto.getExistencia());
        produc.setPrecio(producto.getPrecio());
        return produc;
    }
}
