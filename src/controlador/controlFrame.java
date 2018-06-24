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
import vista.Empleado;
import vista.Frame;
import vista.Libro;

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
<<<<<<< HEAD
        vista.setSize(500, 715);
        vista.setLocationRelativeTo(null);
=======
>>>>>>> 74ad399d09f2a98d3c8c75b332ddbd64b1dcc025
        this.vista.setVisible(true);
        this.vista.pnl_cambiante.removeAll();
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Crea objetos del siguiente panel
//        Empleado vistaemp = new Empleado();
//        modeloEmpleado modeloemp = new modeloEmpleado();
//        controlEmpleado controlemp = new controlEmpleado(modeloemp, vistaemp);
          Libro vistaemp = new Libro();
          modeloLibro modeloemp = new modeloLibro();
          controlLibro controlemp = new controlLibro(modeloemp, vistaemp);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaemp);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Y lo muestra.
        controlemp.iniciarVista();
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
