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
    private String usu;
    private String contra;
    
    public int ingresar(String usu, String contra)
    {
        ResultSet sql; 
        String ca ="";
        int bandera=0;
         try {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            sql = s.executeQuery("SELECT * FROM login WHERE usuario='" + usu + "' && contraseña='" + contra + "' ");
//            while(sql.next())
//            {
//                nombre = sql.getString("usuario");
//                contraseña = sql.getString("contraseña");
//            }
//            if(nombre.equals(usu) || contraseña.equals(contra))
//            {
//                bandera = 1;
//            }
//            else
//            {
//                bandera = 2;
//            }
            while(sql.next())
            {
                ca = sql.getString("tipo");
            }
            if(ca.equals("empleado"))
            {
                bandera = 1;
            }
            else
            {
                bandera = 2;
            }
           conexion.cerrarConexion(con);
        }
         catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            
        } catch (SQLException ex) {
            Logger.getLogger(modelologin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return bandera;
    }
}
