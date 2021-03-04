/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.documental.service;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import ec.edu.espe.examen.documental.exception.InsertException;
import ec.edu.espe.examen.documental.model.Factura;
import ec.edu.espe.examen.documental.model.Producto;
import ec.edu.espe.examen.documental.repository.FacturaRepository;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hecto
 */

@Slf4j
@Service
public class FacturaService {

    private final FacturaRepository facturaRepo;

    public FacturaService(FacturaRepository facturaRepo) {
        this.facturaRepo = facturaRepo;
    }
    
    public Factura create(Factura factura) throws InsertException{
        try{
            List<Producto> productos = new ArrayList<>(); 
        HttpResponse<JsonNode> requestClient = Unirest.get("http://localhost:8082/api/examen/relacional/cliente/findCliente/{cedula}")
                .routeParam("cedula", factura.getCliente().getCedula()).asJson();
        for(int i=0; i<factura.getProductos().size();i++){
            
        }
        }catch (Exception e){
            throw new InsertException("factura", "No se pudo crear la factura");
        }
        return factura;
    }
    
}
