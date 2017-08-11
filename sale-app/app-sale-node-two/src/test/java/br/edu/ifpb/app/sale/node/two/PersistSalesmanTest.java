/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.two;

import br.edu.ifpb.app.sale.shared.entity.Salesman;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author miolivc
 */
public class PersistSalesmanTest {
    private PersistSalesman persist;
    
    @Before
    public void setUp() {
        persist = new PersistSalesman();
    }
    
    @Test
    public void testAdd() {
        
        Salesman salesman = new Salesman();
        salesman.setId(1);
        salesman.setName("Michelle");
        salesman.setPhone("3232323232");
        persist.add(salesman);
        Assert.assertEquals(salesman.getId(), persist.get(1).getId());
    }
    
    @Test
    public void testList() {
        List<Salesman> salesmans = persist.list();
        Assert.assertNotSame(Collections.EMPTY_LIST, salesmans);
    }
    
}
