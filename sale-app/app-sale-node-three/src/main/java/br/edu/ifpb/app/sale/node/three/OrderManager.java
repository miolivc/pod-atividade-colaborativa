/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.three;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.service.OrderService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class OrderManager extends UnicastRemoteObject implements OrderService {
    private final PersistOrder persist;

    public OrderManager() throws RemoteException {
        this.persist = new PersistOrder();
    }

    @Override
    public void add(Order order) throws RemoteException {
        
    }

    @Override
    public void remove(int id) throws RemoteException {
        
    }

    @Override
    public List<Order> list() throws RemoteException {
        return null;
    }

    @Override
    public Order get(int id) throws RemoteException {
        return null;
    }
    
}
