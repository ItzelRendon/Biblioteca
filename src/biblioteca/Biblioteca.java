/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controlador.controlEmpleado;
import controlador.controlFrame;
import controlador.controllogin;
import controlador.controlsucursal;
import modelo.modeloEmpleado;
import modelo.modelologin;
import modelo.modelosucursal;
import vista.Empleado;
import vista.Frame;
import vista.Login;
import vista.Sucursal;

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
<<<<<<< HEAD
//        Frame vista = new Frame();
//        controlFrame control = new controlFrame();
//        control.iniciar();
          
          Login lo = new Login();
          modelologin mode = new modelologin();
          controllogin control = new controllogin(mode,lo);
          control.iniciarvista();
=======
        Frame vista = new Frame();
        controlFrame control = new controlFrame(vista);
        control.iniciar();
>>>>>>> 3036ee477f1bc9e6d17709395d633222e4bd9b86
    }
    
}
