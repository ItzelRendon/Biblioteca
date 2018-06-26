/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloCliente;
import modelo.modeloEmpleado;
import modelo.modeloLibro;
import vista.Cliente;
import vista.Frame;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import vista.Libro;
=======
<<<<<<< HEAD
=======
>>>>>>> e30817e163d580a93c9c44c5b64415fce36d4c8c
import vista.Inventario;
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
import vista.Libro;
import vista.menu;

/**
 *
 * @author Holi
 */
public class controlFrame {
    
    private Frame vista;

    public controlFrame(Frame vista)
    {
        this.vista=vista;
    }
    
    public void iniciar()
            
    {
        vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.pnl_cambiante.removeAll();
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
<<<<<<< HEAD
        menu vistaMenu = new menu();
        controladorMenu control = new controladorMenu(vistaMenu, vista);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaMenu);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
=======
        //Crea objetos del siguiente panel
//        Empleado vistaemp = new Empleado();
//        modeloEmpleado modeloemp = new modeloEmpleado();
//        controlEmpleado controlemp = new controlEmpleado(modeloemp, vistaemp);
          Inventario vistaemp = new Inventario();
          modeloInventario modeloemp = new modeloInventario();
          controlInventario controlemp = new controlInventario(modeloemp, vistaemp);
        menu vistaMenu = new menu();
        controladorMenu control = new controladorMenu(vistaMenu, vista);
        //cambio de panel
        CambiaPanel cp = new CambiaPanel(vista.pnl_cambiante, vistaMenu);
        //hacer scroll más rapido
         vista.scroll.getVerticalScrollBar().setUnitIncrement(16);
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
        //Y lo muestra.
        control.iniciarVista();
    }
}
