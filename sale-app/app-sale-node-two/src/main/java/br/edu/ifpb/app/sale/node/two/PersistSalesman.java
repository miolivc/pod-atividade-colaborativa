/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.two;

import br.edu.ifpb.app.sale.shared.entity.Salesman;
import br.edu.ifpb.app.sale.shared.service.SalesmanService;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class PersistSalesman implements SalesmanService {
    private final Connection connection;

    public PersistSalesman() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public void add(Salesman salesman) throws RemoteException {
         
   }

    @Override
    public void remove(int id) throws RemoteException {
        
    }

    @Override
    public List<Salesman> list() throws RemoteException {
        return null;
    }

    @Override
    public Salesman get(String name) throws RemoteException {
        return null;
    }
    
}
