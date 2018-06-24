/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modelosucursal;
import vista.Sucursal;

/**
 *
 * @author alfredo
 */
public class controlsucursal implements ActionListener 
{
    private Sucursal vista;
    private modelosucursal modelo;
    
    public controlsucursal(Sucursal vista, modelosucursal modelo)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.textonombre.addActionListener(this);
        this.vista.textotelefono.addActionListener(this);
        this.vista.textotelefono.addActionListener(this);
        this.vista.textoid.addActionListener(this);
    }
    
    public void iniciarVista(){
         vista.setVisible(true);
         vista.setSize(600, 400);
     }
     
     //Limpia los JTextField
     public void Limpiar(){
        vista.textonombre.setText("");
        vista.textotelefono.setText("");
        vista.textodireccion.setText("");
        vista.textoid.setText("");
     }
     
     //Se valida si los campos estas vacios o no
     public String validacionCamposVacios()
    {
        if(vista.textonombre.getText().isEmpty() || vista.textotelefono.getText().isEmpty() || vista.textodireccion.getText().isEmpty() || vista.textoid.getName().isEmpty())
            return "Favor de llenar todos los campos"; 
        else return null;
    }
     
     //Habilita botones
     public void habilitar(){
         vista.botonagregar.setEnabled(true);
         vista.botoncancelar.setEnabled(true);
     }
     
     //Desabilita botones
     public void desabilitar(){
         vista.botonagregar.setEnabled(false);
         vista.botoncancelar.setEnabled(false);
     }
     
     //Compara si los campos no estan vacios para habilitar los botones
     public void CamposVacios(){
        if(vista.textonombre.getText().isEmpty() || vista.textotelefono.getText().isEmpty() || vista.textodireccion.getText().isEmpty() || vista.textoid.getName().isEmpty())
            desabilitar();
        else
             habilitar();
     }
     
    @Override
     public void actionPerformed(ActionEvent e)
     {
         CamposVacios();
         if(vista.botonagregar == e.getSource())
         {
             if(validacionCamposVacios() == null)
             {
                 if(modelo.Insertar(vista.textonombre.getText(), vista.textotelefono.getText(), vista.textodireccion.getText(), vista.textoid.getText()))
                 {
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                    Limpiar();
                 }
             }
             else
                 JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
         }
     }
}
