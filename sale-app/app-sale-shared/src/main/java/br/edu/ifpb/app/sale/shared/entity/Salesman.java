/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.shared.entity;

import java.io.Serializable;

/**
 *
 * @author miolivc
 */
public class Salesman extends Person implements Serializable {
    private String phone;

    public Salesman() {
    }

    public Salesman(String name, String phone) {
        super(name);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
