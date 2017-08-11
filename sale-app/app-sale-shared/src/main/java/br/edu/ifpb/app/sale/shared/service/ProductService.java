/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.shared.service;

import br.edu.ifpb.app.sale.shared.entity.Product;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface ProductService extends Remote {

    void add(Product product)throws RemoteException;
    void remove(int id) throws RemoteException;
    List<Product> list() throws RemoteException;
    Product get(String name) throws RemoteException;
           
}
