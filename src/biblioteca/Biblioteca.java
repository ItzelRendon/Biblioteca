/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controlador.controlelegirsucursal;
import vista.elegirsucursal;

/**
 *
 * @author ITZEL
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            elegirsucursal vistasu = new elegirsucursal();
            controlelegirsucursal cs = new controlelegirsucursal(vistasu,0);
            cs.iniciarVista();
    }   
}