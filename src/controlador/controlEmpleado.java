/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.modeloEmpleado;
import vista.Empleado;
import javax.swing.JOptionPane;
import vista.Frame;

/**
 *
 * @author Holi
 */
public class controlEmpleado {
    
    private modeloEmpleado modelo;
    private Empleado vista;
    private Frame frame;
    
    public controlEmpleado(modeloEmpleado modelo, Empleado vista)
    {
        this.modelo = modelo;
        this.vista = vista;
        
//        this.vista.btnGuardar.addActionListener((ActionListener) this);
//        this.vista.btnCancelar.addActionListener((ActionListener) this);
    }
    
    public void iniciarVista()
    {
        vista.setVisible(true);
    }
}
