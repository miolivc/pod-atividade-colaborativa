/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Person;
import br.edu.ifpb.app.sale.shared.service.PersonService;
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
public class PersistPerson implements PersonService {
    private final Connection connection;

    public PersistPerson() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public void add(Person person) {
        try {
            String sql = "INSERT INTO PERSON(NAME) VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getName());
            if (stmt.executeUpdate() < 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println("Err on add method: " + ex);
        }
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM PERSON WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            if (stmt.executeUpdate() < 0) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println("Err on add method: " + ex);
        }
    }

    @Override
    public List<Person> list() {
        try {
            String sql = "SELECT * FROM PERSON";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Person> persons = new ArrayList<>();
            while (rs.next()) {                
                Person person = new Person(rs.getString("name"));
                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            System.err.println("Err on add method: " + ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Person get(String name) {
        try {
            String sql = "SELECT * FROM PERSON WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            Person person = new Person();
            while (rs.next()) {                
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
            }
            return person;
        } catch (SQLException ex) {
            System.err.println("Err on add method: " + ex);
        }
        return null;
    }
    
}
