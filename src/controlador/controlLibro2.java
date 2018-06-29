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
    private String isbn;
    private String existencia;
    public String [] empleado;
    
    public controlLibro2(modeloLibro2 modelo, Libro2 vista, String [] empleado){
        this.modelo = modelo;
        this.vista = vista;
        this.empleado = empleado;
        this.vista.tbl_libro.addMouseListener(this);
        this.vista.btn_Salir.addActionListener(this);
        this.vista.btn_Agregar2.addActionListener(this);
        this.vista.btn_Agregar2.setEnabled(false);
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
        
        if(vista.btn_Agregar2 == evento.getSource()){
            existencia = JOptionPane.showInputDialog("Existencia:", "");
            if(existencia != null){
                if(!existencia.equals("")){
                    modelo.Modificar(isbn, Integer.parseInt(empleado[3]),Integer.parseInt(existencia));
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                    vista.tbl_libro.setModel(modelo.Consultar());
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha ingresado la existencia");
                }
                
            }
        }
    }
    
    public void mouseClicked(MouseEvent e){
         if(vista.tbl_libro == e.getSource()){
            int fila = vista.tbl_libro.rowAtPoint(e.getPoint());
            this.vista.btn_Agregar2.setEnabled(true);
            if(fila > -1){
               //Guarda los valores de la tabla a los JTextField
               isbn=(String.valueOf(vista.tbl_libro.getValueAt(fila, 0)));
               existencia=(String.valueOf(vista.tbl_libro.getValueAt(fila, 3)));
            }
        }
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