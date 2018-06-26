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
<<<<<<< HEAD
        String capturar="";
        int control=0;
        ResultSet sql;       
=======
        ResultSet sql; 
        String ca ="";
        int bandera=0;
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
         try {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            sql = s.executeQuery("SELECT * FROM login WHERE usuario='" + usu + "' && contraseña='" + contra + "' ");
<<<<<<< HEAD
           
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
=======
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
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
            }
           conexion.cerrarConexion(con);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
<<<<<<< HEAD
        }
         return control;
    }
}
=======
            
        } catch (SQLException ex) {
            Logger.getLogger(modelologin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return bandera;
    }
}
>>>>>>> 5de0bf7d749476743d75017eb394cca5bf4a3f4d
