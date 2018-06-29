/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modelologin;
import vista.Login;
import vista.elegirsucursal;

/**
 *
 * @author alfredo
 */
public class controlelegirsucursal implements ActionListener{
    private elegirsucursal vista;
    public static String guardar="";
    public static String ip="";
    public int bandera = 1;
    public static String getGuardar() {
        return guardar;
    }

    public static void setGuardar(String guardar) {
        controlelegirsucursal.guardar = guardar;
    }

    public String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        controlelegirsucursal.ip = ip;
    }
    
    public controlelegirsucursal(elegirsucursal vista, int bandera)
    {
        this.vista = vista;
        this.bandera= bandera; 
        this.vista.combo.addActionListener(this);
        this.vista.botonaceptar.addActionListener(this);
    }
    
    public controlelegirsucursal()
    {
        this.guardar = "";
        this.ip = "";
    }
    
    public void iniciarVista()
    {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String valor1 = "SUR";
        String valor2 = "NORTE";
        String valor3 = "CENTRO";
        if(vista.botonaceptar == e.getSource())
        {
            guardar = vista.combo.getSelectedItem().toString();
            if(guardar == valor1)
            {
                //ip = "192.168.63.12";
                ip = "192.168.43.65";
            }
            else if(guardar == valor2)
            {
               // ip = "192.168.1.71";
                ip = "localhost";
                ip = "192.168.43.12";
            }
            else if(guardar == valor3)
            {
                ip = "192.168.43.141";
            }
            //JOptionPane.showMessageDialog(null, "La ip es: " + ip);
            
//            vista.panel_el0egir.removeAll();
//            vista.panel_elegir.revalidate();
//            vista.panel_elegir.repaint();
            if (bandera != 1)
            {  
                vista.setVisible(false);
                Login lo = new Login();
                modelologin mode = new modelologin();
                controllogin control2 = new controllogin(mode,lo,ip);
                control2.iniciarvista();
            }  
            else 
                vista.setVisible(false);
        }
    }
}
