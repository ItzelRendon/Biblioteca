/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloEmpleado;
import modelo.modeloLibro;
import vista.Empleado;
import vista.Frame;
import vista.Libro;
import vista.Libro;
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
        this.vista.btnLibro.addActionListener(this);
    }
   
    public void iniciarVista()
    {
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(vista.btnEmpleado == e.getSource())
        {
            frame.pnl_cambiante.removeAll();
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            Empleado vistaEmpleado = new Empleado();
            modeloEmpleado modeloEmpleado = new modeloEmpleado();
            controlEmpleado controlEmpleado = new controlEmpleado(modeloEmpleado, vistaEmpleado, frame);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaEmpleado);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            //Y lo muestra.
            controlEmpleado.iniciarVista();
        }
        if(vista.btnLibro == e.getSource())
        {
            frame.pnl_cambiante.removeAll();
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            Libro vistaLibro = new Libro();
            modeloLibro modeloLibro = new modeloLibro();
            controlLibro controlLibro = new controlLibro(modeloLibro, vistaLibro, frame);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaLibro);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            //Y lo muestra.
            controlLibro.iniciarVista();
        }
    }   
}