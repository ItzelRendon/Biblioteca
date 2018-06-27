/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.modeloCliente;
import vista.Cliente;
import vista.Frame;
import vista.menu;

/**
 *
 * @author Fabiola Paez
 */
public class controlCliente implements ActionListener{
    private modeloCliente modelo; 
    private Cliente vista;
    private Frame frame;
    private String [] empleado;
    
    public controlCliente(modeloCliente modelo, Cliente vista, Frame frame, String [] empleado)// COntructor de parametros para poder manipular lo que hay en la vista Cliente
    {
        this.modelo= modelo; 
        this.vista= vista;  
        this.frame= frame; 
        this.empleado = empleado;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
    }
    public void iniciarVista()// Metodo que permite mostra la vista Cliente
    {
        vista.setVisible(true); 
    }
    public String validacionCamposVacios()// Metodo para validar los campos que se desean guardar
    {
        if(vista.txtNombre.getText().isEmpty() || vista.txtApellidos.getText().isEmpty() || vista.txtCCorreo.getText().isEmpty()
                || vista.txtCorreo.getText().isEmpty() || vista.txtDomicilio.getText().isEmpty() || vista.txtTelefono.getText().isEmpty())
            return "Favor de llenar todos los campos"; 
        else if (!validarEmail(vista.txtCCorreo.getText())||!validarEmail(vista.txtCorreo.getText()) )
            return "Favor de introducir un correo válido";
        else if(!vista.txtCCorreo.getText().equals(vista.txtCorreo.getText()))
            return "Favor de confirmar correctamente el correo";
        else if(!isNumericD(vista.txtTelefono.getText()))
            return "Favor de introducir correctamente el teléfono";
        else return null;
    }
    public boolean validarEmail(String email)// Metodo para validar que se introduzca un correo valido, devuelve true si es correcto
    {
        String emailPattern ="^[a-zA-Z0-9_]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
            return true;
        else
            return false;
    }
    private static boolean isNumericD(String cadena)// Metodo que devuelve true cuando se introdujeron caracteres numericos
    {
        try 
        {
            Double.parseDouble(cadena);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
    public void limpiar()// Metodo para limpiar los cuadros de texto cuando se agrega un nuevo registro o cancela 
    {
        vista.txtApellidos.setText(""); 
        vista.txtCCorreo.setText("");
        vista.txtCorreo.setText("");
        vista.txtTelefono.setText("");
        vista.txtDomicilio.setText("");
        vista.txtNombre.setText(""); 
    }
    @Override
    public void actionPerformed(ActionEvent ae) {// Aciones de los botones gurdar y cancelar 
        if(vista.btnGuardar == ae.getSource())
        {
           if(validacionCamposVacios()==null)
           {    
                if(modelo.insertarCliente(vista.txtNombre.getText(),vista.txtApellidos.getText(),vista.txtTelefono.getText(),vista.txtCorreo.getText(),vista.txtDomicilio.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
                    limpiar(); 
                }else 
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos");
           }
           else 
               JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
        }
        else if(vista.btnCancelar == ae.getSource())
                limpiar();
        else if(vista.btnRegresar == ae.getSource())
        {
            menu vistaMenu = new menu();
            controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
            new CambiaPanel(frame.pnl_cambiante,vistaMenu);
            control.iniciarVista();
        }
    }
}
