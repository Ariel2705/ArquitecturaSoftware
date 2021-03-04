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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Crea un producto", notes = "Crea un producto. Los productos se agregan a las facturas.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Producto creado"),
        @ApiResponse(code = 400, message = "Error al crear producto")
    })
    public ResponseEntity create(@RequestBody Producto producto) {
        try {
            this.service.create(producto);
            return ResponseEntity.ok().build();
        } catch (InsertException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/update")
    @ApiOperation(value = "Actualizar producto", notes = "Actualiza los campos del producto")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Producto actualizado"),
        @ApiResponse(code = 400, message = "Error al actualizar el producto")
    })    
    public ResponseEntity updateStatus(@RequestBody Producto producto) {
        try {
            this.service.update(producto);
            return ResponseEntity.ok().build();
        } catch (UpdateException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
