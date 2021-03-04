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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author hecto
 */
@Slf4j
@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }
    
    public void create(Cliente cliente) throws InsertException {
        try {
            if(validarCedula(cliente.getCedula())){
                this.clienteRepo.save(cliente);
            }else{
                throw new InsertException("Cliente", "Cedula invalida.");
            }
        } catch (Exception e) {
            throw new InsertException("Cliente", "Ocurrio un error al crear el cliente: " + cliente.toString(), e);
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
    
    private Boolean validarCedula(String cedula) {
        Integer suma = 0;
        Integer mul = 2;
        Integer res = 0;
        if (cedula.length() == 10) {
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(Character.toString(cedula.charAt(i))) * mul;
                suma += num >= 10 ? num - 9 : num;
                mul = i % 2 == 0 ? 1 : 2;
            }

            Integer superior = ((suma / 10) * 10) + 10;
            res = superior - suma >= 10 ? (superior - suma) - 10 : superior - suma;

            if (res == Integer.parseInt(Character.toString(cedula.charAt(9)))) {
                return true;
            }
        }
        return false;
    }
}
