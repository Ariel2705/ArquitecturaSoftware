/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.repository;

import ec.edu.espe.examen.relacional.model.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hecto
 */
public interface ProductoRepository extends CrudRepository <Producto, String> {
    Producto findByCodigo(String codigo);
    Producto findTopByOrderByCodigoDesc();
}
