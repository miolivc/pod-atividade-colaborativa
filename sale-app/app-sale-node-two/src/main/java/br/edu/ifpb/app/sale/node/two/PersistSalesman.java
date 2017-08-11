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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
    public void add(Salesman salesman) {
        try {
            String sql = "INSERT INTO SALESMAN(PHONE) VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            if (stmt.executeUpdate() <= 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM SALESMAN WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            if (stmt.executeUpdate() <= 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public List<Salesman> list() {
        try {
            String sql = "SELECT * FROM SALESMAN";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Salesman> salesmans = new ArrayList<>();
            while(rs.next()) {
                Salesman salesman = new Salesman();
                salesman.setId(rs.getInt("id"));
                salesman.setPhone("phone");
                salesmans.add(salesman);
            }
            return salesmans;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Salesman get(int id) {
        try {
            String sql = "SELECT * FROM SALESMAN WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Salesman salesman = new Salesman();
            while(rs.next()) {
                salesman.setId(rs.getInt("id"));
                salesman.setPhone("phone");
            }
            return salesman;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
}
