package br.edu.ifpb.app.sale.client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifpb.app.sale.shared.entity.Order;
import br.edu.ifpb.app.sale.shared.entity.Person;
import br.edu.ifpb.app.sale.shared.entity.Salesman;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author laerton
 */
public class ConexSocket {
    
    
    private static final int PORTA_NODE1 = 10999;
    private static final int PORTA_NODE3 = 10998;
    private static final String HOST_NODE1 = "localhost";
    private static final String HOST_NODE3 = "localhost";
    
    public static String cadastraVendedor(Salesman vendedor) throws IOException, Exception{
        String retorno = "";
        Socket sock = new Socket(HOST_NODE1, PORTA_NODE1);
        OutputStream out = sock.getOutputStream();
        Gson g = new Gson();
        String mensagem = g.toJson(vendedor);
        out.write(mensagem.getBytes());
        //tratando o retorno
        InputStream in = sock.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        retorno = new String(b);
        if (retorno.contains("ERROR")){ 
            throw  new Exception("Conexão com NODE1 foi recusada");
        }
        sock.close();
        return retorno.trim();
        
    }
    
    public static String cadastraOrdem(Order ordem) throws IOException, Exception{
        String retorno ="";
        Socket sock = new Socket(HOST_NODE3, PORTA_NODE3);
        OutputStream out = sock.getOutputStream();
        Gson g = new Gson();
        String mensagem = g.toJson(ordem);
        out.write(mensagem.getBytes());
        //tratando o retorno
        InputStream in = sock.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        retorno = new String(b);
        if (retorno.contains("ERROR")){ 
            throw  new Exception("Conexão com NODE3 foi recusada");
        }
        sock.close();
        return retorno.trim();
    }
    
        
    
    
}
