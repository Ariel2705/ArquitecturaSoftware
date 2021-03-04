/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.client.service;

import ec.edu.espe.examen.relacional.client.exception.DocumentNotFoundException;
import ec.edu.espe.examen.relacional.client.exception.InsertException;
import ec.edu.espe.examen.relacional.client.model.Cliente;
import ec.edu.espe.examen.relacional.client.repository.ClienteRepository;

/**
 *
 * @author hecto
 */
public class ClienteService {
    
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }
    
    public void create(Cliente cliente) throws InsertException {
        try {
                this.clienteRepo.save(cliente);
        } catch (Exception e) {
            throw new InsertException("Producto", "Ocurrio un error al crear el producto: " + cliente.toString(), e);
        }
    }
    
    public Cliente findByCedula(String cedula) throws DocumentNotFoundException {
        try {
            Cliente cliente = this.clienteRepo.findByCedula(cedula);
            if(cliente != null){
                return cliente;                
            }else{
                throw new DocumentNotFoundException("No se encontro el cliente.");                
            }
        } catch (Exception e) {
            throw new DocumentNotFoundException("Error al buscar cliente por cedula.");
        }
    }
}
