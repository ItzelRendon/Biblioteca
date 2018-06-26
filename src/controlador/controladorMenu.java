/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloEmpleado;
import vista.Empleado;
import vista.Frame;
import vista.menu;

/**
 *
 * @author Holi
 */
public class controladorMenu implements ActionListener{

    private menu vista;
    private Frame frame;
   
    public controladorMenu(menu vista, Frame frame)
    {
        this.vista = vista;
        this.frame = frame;
        this.vista.btnEmpleado.addActionListener(this);
    }
   
    public void iniciarVista()
    {
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(vista.btnEmpleado == e.getSource())
        {
            
            Empleado vistaEmpleado = new Empleado();
            modeloEmpleado modeloEmpleado = new modeloEmpleado();
            controlEmpleado controlEmpleado = new controlEmpleado(modeloEmpleado, vistaEmpleado, frame);
            //cambio de panel
            CambiaPanel cp = new CambiaPanel(frame.pnl_cambiante, vistaEmpleado);
            //Y lo muestra.
            controlEmpleado.iniciarVista();
        }
    }
    
    
    
    
}
