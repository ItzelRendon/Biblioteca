/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.modeloEmpleado;
import vista.Empleado;
import vista.Frame;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.menu;

/**
 *
 * @author Holi
 */
public class controlEmpleado implements ActionListener{
    
    private modeloEmpleado modelo;
    private Empleado vista;
    private Frame frame;
    private String [] empleado;
   
    public controlEmpleado(modeloEmpleado modelo, Empleado vista, Frame frame, String [] empleado)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        this.empleado = empleado;
        this.vista.btnCancelar1.addActionListener(this);
        this.vista.btnGuardar1.addActionListener(this);
        
    }
    
    public void iniciarVista()
    {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(vista.btnGuardar1 == e.getSource())
        {
            if(vista.txtNombre1.getText().equals("") || vista.txtApellidos1.getText().equals("") || vista.txtCorreo1.getText().equals("")
                    || vista.txtDomicilio1.getText().equals("") || vista.txtRFC1.getText().equals("") || vista.txtTelefono1.getText().equals("") 
                    || vista.cbbPuesto1.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
            }
            else
            {
                String puesto = String.valueOf(vista.cbbPuesto1.getSelectedItem());
              
                if(modelo.agregarEmpleado(vista.txtNombre1.getText(), vista.txtApellidos1.getText(), puesto, vista.txtTelefono1.getText(), vista.txtDomicilio1.getText(), vista.txtRFC1.getText(), vista.txtCorreo1.getText(), empleado[3]))
                {
                    vista.txtNombre1.setText("");
                    vista.txtCorreo1.setText("");
                    vista.txtDomicilio1.setText("");
                    vista.txtApellidos1.setText("");
                    vista.txtRFC1.setText("");
                    vista.txtTelefono1.setText("");
                    vista.cbbPuesto1.setSelectedIndex(0);
                }
                
            }
        }
        if(vista.btnCancelar1 == e.getSource())
        {
            menu vistaMenu = new menu();

            controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
            //cambio de panel
            CambiaPanel cp = new CambiaPanel(frame.pnl_cambiante, vistaMenu);
            //Y lo muestra.
            control.iniciarVista();
        }
    }
}
