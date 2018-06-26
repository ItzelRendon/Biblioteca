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
    
    public controlEmpleado(modeloEmpleado modelo, Empleado vista, Frame frame)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        this.vista.btnCancelar1.addActionListener(this);
        this.vista.btnGuardar1.addActionListener(this);
        
    }
    
    public void iniciarVista()
    {
        vista.setVisible(true);
        vista.cbbSucursal1.removeAllItems();
        String [] sucursal = modelo.Sucursal();
        int l = sucursal.length;
        for(int i=0; i<l; i++)
        {
            vista.cbbSucursal1.addItem(sucursal[i]);
        }
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
                String sucursal = String.valueOf(vista.cbbSucursal1.getSelectedItem());
                int idSucursal = modelo.agarrarSucursal(sucursal);
              
                modelo.agregarEmpleado(vista.txtNombre1.getText(), vista.txtApellidos1.getText(), puesto, vista.txtTelefono1.getText(), vista.txtDomicilio1.getText(), vista.txtRFC1.getText(), vista.txtCorreo1.getText(), idSucursal);
                
            }
        }
        if(vista.btnCancelar1 == e.getSource())
        {
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
}