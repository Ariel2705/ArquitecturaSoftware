/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examone.services;

import ec.edu.espe.examone.dao.ProductoFacade;
import ec.edu.espe.examone.dao.ProductoKardexFacade;
import ec.edu.espe.examone.model.Producto;
import ec.edu.espe.examone.model.ProductoKardex;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author hecto
 */
@Stateless
@LocalBean
public class ProductoService {

    private static final Logger LOG = Logger.getLogger(ProductoService.class.getName());

    @EJB
    private ProductoFacade productoDao;

    @EJB
    private ProductoKardexFacade productoKardexDao;

    public List<Producto> listarProducto() {
        LOG.info("Listando todos los productos");
        return this.productoDao.findAll();
    }

    public void existenciaProducto(String codigo, Integer cantidad) {
        Producto producto = this.productoDao.find(codigo);
        if (producto != null) {
            if (producto.getExistencia() >= cantidad) {
                ProductoKardex kardex = new ProductoKardex();
                BigDecimal precio = new BigDecimal("0.00");
                kardex.setFecha(new Date());
                kardex.setExistencia(producto.getExistencia());
                kardex.setCodigoProducto(codigo);
                kardex.setCantidad(cantidad);
                this.productoKardexDao.create(kardex);
                
                producto.setExistencia(producto.getExistencia() - cantidad);
                this.productoDao.edit(producto);
            } else {
                throw new RuntimeException("Cantidad del producto menor a la cantidad comprada."); 
            }
        } else {
            throw new RuntimeException("El producto no está registrado en la base de datos.");
        }
    }
}
