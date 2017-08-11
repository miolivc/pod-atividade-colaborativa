/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.three;

import br.edu.ifpb.app.sale.shared.service.OrderService;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author miolivc
 */
public class NodeThreeMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        OrderService orderService = new OrderManager();
        
        Registry registry = LocateRegistry.createRegistry(10999);
        
        registry.bind("OrderService", orderService);
        
    }
    
}
