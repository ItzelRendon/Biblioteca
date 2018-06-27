/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloCliente;
import vista.Cliente;
import vista.Frame;
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
        controlCliente co= new controlCliente(m, c, vista, empleado); 
        new CambiaPanel(this.vista.pnl_cambiante,c);
        co.iniciarVista();
    }

//        controladorMenu control = new controladorMenu(vistaMenu, vista);
//        //cambio de panel
//        CambiaPanel cp = new CambiaPanel(vista.pnl_cambiante, vistaMenu);
//        //hacer scroll más rapido
//         vista.scroll.getVerticalScrollBar().setUnitIncrement(16);
//        //Y lo muestra.
//        control.iniciarVista();
//    }

}
