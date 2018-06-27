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
    private String [] empleado;

    public controlFrame(Frame vista, String [] empleado)
    {
        this.vista=vista;
        this.empleado=empleado;
    }
    
    public void iniciar()
            
    {
        vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.pnl_cambiante.removeAll();
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Crea objetos del siguiente panel
        menu vistaMenu = new menu();
        controladorMenu control = new controladorMenu(vistaMenu, vista, empleado);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaMenu);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Y lo muestra.
        control.iniciarVista();
    }
    
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        Cliente c= new Cliente(); 
        modeloCliente m= new modeloCliente(); 
        controlCliente co= new controlCliente(m,c); 
        new CambiaPanel(this.vista.pnl_cambiante,c);
        co.iniciarVista();
    }
}
