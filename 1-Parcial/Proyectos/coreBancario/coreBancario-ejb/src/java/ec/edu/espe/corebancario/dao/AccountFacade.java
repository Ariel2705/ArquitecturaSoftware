/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.corebancario.dao;

import ec.edu.espe.corebancario.model.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    public AccountFacade() {
        super(Account.class);
    }
    
}
