/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Person;
import br.edu.ifpb.app.sale.shared.service.PersonService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class PersistPerson implements PersonService {
    private Connection connection;

    public PersistPerson() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public void add(Person person) {
        try {
            String sql = "INSERT INTO PERSON(NAME) VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            //stmt.setInt(1, person.getId());
            stmt.setString(1, person.getName());
            if (stmt.executeUpdate() < 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println("Err on add method: " + ex);
        }
    }

    @Override
    public void remove(int id) {
        
    }

    @Override
    public List<Person> list() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Person get(String name) {
        return null;
    }
    
}
