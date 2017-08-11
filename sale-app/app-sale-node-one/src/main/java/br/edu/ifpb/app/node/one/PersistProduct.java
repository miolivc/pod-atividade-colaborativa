/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Product;
import br.edu.ifpb.app.sale.shared.service.ProductService;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class PersistProduct implements ProductService {
    private final Connection connection;

    public PersistProduct() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public void add(Product product) {
        
    }

    @Override
    public void remove(int id)  {
        
    }

    @Override
    public List<Product> list() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Product get(String name) {
        return null;
    }
    
}
