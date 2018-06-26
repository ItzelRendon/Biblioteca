/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloCliente;
import modelo.modeloEmpleado;
<<<<<<< HEAD
import modelo.modeloLibro;
import vista.Empleado;
import vista.Frame;
import vista.Libro;
import vista.Libro;
=======
import modelo.modeloRenta;
import vista.Cliente;
import vista.Empleado;
import vista.Frame;
import vista.Renta;
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
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
<<<<<<< HEAD
        this.vista.btnLibro.addActionListener(this);
=======
        this.vista.btnRenta.addActionListener(this);
        this.vista.btnCliente.addActionListener(this);
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
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
        else if(vista.btnRenta == e.getSource()){
            frame.pnl_cambiante.removeAll();
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            modeloRenta modeloRenta = new modeloRenta();
            Renta vistaRenta = new Renta();
            controlRenta controlRenta = new controlRenta(modeloRenta, vistaRenta, frame);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaRenta);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
             //Y lo muestra.
            controlRenta.iniciarRenta();
        }
        else if(vista.btnCliente == e.getSource()){
            Cliente v = new Cliente();
            modeloCliente m = new modeloCliente();
            controlCliente con = new controlCliente(m, v, frame);
            new CambiaPanel(frame.pnl_cambiante,v); 
            con.iniciarVista();
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