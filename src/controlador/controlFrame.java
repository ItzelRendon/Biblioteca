/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloEmpleado;
import vista.Empleado;
import vista.Frame;

/**
 *
 * @author Holi
 */
public class controlFrame {
    
    private Frame vista;
    
    public controlFrame(Frame vista)
    {
        this.vista = vista;
    }
    
    public void iniciar()
            
    {
        vista.setSize(500, 715);
        vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.pnl_cambiante.removeAll();
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Crea objetos del siguiente panel
        Empleado vistaemp = new Empleado();
        modeloEmpleado modeloemp = new modeloEmpleado();
        controlEmpleado controlemp = new controlEmpleado(modeloemp, vistaemp);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaemp);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Y lo muestra.
        controlemp.iniciarVista();
    }
    
}
