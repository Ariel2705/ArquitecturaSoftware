/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.model;

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
    private String codigo;
    
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "DIRECCION", nullable = false, length = 100)
    private String existencia;
    
    @Column(name = "TELEFONO", nullable = false, length = 16)
    private String valorUnitario;
    
    @Column(name = "CORREO", nullable = false, length = 100)
    private String aplicaIva;
}
