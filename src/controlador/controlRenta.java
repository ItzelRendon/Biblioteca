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
    
    DefaultListModel listModel;

    public controlRenta(modeloRenta modelo, Renta vista, Frame frame) {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        
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
        lipiarCajas();
        
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnCanRenta){
            String[] options = {"Limpiar Renta", "Volver al menú", "Permanecer aquí"};
            int seleccion = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres cancelar?", "¡Atención!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            if(seleccion == 0)
                this.lipiarCajas();
           
            if(seleccion == 1){
                frame.pnl_cambiante.removeAll();
                frame.pnl_cambiante.revalidate();
                frame.pnl_cambiante.repaint();
                menu vistaMenu = new menu();
                controladorMenu control = new controladorMenu(vistaMenu, frame);
                //Lo añade al panel
                frame.pnl_cambiante.add(vistaMenu);
                frame.pnl_cambiante.revalidate();
                frame.pnl_cambiante.repaint();
                //Y lo muestra.
                control.iniciarVista();
            }            
        }
        
        if(e.getSource() == vista.btnAgrLibro){
            
            System.out.println("txtnombrel: "+vista.txtNombreL.getText());
            int spn = (int) vista.spnCant.getValue();
            if(vista.txtNombreL.getText().equals("") || vista.txtNombreL.getText().equals("ID Incorrecto") || spn == 0){
                    JOptionPane.showMessageDialog(null, "Introduce datos válidos");
            }
            else{
                listModel.addElement(vista.txtNombreL.getText() + "-" + vista.spnCant.getValue());
                
            }
                
        }
        
        if(vista.btnAgrRenta == e.getSource()){
            String[] libros = new String[vista.listLibros.getModel().getSize()];
            for (int i = 0; i < vista.listLibros.getModel().getSize(); i++) {
                 libros[i] = String.valueOf(vista.listLibros.getModel().getElementAt(i));
            }
            
            if(!vista.txtIDCliente.equals("") && libros.length != 0){
                //Guardar aquí
                JOptionPane.showMessageDialog(null, "Éxito");   
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
