/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.service.ConnectionService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miolivc
 */
public class ConnectionFactory implements ConnectionService {
    private Connection connection;
    
    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_node_1", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        return connection;
    }
    
}
