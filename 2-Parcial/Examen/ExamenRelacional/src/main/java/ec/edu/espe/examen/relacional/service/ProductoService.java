/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.service;

import ec.edu.espe.examen.relacional.exception.InsertException;
import ec.edu.espe.examen.relacional.exception.UpdateException;
import ec.edu.espe.examen.relacional.model.Producto;
import ec.edu.espe.examen.relacional.repository.ProductoRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author hecto
 */
@Slf4j
@Service
public class ProductoService {

    private final ProductoRepository productoRepo;

    public ProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }
    
    public void create(Producto producto) throws InsertException {
        try {
            Producto lastProd = this.productoRepo.findTopByOrderByCodigoDesc();
            if(lastProd != null){
                producto.setCodigo(String.valueOf(Integer.parseInt(lastProd.getCodigo()) + 1));
                log.info("Creando producto " + producto.getNombre());
                this.productoRepo.save(producto);
            }else {
                throw new InsertException("Producto", "Ocurrio un error en la creacion del nuevo codigo del producto.");
            }
        } catch (Exception e) {
            throw new InsertException("Producto", "Ocurrio un error al crear el producto: " + producto.toString(), e);
        }
    }
    
    public void update(Producto producto) throws UpdateException {
        try {
            Optional<Producto> productoFind = this.productoRepo.findById(producto.getCodigo());
            if(!productoFind.isPresent()){
                productoFind.get().setNombre("".equals(producto.getNombre()) ? producto.getNombre() : productoFind.get().getNombre());
                productoFind.get().setExistencia(producto.getExistencia() != null ? producto.getExistencia(): productoFind.get().getExistencia());
                productoFind.get().setValorUnitario(producto.getValorUnitario()!= null ? producto.getValorUnitario(): productoFind.get().getValorUnitario());
                productoFind.get().setAplicaIva("".equals(producto.getAplicaIva()) ? producto.getAplicaIva(): productoFind.get().getAplicaIva());
                this.productoRepo.save(productoFind.get());
            }else{
                throw new UpdateException("Producto", "No se encontro el producto: " + producto.getNombre());
            }
        } catch (Exception e) {
            throw new UpdateException("Producto", "Ocurrio un error al actualizar el producto: " + producto.getNombre(), e);
        }
    }
}
