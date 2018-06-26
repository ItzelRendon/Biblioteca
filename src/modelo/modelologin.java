/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author alfredo
 */
public class modelologin {
    private ConexionBD conexion = new ConexionBD();
    
    public int ingresar(String usu, String contra)
    {
        String capturar="";
        int control=0;
        ResultSet sql;       
         try {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            sql = s.executeQuery("SELECT * FROM login WHERE usuario='" + usu + "' && contraseña='" + contra + "' ");
           
            while(sql.next())
            {
                capturar = sql.getString("usuario");
            }
            if(capturar.equals(usu))
            {
                control = 4;
            }
            if((!capturar.equals(usu)))
            {
                control = 2;
            }
           conexion.cerrarConexion(con);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
        }
         return control;
    }
}