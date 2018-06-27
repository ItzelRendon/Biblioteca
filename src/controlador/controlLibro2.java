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
import modelo.modeloLibro2;
import vista.Frame;
import vista.Libro2;

/**
 *
 * @author Adriana
 */
public class controlLibro2 implements ActionListener, MouseListener{
    private modeloLibro2 modelo;
    private Libro2 vista;
    
    public controlLibro2(modeloLibro2 modelo, Libro2 vista){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.tbl_libro.addMouseListener(this);
        this.vista.btn_Salir.addActionListener(this);
    }
    
    public void iniciarVista(){
        vista.setSize(500, 360);
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(vista.EXIT_ON_CLOSE);
        vista.setVisible(true);
        vista.tbl_libro.setModel(modelo.Consultar());
    }
    
@Override
    public void actionPerformed(ActionEvent evento){
        if(vista.btn_Salir == evento.getSource()) {
            vista.setVisible(false);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }  
}