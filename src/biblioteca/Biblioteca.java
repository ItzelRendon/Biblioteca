/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controlador.controlEmpleado;
import controlador.controlFrame;
import modelo.modeloEmpleado;
import vista.Empleado;
import vista.Frame;

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
        Frame vista = new Frame();
        controlFrame control = new controlFrame();
        control.iniciar();
    }
    
}
