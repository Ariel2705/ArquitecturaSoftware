/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.client.api;

import ec.edu.espe.examen.relacional.client.exception.DocumentNotFoundException;
import ec.edu.espe.examen.relacional.client.exception.InsertException;
import ec.edu.espe.examen.relacional.client.model.Cliente;
import ec.edu.espe.examen.relacional.client.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hecto
 */

@RestController
@RequestMapping("/api/examen/relacional/cliente")
@Slf4j
public class ClienteController {
    

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    @GetMapping("/findCliente/{cedula}")
    public ResponseEntity findClientById(@PathVariable String cedula) {
        try {
            return ResponseEntity.ok(this.service.findByCedula(cedula));
        } catch (DocumentNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Cliente cliente) {
        try {
            this.service.create(cliente);
            return ResponseEntity.ok().build();
        } catch (InsertException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
