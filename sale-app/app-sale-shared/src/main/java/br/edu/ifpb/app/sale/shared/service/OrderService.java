/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.shared.service;

import br.edu.ifpb.app.sale.shared.entity.Order;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface OrderService extends Remote {
    
    void add(Order order)throws RemoteException;
    void remove(int id) throws RemoteException;
    List<Order> list() throws RemoteException;
    Order get(int id) throws RemoteException;
    
}
