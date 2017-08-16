/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.sale.node.two;

import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.entity.Person;
import br.edu.ifpb.app.sale.shared.entity.Salesman;
import br.edu.ifpb.app.sale.shared.service.SalesmanService;
import com.google.gson.Gson;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author miolivc
 */
public class NodeTwoMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        /*
        SalesmanService salesmanService = new SalesmanManager();
        
        Registry registry = LocateRegistry.createRegistry(10999);
        
        registry.bind("SalesmanService", salesmanService);
        */
        try {
            String dados = ConexSocket.receberDados();
            Salesman vendedor = null;
            //Order order =null;
            Gson g = new Gson();
            String[] retorno =dados.split("---");
            
            if (retorno[0].equals("NODE3")){
                ConexSocket.enviarDados(dados); //envia para node1
                dados = ConexSocket.receberDados();//aguarda o retorno de Node1
                retorno =dados.split("---");
                //order = g.fromJson(retorno[1], Salesman.class);//Monta a Ordem a partir dos dados de node1
                //ConexSocket.enviarOrder(order);//Envia a orderm com os dados ID vendedor e Id Produto par node3
                //vendedor = order.getSalesman();//Extrai o vendedor da ordem redecida de node1
            }
            
            vendedor =g.fromJson(retorno[1], Salesman.class);//extrai os dados de vendedor recebido de node1
            persiste(vendedor);// persiste os dados em node2
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    private static void persiste(Salesman vendedor){
        PersistSalesman per = new PersistSalesman();
        per.add(vendedor);
    }
    
}
