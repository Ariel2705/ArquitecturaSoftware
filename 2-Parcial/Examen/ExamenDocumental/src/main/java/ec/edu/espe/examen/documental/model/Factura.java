/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.documental.model;

import org.springframework.data.annotation.Id;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author hecto
 */

@Data
@Builder
@Document(collection = "factura")
public class Factura {
    @Id
    private String id;
    
    private Cliente cliente;
    
    private List<Producto> productos;
}
