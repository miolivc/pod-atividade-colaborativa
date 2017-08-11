/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.three;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.service.OrderService;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class PersistOrder implements OrderService {
    private final Connection connection;
    
    public PersistOrder() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void add(Order order) {
        
    }

    @Override
    public void remove(int id) {
        
    }

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public Order get(int id) {
        return null;
    }
    
}
