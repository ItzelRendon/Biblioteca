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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.modeloRenta;
import vista.Frame;
import vista.Renta;
import vista.menu;

/**
 *
 * @author ITZEL
 */
public class controlRenta implements ActionListener, KeyListener{
    private modelo.modeloRenta modelo;
    private vista.Renta vista;
    private Frame frame;
    private String [] empleado;
    DefaultListModel listModel;
    public controlRenta()
    {
        
    }
    public controlRenta(modeloRenta modelo, Renta vista, Frame frame, String [] empleado) {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        this.empleado = empleado;
        
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
               
        this.vista.lblID.setText(empleado[2]);
        this.vista.lblNombreE.setText(empleado[0]+" "+empleado[1]);
        limpiarCajas();
        
    }
        
    public void limpiarCajas(){        
        this.vista.txtIDCliente.setText("");
        this.vista.txtISBN.setText("");
        this.vista.txtNombreC.setText("");
        this.vista.txtNombreL.setText("");
       
        //Limpiar el spinner
        this.vista.spnCant.setValue(0);
        
        this.vista.txtNombreC.setEnabled(false);
        this.vista.txtNombreL.setEnabled(false);
        //Limpia la lista
        listModel.clear();
    }
    
    public String formatoFecha(String fecha){
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dates = null;
        try {
            dates = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(controlRenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dates);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnCanRenta){
            String[] options = {"Limpiar Renta", "Volver al menú", "Permanecer aquí"};
            int seleccion = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres cancelar?", "¡Atención!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(seleccion == 0){
                this.limpiarCajas();        
            }
                
            if(seleccion == 1){
                frame.pnl_cambiante.removeAll();
                frame.pnl_cambiante.revalidate();
                frame.pnl_cambiante.repaint();
                menu vistaMenu = new menu();
                controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
                //Lo añade al panel
                frame.pnl_cambiante.add(vistaMenu);
                frame.pnl_cambiante.revalidate();
                frame.pnl_cambiante.repaint();
                //Y lo muestra.
                control.iniciarVista();
            }            
        }
        
        if(e.getSource() == vista.btnAgrLibro){
            //Cantidad a rentar
            int spn = (int) vista.spnCant.getValue();
            //si el nombre esta vacio o es in incorrecto o no se ha agregado cantidad a rentar
            if(vista.txtNombreL.getText().equals("") || vista.txtNombreL.getText().equals("ID Incorrecto") || spn == 0){
                    JOptionPane.showMessageDialog(null, "Introduce datos válidos");
            }
            else{
                //consulta el libro
                String  [] b = modelo.nombreLibro(vista.txtISBN.getText(),"1");
                //Si hay menos libros de los que se ingresa
                if(Integer.parseInt(b[1]) < spn){
                    JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
                    this.vista.spnCant.setValue(0);
                }
                //Si no hay en existencia marca error
                else if(Integer.parseInt(b[1])==0){
                    JOptionPane.showMessageDialog(null, "No hay en existencias");
                    this.vista.txtISBN.setText("");
                    this.vista.txtNombreL.setText("");    
                    this.vista.spnCant.setValue(0);
                }
                //Si hay en existencia lo agrega a la lista
                else if(Integer.parseInt(b[1])!=0){
                    listModel.addElement(vista.txtISBN.getText()+"-"+vista.txtNombreL.getText() + "-" + vista.spnCant.getValue());
                }
            }
                
        }
        
        if(vista.btnAgrRenta == e.getSource()){            
            if(!vista.txtIDCliente.equals("") && listModel.getSize() != 0){
                String [][] librosR = new String[listModel.getSize()][3];
                for(int i = 0; i< listModel.getSize();i++){
                    String lista = (String) listModel.getElementAt(i);
                    String[] parts = lista.split("-");
                    librosR[i][0] = parts[0];
                    librosR[i][1] = parts[1];
                    librosR[i][2] = parts[2];
                }
      //SUCURSAL          
                if(modelo.insertarRenta(librosR, formatoFecha(vista.lblFechaE.getText()), vista.txtIDCliente.getText(), vista.lblID.getText(), empleado[3]))
                {
                    JOptionPane.showMessageDialog(null, "Se ha realizado su renta con éxito");   
                    limpiarCajas();
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Datos incompletos");   
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {        
        if(e.getSource() == vista.txtISBN){
            //al dar enter en el isbn
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                //cuando hay algo en el isbn
                if(!vista.txtISBN.getText().equals("")){
    //SUCURSAL
                    String  [] b = modelo.nombreLibro(vista.txtISBN.getText(),empleado[3]);
                    if(b[0] == null)
                        vista.txtNombreL.setText("ID Incorrecto");
                    else{
                        vista.txtNombreL.setText(b[0]);
                    }     
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
