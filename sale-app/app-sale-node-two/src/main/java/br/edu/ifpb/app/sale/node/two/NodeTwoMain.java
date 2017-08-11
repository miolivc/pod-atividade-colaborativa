/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.two;

import br.edu.ifpb.app.sale.shared.service.SalesmanService;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author miolivc
 */
public class NodeTwoMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        SalesmanService salesmanService = new SalesmanManager();
        
        Registry registry = LocateRegistry.createRegistry(1099);
        
        registry.bind("SalesmanService", salesmanService);
        
    }
    
}
