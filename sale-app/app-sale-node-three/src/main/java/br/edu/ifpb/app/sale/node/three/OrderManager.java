/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.three;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.service.OrderService;
import br.edu.ifpb.app.sale.shared.service.SalesmanService;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class OrderManager extends UnicastRemoteObject implements OrderService {
    private final PersistOrder persist;
    private final Registry registry;

    public OrderManager() throws RemoteException {
        this.persist = new PersistOrder();
        this.registry = LocateRegistry.getRegistry("localhost", 10998);
    }
    
    private SalesmanService getService() throws RemoteException {
        SalesmanService service = null;
        try {
            service = (SalesmanService) registry.lookup("SalesmanService");
        } catch (NotBoundException | AccessException ex) {
            System.err.println(ex);
        }
        return service;
    }

    @Override
    public void add(Order order) throws RemoteException {
        SalesmanService service = getService();
        persist.add(order);
        service.add(order.getSalesman());
    }

    @Override
    public void remove(int id) throws RemoteException {
        persist.remove(id);
    }

    @Override
    public List<Order> list() throws RemoteException {
        SalesmanService service = getService();
        return persist.list();
    }

    @Override
    public Order get(int id) throws RemoteException {
        return persist.get(id);
    }
    
}
