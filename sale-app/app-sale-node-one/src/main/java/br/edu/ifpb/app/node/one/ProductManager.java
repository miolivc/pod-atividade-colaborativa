/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Product;
import br.edu.ifpb.app.sale.shared.service.ProductService;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class ProductManager extends UnicastRemoteObject implements ProductService {
    private final PersistProduct persist;
    
    public ProductManager() throws RemoteException {
        this.persist = new PersistProduct();
    }
    
    @Override
    public void add(Product product) throws RemoteException {
        persist.add(product);
    }

    @Override
    public void remove(int id) throws RemoteException {
        persist.remove(id);
    }

    @Override
    public List<Product> list() throws RemoteException {
        return persist.list();
    }

    @Override
    public Product get(String name) throws RemoteException {
        return persist.get(name);
    }
    
}
