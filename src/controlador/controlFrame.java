/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloCliente;
import modelo.modeloEmpleado;
import modelo.modeloInventario;
import modelo.modeloLibro;
import vista.Cliente;
import vista.Empleado;
import vista.Frame;
import vista.Inventario;
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
        //Crea objetos del siguiente panel
//        Empleado vistaemp = new Empleado();
//        modeloEmpleado modeloemp = new modeloEmpleado();
//        controlEmpleado controlemp = new controlEmpleado(modeloemp, vistaemp);
          Inventario vistaemp = new Inventario();
          modeloInventario modeloemp = new modeloInventario();
          controlInventario controlemp = new controlInventario(modeloemp, vistaemp);
        menu vistaMenu = new menu();
        controladorMenu control = new controladorMenu(vistaMenu, vista);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaMenu);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Y lo muestra.
        control.iniciarVista();
    }
}
