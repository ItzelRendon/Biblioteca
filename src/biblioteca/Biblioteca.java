/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controlador.controllogin;
import modelo.modelologin;
import vista.Login;

/**
 *
 * @author ITZEL
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
//        Frame vista = new Frame();
//        controlFrame control = new controlFrame(vista);
//        control.iniciar();
          Login lo = new Login();
          modelo.modelologin mode = new modelologin();
          controllogin control = new controllogin(mode,lo);
          control.iniciarvista();
    }   
}

//          try{
//              ConexionBD miConexion = new ConexionBD();
//            //Para abrir una conexion a la BD
//            Connection con = miConexion.abrirConexion();
//            if(con!=null)
//                System.out.print("Conexion abierta");
//            
//            if(!con.isClosed()){
//                miConexion.cerrarConexion(con);
//                System.out.print("Conexion cerrada");
//            }
    //        }catch(SQLException e){
    //            System.out.print("ERROR");
    //        }  
//        Frame vista = new Frame();
//        controlFrame controlprincipal = new controlFrame(vista);
//        controlprincipal.iniciar();


    
    
