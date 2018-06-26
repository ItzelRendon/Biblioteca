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
import modelo.modeloInventario;
import vista.Inventario;

/**
 *
 * @author Hector
 */
public class controlInventario implements ActionListener, MouseListener{
   private modeloInventario modelo;
    private Inventario vista;
    
    public controlInventario(modeloInventario modelo, Inventario vista){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.txt_ISBN.addActionListener(this);
        this.vista.txt_Sucursal.addActionListener(this);
        this.vista.txt_Existencia.addActionListener(this);
        this.vista.btn_Agregar.addActionListener(this);
        this.vista.btn_Cancelar.addActionListener(this);
        this.vista.tbl_inventario.addMouseListener(this);
        
        desabilitar();
    }
     
    public void iniciarVista(){
        vista.tbl_inventario.setModel(modelo.destinoConsultar());
        vista.setVisible(true);
    }
     
    //Limpia los JTextField
    public void Limpiar(){
        vista.txt_ISBN.setText("");
        vista.txt_Sucursal.setText("");
        vista.txt_Existencia.setText("");
    }
     
    //Habilita botones
    public void habilitar(){
        vista.btn_Agregar.setEnabled(true);
     }
     
    //Desabilita botones
    public void desabilitar(){
        vista.btn_Agregar.setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent evento){
        if(vista.btn_Agregar == evento.getSource()) {
        }
        
        if(vista.btn_Cancelar == evento.getSource()){
            Limpiar();
            desabilitar();
        }
    }

   @Override
    public void mouseClicked(MouseEvent e) {
        if(vista.tbl_inventario == e.getSource()){
            int fila = vista.tbl_inventario.rowAtPoint(e.getPoint());
            if(fila > -1){
                //Guarda los valores de la tabla a los JTextField
                vista.txt_ISBN.setText(String.valueOf(vista.tbl_inventario.getValueAt(fila, 0)));
                vista.txt_Sucursal.setText(String.valueOf(vista.tbl_inventario.getValueAt(fila, 1)));
                vista.txt_Existencia.setText(String.valueOf(vista.tbl_inventario.getValueAt(fila, 2)));
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