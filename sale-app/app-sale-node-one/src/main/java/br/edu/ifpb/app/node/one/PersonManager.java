package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Person;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miolivc
 */
public class PersonManager extends UnicastRemoteObject implements PersonService {
    private final PersistPerson persist;
    private final Registry registry;
    private SalesmanService service;
    
    public PersonManager() throws RemoteException {
        this.persist = new PersistPerson();
        this.registry = LocateRegistry.getRegistry();
        try {
            this.service = (SalesmanService) registry.lookup("SalesmanService");
        } catch (NotBoundException | AccessException ex) {
            System.err.println(ex);
        }
    }
    
    @Override
    public Person add(Person person) throws RemoteException {
        persist.add(person);
        if (service.get(person.getId()) == null) {
            service.add((Salesman) person);
        }
        return person;
            
    }

    @Override
    public void remove(int id) throws RemoteException {
        persist.remove(id);
        service.remove(id);
    }

    @Override
    public List<Person> list() throws RemoteException {
        return persist.list();
    }

    @Override
    public Person get(String name) throws RemoteException {
        return persist.get(name);
    }
    
    
}
