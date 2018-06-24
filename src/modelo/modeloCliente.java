/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Fabiola Paez
 */
public class modeloCliente {
     private ConexionBD conexion= new ConexionBD();
    
    public boolean insertarCliente(String cNombre, String cApellidos, String cTelefono, String cCorreo, String cDomicilio)
    {   try
        {
            Connection con= conexion.abrirConexion(); 
            Statement s= con.createStatement(); 
            int registro =s.executeUpdate("insert into cliente(nombre, apellidos, telefono, domicilio, correo, multa)values('"+cNombre+"','"+cApellidos+"','"+cTelefono+"','"+cDomicilio+"','"+cCorreo+"',"+0.0+");"); 
            conexion.cerrarConexion(con); 
            return true; 
        }
        catch(SQLException e)
        {
          return false;    
        }
    }
}
