/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.service.PersonService;
import br.edu.ifpb.app.sale.shared.service.ProductService;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author miolivc
 */
public class NodeOneMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        PersonService personManager = new PersonManager();
        ProductService productService = new ProductManager();
        
        Registry registry = LocateRegistry.createRegistry(1099);
        
        registry.bind("PersonService", personManager);
        registry.bind("ProductService", productService);
        
    }
    
}
