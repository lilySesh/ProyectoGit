/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lilis
 */
public class Cliente {
    private Socket cliente;

    public Cliente() {
        cliente=new Socket();
    }

    public Cliente(Socket cliente) {
        this.cliente = cliente;
        new Socket();
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente=new Cliente();
          DataInputStream entrada;
          DataOutputStream salida = null ;
         
           
        try {
             cliente.setCliente(new Socket("127.0.0.1",1033));
             Socket cliente_conexion = cliente.getCliente();
             entrada= new DataInputStream(cliente.getCliente().getInputStream()); 
             System.out.println(entrada.readUTF());
             DataInputStream flujoEntrada = new DataInputStream(cliente.getCliente().getInputStream());
             DataOutputStream flujoSalida = new DataOutputStream(cliente_conexion.getOutputStream());
             
                 HashMap <Integer , String> hash1= new HashMap<>();
            hash1.put(1,"PORQUE TIENEN UN OIDO DELICADO Y NO LES GUSTA ESTAR ENSERRADOS \n ");
            hash1.put(2,"EN EGITO \n");
            hash1.put(3,"CONTROLAN LA PLAGA DE ROEDORES \n ");
            hash1.put(4,"GENERALMENTE SI CUANDO SON CRIADOS EN UN AMBIENTE SOCIABLE \n ");
            hash1.put(5,"SI AUNQUE SON  CASOS AISLADOS \n ");
                
            
                
                System.out.println("LA CONVERSACION ESTA INICIANDO ");
                 String key1=flujoEntrada.readUTF();
                 System.out.println(key1);
                 flujoSalida.writeUTF(hash1.toString());
                 
                
                //Respuestas del cliente
                  
            

        } catch (ConnectException ex) {
             System.out.println("El servidor no esta conectado" +ex.getMessage());
        }catch  (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
