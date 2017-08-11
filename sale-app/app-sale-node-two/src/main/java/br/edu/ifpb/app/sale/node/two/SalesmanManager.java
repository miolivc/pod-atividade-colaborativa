/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.two;

import br.edu.ifpb.app.sale.shared.entity.Salesman;
import br.edu.ifpb.app.sale.shared.service.PersonService;
import br.edu.ifpb.app.sale.shared.service.SalesmanService;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miolivc
 */
public class SalesmanManager extends UnicastRemoteObject implements SalesmanService {
    private final PersistSalesman persist;
    private final Registry registry;
    private PersonService service;
    
    public SalesmanManager() throws RemoteException {
        this.persist = new PersistSalesman();
        this.registry = LocateRegistry.getRegistry();
        try {
            this.service = (PersonService) registry.lookup("PersonService");
        } catch (NotBoundException | AccessException ex) {
            Logger.getLogger(SalesmanManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(Salesman salesman) throws RemoteException {
        persist.add(salesman);
        service.add(salesman);
    }

    @Override
    public void remove(int id) throws RemoteException {
        persist.remove(id);
        service.remove(id);
    }

    @Override
    public List<Salesman> list() throws RemoteException {
        return persist.list();
    }

    @Override
    public Salesman get(int id) throws RemoteException {
        return persist.get(id);
    }
    
}
