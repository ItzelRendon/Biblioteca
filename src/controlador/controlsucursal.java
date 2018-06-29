/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modelosucursal;
import vista.Frame;
import vista.Sucursal;
import vista.menu;

/**
 *
 * @author alfredo
 */
public class controlsucursal implements ActionListener, MouseListener
{
    private Sucursal vista;
    private modelosucursal modelo;
    private Frame frame;
    private String [] empleado;
    
    public controlsucursal(Sucursal vista, modelosucursal modelo, Frame frame, String [] empleado)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        this.empleado = empleado;
        this.vista.table.addMouseListener(this);
        this.vista.btn_Salir.addActionListener(this);
    }
    
    public void iniciarVista(){
         vista.table.setModel(modelo.destinoConsultar());
         vista.setVisible(true);
     }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(vista.btn_Salir == evento.getSource()) {
            menu vistaMenu = new menu();
            controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
            new CambiaPanel(frame.pnl_cambiante,vistaMenu);
            control.iniciarVista();
        }
         
     }
          @Override
     public void mousePressed(MouseEvent e){
         
     }
     
     @Override
     public void mouseReleased(MouseEvent e){
         
     }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}