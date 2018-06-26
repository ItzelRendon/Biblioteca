/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloCliente;
<<<<<<< HEAD
=======
import modelo.modeloEmpleado;
import modelo.modeloLibro;
>>>>>>> 4e1de275e42511786e07552a3481ff61435f3def
import vista.Cliente;
import vista.Frame;
<<<<<<< HEAD
import vista.Libro;
=======
<<<<<<< HEAD
=======
import vista.Inventario;
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
import vista.Libro;
>>>>>>> 4e1de275e42511786e07552a3481ff61435f3def
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
<<<<<<< HEAD
=======
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
>>>>>>> 4e1de275e42511786e07552a3481ff61435f3def
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
