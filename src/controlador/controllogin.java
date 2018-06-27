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
import modelo.modelologin;
import vista.Frame;
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
        String usu = vista.textonombre.getText();
        String contra = new String(vista.textocontraseña.getPassword());
        
        if(vista.botonentrar == e.getSource())
        {   
            switch (modelo.ingresar(usu, contra)) 
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    Frame frame = new Frame();
                    controlFrame controlFrame = new controlFrame(frame);
                    vista.setVisible(false);
                    controlFrame.iniciar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "USUARIO/CONTRASEÑA INCORRECTOS");
                    break;
                default:
                    break;
            }
    }
}}