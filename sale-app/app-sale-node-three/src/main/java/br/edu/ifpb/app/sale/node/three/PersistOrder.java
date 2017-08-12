/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.three;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.service.OrderService;
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
public class PersistOrder implements OrderService {
    private final Connection connection;
    
    public PersistOrder() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void add(Order order) {
        try {
            String sql = "INSERT INTO ORDER_SALE(SALESMANID, PRODUCTID, QUANTITY) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getProduct().getId());
            stmt.setInt(3, order.getQuantity());
            if (stmt.executeUpdate() <= 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM ORDER_SALE WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            if (stmt.executeUpdate() <= 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public List<Order> list() {
        try {
            String sql = "SELECT * FROM ORDER_SALE";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Order> orders = new ArrayList<>();
            while(rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.getSalesman().setId(rs.getInt("salesmanid"));
                order.getProduct().setId(rs.getInt("productid"));
                order.setQuantity(rs.getInt("quantity"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Order get(int id) {
        try {
            String sql = "SELECT * FROM ORDER_SALE";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Order order = new Order();
            while(rs.next()) {
                order.setId(rs.getInt("id"));
                order.getSalesman().setId(rs.getInt("salesmanid"));
                order.getProduct().setId(rs.getInt("productid"));
                order.setQuantity(rs.getInt("quantity"));
            }
            return order;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
}
