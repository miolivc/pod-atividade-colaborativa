/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.node.one;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.entity.Person;
import br.edu.ifpb.app.sale.shared.entity.Product;
import br.edu.ifpb.app.sale.shared.entity.Salesman;
import br.edu.ifpb.app.sale.shared.service.PersonService;
import br.edu.ifpb.app.sale.shared.service.ProductService;
import com.google.gson.Gson;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class NodeOneMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
/*        
        PersonService personManager = new PersonManager();
        ProductService productService = new ProductManager();
        
        Registry registry = LocateRegistry.createRegistry(10999);
        
        registry.bind("PersonService", personManager);
        registry.bind("ProductService", productService);
  */
            Salesman pessoa = null;
            Product produto = null;
            Gson g =new Gson();
            PersistPerson per = new PersistPerson();
            PersistProduct perpro = new PersistProduct();
            
        try {
            String dados = ConexSocket.receberDados();
            
            String[] resp = dados.split("---");
            if (resp[0].equals("NODE3")){
                Order order = g.fromJson(resp[1], Order.class);
                pessoa = order.getSalesman();
                produto = order.getProduct();
                //pessoa =(Salesman) per.add(pessoa);
                perpro.add(produto);
                //order.setProduct(produto);
                //order.setSalesman(pessoa);
               // ConexSocket.enviarOrder(order);
                        
            }else
            {
                pessoa = g.fromJson(resp[0], Salesman.class);
                
            }
            pessoa =(Salesman) per.add(pessoa);
            ConexSocket.cadastraVendedor(pessoa);
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
