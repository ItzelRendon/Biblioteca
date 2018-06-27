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
        String capturar="";
        int control=0;
        ResultSet sql;       
        String ca ="";
        int bandera=0;
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
        } catch (SQLException ex) {
            Logger.getLogger(modelologin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return bandera;
    }
    
        //En esta funcion se usua para obtener informacion del usuario
    public String[] jalarIdEmpleado(String usu, String contra)
    {
        ResultSet sql;       
         try {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            sql = s.executeQuery("SELECT empleado.nombre, empleado.apellidos, login.empleado_idEmpleado FROM login INNER JOIN empleado ON empleado.idEmpleado = login.empleado_idEmpleado WHERE usuario='" + usu + "' && contraseña='" + contra + "' ");
            String [] a = new String [3];
            int i=0;
            while(sql.next())
            {
                //Aqui se guarda el resultado de la consulta en un array
                a[0]= sql.getString(1);
                a[1]= sql.getString(2);
                a[2]= sql.getString(3);
            }
           conexion.cerrarConexion(con);
           return a;
        }
        catch (SQLException ex)
        {
            return null;
        }
         catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return null;
        }
    }
}