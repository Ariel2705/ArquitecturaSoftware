/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.api;

import ec.edu.espe.examen.relacional.exception.InsertException;
import ec.edu.espe.examen.relacional.exception.UpdateException;
import ec.edu.espe.examen.relacional.model.Producto;
import ec.edu.espe.examen.relacional.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hecto
 */

@RestController
@RequestMapping("/api/examen/relacional/producto")
@Slf4j
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }
    
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Producto producto) {
        try {
            this.service.create(producto);
            return ResponseEntity.ok().build();
        } catch (InsertException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity updateStatus(@RequestBody Producto producto) {
        try {
            this.service.update(producto);
            return ResponseEntity.ok().build();
        } catch (UpdateException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
