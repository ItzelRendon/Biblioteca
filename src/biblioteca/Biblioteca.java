/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

<<<<<<< HEAD
import controlador.controllogin;
import modelo.modelologin;
=======
import controlador.controlEmpleado;
import controlador.controlFrame;
import controlador.controlInventario;
import controlador.controllogin;
import controlador.controlsucursal;
import modelo.modeloEmpleado;
import modelo.modeloInventario;
import modelo.modelologin;
import modelo.modelosucursal;
import vista.Empleado;
import vista.Frame;
import vista.Inventario;
import vista.Libro;
>>>>>>> 4e1de275e42511786e07552a3481ff61435f3def
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
          modelologin mode = new modelologin();
          controllogin control = new controllogin(mode,lo);
          control.iniciarvista();

          
//        Frame vista = new Frame();
//        controlFrame controlprincipal = new controlFrame(vista);
//        controlprincipal.iniciar();

    }
    
}
