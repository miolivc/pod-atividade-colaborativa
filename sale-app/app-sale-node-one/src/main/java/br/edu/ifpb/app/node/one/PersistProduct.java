/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Product;
import br.edu.ifpb.app.sale.shared.service.ProductService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            String sql = "INSERT INTO PRODUCT(NAME) VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getName());
            if (stmt.executeUpdate() < 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void remove(int id)  {
        try {
            String sql = "DELETE FROM PRODUCT WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            if (stmt.executeUpdate() <= 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public List<Product> list() {
        try {
            String sql = "SELECT * FROM PRODUCT";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Product> products = new ArrayList<>();
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Product get(String name) {
        try {
            String sql = "SELECT * FROM PRODUCT WHERE NAME = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            Product product = new Product();
            while(rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
            }
            return product;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
}
