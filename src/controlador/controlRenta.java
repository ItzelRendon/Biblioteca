/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.modeloRenta;
import vista.Renta;

/**
 *
 * @author ITZEL
 */
public class controlRenta implements ActionListener, KeyListener{
    private modelo.modeloRenta modelo;
    private vista.Renta vista;
    DefaultListModel listModel;

    public controlRenta(modeloRenta modelo, Renta vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnAgrLibro.addActionListener(this);
        this.vista.btnAgrRenta.addActionListener(this);
        this.vista.btnCanRenta.addActionListener(this);
        
        this.vista.txtIDCliente.addKeyListener(this);
        this.vista.txtNombreC.addKeyListener(this);
        this.vista.txtISBN.addKeyListener(this);
        this.vista.txtNombreL.addKeyListener(this);
        
        listModel =  new DefaultListModel();
        vista.listLibros.setModel(listModel);
    }

    public void iniciarRenta(){
        vista.setVisible(true);        
        //Fecha
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fD = dateFormat.format(date);
        vista.lblFechaE.setText(fD);
        
        //Sumarle
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(dateFormat.parse(fD));
        } catch (ParseException ex) {
            System.out.println("Error");
        }
        c.add(Calendar.DATE, 5);  // number of days to add
        String fE = dateFormat.format(c.getTime());  // dt is now the new date
        vista.lblFechaD.setText(fE);
    }
        
    public void lipiarCajas(){
        this.vista.lblFechaD.setText("");
        this.vista.lblFechaE.setText("");
        
        this.vista.txtIDCliente.setText("");
        this.vista.txtISBN.setText("");
        this.vista.txtNombreC.setText("");
        this.vista.txtNombreL.setText("");
        
        //Limpia la lista
        listModel.clear();
       
        //Limpiar el spinner
        this.vista.spnCant.setValue(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnCanRenta){
            this.lipiarCajas();
        }
        
        if(e.getSource() == vista.btnAgrLibro){
            
            System.out.println("txtnombrel: "+vista.txtNombreL.getText());
            int spn = (int) vista.spnCant.getValue();
            System.out.println("spn: " + spn);
            if(vista.txtNombreL.getText().equals("") || vista.txtNombreL.getText().equals("ID Incorrecto") || spn == 0){
                    JOptionPane.showMessageDialog(null, "Introduce datos válidos");
            }
            else{
                listModel.addElement(vista.txtNombreL.getText() + "-" + vista.spnCant.getValue());
                
            }
                
        }
    }
    
//    public static void main(String[] args) {
//        modeloRenta modelo = new modeloRenta();
//        Renta vista = new Renta();
//        controlRenta control = new controlRenta(modelo, vista);
//        control.iniciarRenta();
//    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {        
        if(e.getSource() == vista.txtISBN){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(!vista.txtISBN.getText().equals("")){
                    String  [] b = modelo.nombreLibro(vista.txtISBN.getText());
                    if(b[0] == null)
                        vista.txtNombreL.setText("ID Incorrecto");
                    else
                        vista.txtNombreL.setText(b[0]);
                } 
                else {
                    vista.txtNombreL.setText("Ingrese ID");
                }
                
            }
        }
        
        if(e.getSource() == vista.txtIDCliente){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(!vista.txtIDCliente.getText().equals("")){
                    String  [] a = modelo.nombreCliente(vista.txtIDCliente.getText());
                    if(a[0] == null && a[1] == null)
                        vista.txtNombreC.setText("ID Incorrecto");
                    else
                        vista.txtNombreC.setText(a[0]+" "+a[1]);
                }
                else{
                    vista.txtNombreC.setText("Ingrese ID");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
