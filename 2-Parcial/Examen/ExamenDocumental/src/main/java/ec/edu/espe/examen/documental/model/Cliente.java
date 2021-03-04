/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.documental.model;

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
public class Cliente {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
}
