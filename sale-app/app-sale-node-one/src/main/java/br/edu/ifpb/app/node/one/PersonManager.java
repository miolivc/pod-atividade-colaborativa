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
    
    public PersonManager() throws RemoteException {
        this.persist = new PersistPerson();
        this.registry = LocateRegistry.getRegistry();
    }
    
    @Override
    public void add(Person person) throws RemoteException {
        try {
            persist.add(person);
            SalesmanService service = (SalesmanService) registry.lookup("SalesmanService");
            service.add((Salesman) person);
        } catch (NotBoundException | AccessException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void remove(int id) throws RemoteException {
        
    }

    @Override
    public List<Person> list() throws RemoteException {
        return null;
    }

    @Override
    public Person get(String name) throws RemoteException {
        return null;
    }
    
    
}
