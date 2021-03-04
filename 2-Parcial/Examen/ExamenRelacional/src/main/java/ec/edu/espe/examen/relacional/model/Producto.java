/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.model;

import java.math.BigDecimal;
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
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "COD_PRODUCTO", nullable = false, length = 8)
    private String codigo;
    
    @Column(name = "NOMBRE", nullable = false, length = 120)
    private String nombre;
    
    @Column(name = "EXISTENCIA", nullable = false)
    private BigDecimal existencia;
    
    @Column(name = "VALOR_UNITARIO", nullable = false)
    private BigDecimal valorUnitario;
    
    @Column(name = "APLICA_IVA", nullable = false)
    private String aplicaIva;
}
