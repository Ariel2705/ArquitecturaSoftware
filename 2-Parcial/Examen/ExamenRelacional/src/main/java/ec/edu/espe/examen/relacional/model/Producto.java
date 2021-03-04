/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PRODUCTO", nullable = false)
    private Integer codigo;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "EXISTENCIA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private BigDecimal existencia;
    
    @Column(name = "VALOR_UNITARIO", nullable = false, length = 12)
    private BigDecimal valorUnitario;
    
    @Column(name = "APLICA_IVA", nullable = false)
    private String aplicaIva;
}