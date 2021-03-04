/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hecto
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "CEDULA", nullable = false, length = 8)
    private String cedula;
    
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "DIRECCION", nullable = false, length = 100)
    private String direccion;
    
    @Column(name = "TELEFONO", nullable = false, length = 16)
    private String telefono;
    
    @Column(name = "CORREO", nullable = false, length = 100)
    private String correo;
}
