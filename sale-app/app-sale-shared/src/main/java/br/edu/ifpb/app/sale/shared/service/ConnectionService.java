/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.shared.service;

import java.sql.Connection;

/**
 *
 * @author miolivc
 */
public interface ConnectionService {
    
    Connection getConnection();
    
}
