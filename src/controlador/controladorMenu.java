/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloCliente;
import modelo.modeloEmpleado;
import modelo.modeloLibro;
import modelo.modeloRenta;
import modelo.modelosucursal;
import vista.Cliente;
import vista.Empleado;
import vista.Frame;
import vista.Libro;
import vista.Libro2;
import vista.Login;
import vista.Renta;
import vista.Sucursal;
import vista.menu;

/**
 *
 * @author Holi
 */
public class controladorMenu implements ActionListener{

    private menu vista;
    private Frame frame;
    private String [] empleado;
   
    public controladorMenu(menu vista, Frame frame, String [] empleado)
    {
        this.vista = vista;
        this.frame = frame;
        this.vista.btnEmpleado.addActionListener(this);
        this.vista.btnLibro.addActionListener(this);
        this.vista.btnRenta.addActionListener(this);
        this.empleado=empleado;
        this.vista.btnCliente.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnSucursal.addActionListener(this);
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
            controlEmpleado controlEmpleado = new controlEmpleado(modeloEmpleado, vistaEmpleado, frame, empleado);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaEmpleado);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
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
            controlRenta controlRenta = new controlRenta(modeloRenta, vistaRenta, frame, empleado);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaRenta);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
             //Y lo muestra.
            controlRenta.iniciarRenta();
        }
        if(vista.btnCliente == e.getSource()){
            Cliente v = new Cliente();
            modeloCliente m = new modeloCliente();
            controlCliente con = new controlCliente(m, v, frame, empleado);
            new CambiaPanel(frame.pnl_cambiante,v); 
            con.iniciarVista();
        }
        if(vista.btnLibro == e.getSource())
        {
            frame.pnl_cambiante.removeAll();
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            Libro2 vistaLibro2 = new Libro2();
            Libro vistaLibro = new Libro(); 
            modeloLibro modeloLibro = new modeloLibro();
            controlLibro controlLibro = new controlLibro(modeloLibro, vistaLibro, frame, vistaLibro2, empleado);
            //Lo añade al panel
            frame.pnl_cambiante.add(vistaLibro);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
             //Y lo muestra.
            controlLibro.iniciarVista();
        }
        if(vista.btnSucursal == e.getSource()){
            frame.pnl_cambiante.removeAll();
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
            Sucursal v = new Sucursal();
            modelosucursal m = new modelosucursal();
            controlsucursal con = new controlsucursal(v, m, frame, empleado);
            //Lo añade al panel
            frame.pnl_cambiante.add(v);
            frame.pnl_cambiante.revalidate();
            frame.pnl_cambiante.repaint();
             //Y lo muestra.
            con.iniciarVista();
        }
        if(vista.btnSalir == e.getSource())
        {
            if (JOptionPane.showConfirmDialog(vista,
                    "¿Estás seguro que deseas salir?", "Fleetock",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    frame.setVisible(false);
            }
        }
    }   
}