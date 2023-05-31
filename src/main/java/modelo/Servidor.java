/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lilis .....
 */
public class Servidor {

   private ServerSocket servidor;
   private int puerto;

    public Servidor() {
    }
    public Servidor(int puerto) {
        this.puerto = puerto;
       try {
           servidor=new ServerSocket(puerto);
       } catch (IOException ex) {
           Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public ServerSocket getServidor() {
        return servidor;
    } 

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    public static void main(String[] args) {
       
           // TODO code application logic here
           DataInputStream entrada;
           DataOutputStream salida;
           
           HashMap hash1;
           
            Servidor servidor= new Servidor(1033);  //objeto del servidor
           
           
           //hash Map
           
//            HashMap <String , String> hash= new HashMap<>();
//            hash.put("¿PORQUE SE ESTRESAN LOS GATOS?","PORQUE TIENEN UN OIDO DELICADO Y NO LES GUSTA ESTAR ENSERRADOS \n ");
//            hash.put("¿EN QUE PAIS LOS GATOS ERAN ADORADOS POR DIOSES?", "EN EGIPTO \n ");
//            hash.put("¿UN ROL IMPORTANTE DE LOS GATOS EN LA NATURALEZA?", "CONTROLAN LA PLAGA DE ROEDORES \n ");
//            hash.put("¿LOS GATOS SON ANIMALES SOCIALES?", "GENERALMENTE SI CUANDO SON CRIADOS EN UN AMBIENTE SOCIABLE \n ");
//            hash.put("¿LOS GATOS PUEDEN CONTAGIAR EMPERMEDADES?", "SI AUNQUE SON  CASOS AISLADOS \n ");
//          

               HashMap <Integer , String> hash= new HashMap<>();
               hash.put(1,"¿PORQUE SE ESTRESAN LOS GATOS?");
               hash.put(2,"¿EN QUE PAIS LOS GATOS ERAN ADORADOS POR DIOSES?");
               hash.put(3,"¿UN ROL IMPORTANTE DE LOS GATOS EN LA NATURALEZA?");
               hash.put(4,"¿LOS GATOS SON ANIMALES SOCIALES?");
               hash.put(5,"¿LOS GATOS PUEDEN CONTAGIAR EMPERMEDADES?");
          
          
       try {
            Socket cLiente_conexion = servidor.getServidor().accept();
           System.out.println(cLiente_conexion.getInetAddress());
           salida = new DataOutputStream(cLiente_conexion.getOutputStream());
           salida.writeUTF("SOLICITUD ACEPTADA");
           DataOutputStream flujoSalida = new DataOutputStream(cLiente_conexion.getOutputStream());
           entrada = new DataInputStream(cLiente_conexion.getInputStream());
           flujoSalida.writeUTF(hash.toString());
           
             while(true){
                     boolean ban=false;
                    for(int hashkey: hash.keySet()){ //Devuelve el array de claves
                    }
                }
            
       } catch (IOException ex) {
           Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
       }
           
       } 

           
    }
    

