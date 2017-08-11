/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.shared.service;

import br.edu.ifpb.app.sale.shared.entity.Salesman;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface SalesmanService extends Remote {
    
   void add(Salesman salesman)throws RemoteException;
   void remove(int id) throws RemoteException;
   List<Salesman> list() throws RemoteException;
   Salesman get(int id) throws RemoteException;
           
}
