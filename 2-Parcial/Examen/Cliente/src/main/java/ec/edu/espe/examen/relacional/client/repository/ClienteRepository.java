/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.client.repository;

import ec.edu.espe.examen.relacional.client.model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hecto
 */
public interface ClienteRepository  extends CrudRepository <Cliente, String> {
    Cliente findByCedula(String cedula);
}
