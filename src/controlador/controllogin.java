/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.modeloEmpleado;
import modelo.modeloLibro;
import modelo.modelologin;
import vista.Empleado;
import vista.Frame;
import vista.Libro;
import vista.Login;

/**
 *
 * @author alfredo
 */
public class controllogin implements ActionListener 
{
    private modelologin modelo;
    private Login vista;
    
    public controllogin(modelologin modelo, Login vista)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.textonombre.addActionListener(this);
        this.vista.textocontraseña.addActionListener(this);
        this.vista.botonentrar.addActionListener(this);
    }
    
    public void iniciarvista()
    {
        vista.setTitle("Login");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {       
        String usuario = vista.textonombre.getText();
        String contra = new String(vista.textocontraseña.getPassword());
        if(vista.botonentrar == e.getSource())
        {
            //JOptionPane.showMessageDialog(null, "Bienvenido");
                    Frame frame = new Frame();
                    controlFrame controlFrame = new controlFrame(frame);
                    controlFrame.iniciar();
//            switch (modelo.ingresar(usuario, contra)) {
//                case 1:
//                    JOptionPane.showMessageDialog(null, "Bienvenido");
//                    Frame frame = new Frame();
//                    controlFrame controlFrame = new controlFrame(frame);
//                    controlFrame.iniciar();
//                    break;
//                case 2:
//                    JOptionPane.showMessageDialog(null, "USUARIO/CONTRASEÑA INCORRECTOS");
//                    break;
//                }
        }
    }
}