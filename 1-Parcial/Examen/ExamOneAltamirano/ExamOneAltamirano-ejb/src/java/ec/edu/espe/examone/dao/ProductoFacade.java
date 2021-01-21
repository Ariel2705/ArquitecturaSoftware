/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examone.dao;

import ec.edu.espe.examone.model.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hecto
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    public ProductoFacade() {
        super(Producto.class);
    }
    
}
