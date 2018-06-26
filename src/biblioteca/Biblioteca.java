/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controlador.controllogin;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.ConexionBD;
import modelo.modelologin;
<<<<<<< HEAD
=======
=======
import controlador.controlEmpleado;
import controlador.controlFrame;
import controlador.controllogin;
import controlador.controlsucursal;
import modelo.modeloEmpleado;
import modelo.modelologin;
import modelo.modelosucursal;
import vista.Empleado;
import vista.Frame;
import vista.Libro;
import vista.Libro;
>>>>>>> 4e1de275e42511786e07552a3481ff61435f3def
>>>>>>> e30817e163d580a93c9c44c5b64415fce36d4c8c
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
<<<<<<< HEAD
=======

>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
          Login lo = new Login();
          modelologin mode = new modelologin();
          controllogin control = new controllogin(mode,lo);
          control.iniciarvista();
<<<<<<< HEAD
=======

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

>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
    }
    
}
