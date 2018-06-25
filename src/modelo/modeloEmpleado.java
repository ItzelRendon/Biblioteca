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
import javax.swing.JOptionPane;

/**
 *
 * @author Holi
 */
public class modeloEmpleado {
    private ConexionBD conexion = new ConexionBD();
    
    public boolean agregarEmpleado(String nombre, String apellidos, String puesto, String telefono, String domicilio, String rfc, String correo, int sucursal) {            
        try {
            Connection con = conexion.abrirConexion();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            int id = ultimoId();
            //Update en la tabla destino
            int registro = s.executeUpdate(
                 "insert into empleado(idEmpleado, nombre, apellidos, puesto, telefono, domicilio, rfc, correo, sucursal_idSucursal) values("
                         + ""+id+", '"+nombre+"', '"+apellidos+"', '"+puesto+"', '"+telefono+"', '"+domicilio+"', '"+rfc+"', '"+correo+"', "+sucursal+");");
            
            conexion.cerrarConexion(con);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            return true;
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return false;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    } 
    
   public int agarrarSucursal(String nombre)
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select idSucursal from sucursal where "
                    + "nombre = '"+nombre+"';");
           //la contidad de columnas que tiene la consulta
           int id=0;
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             id = rs.getInt(1);
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return id; 
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return 0;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return 0;
        }
    }
   public String [] Sucursal()
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select nombre from sucursal;");
//            ResultSet rs2 = s.executeQuery("select COUNT(nombre) from sucursal;");
            //declaración del array
            int filas = filasSucursal();
            String [] a = new String [filas];
            //contador para copiar del resultset al array
            int i = 0;
            //copiar del resultset al array
            while (rs.next())
            {
                a[i] = rs.getString(1);
                i++;
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return a;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return null;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return null;
        }
    }
   public int filasSucursal()
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs2 = s.executeQuery("select COUNT(nombre) from sucursal;");
            //declaración del array
            int filas = 0;
            //contador para copiar del resultset al array
            int x = 0;
            //copiar del resultset al array
            while (rs2.next())
            {
                filas = rs2.getInt(1);
                x++;
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return filas;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return 0;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return 0;
        }
    }

   public int ultimoId()
   {
       try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT MAX(idEmpleado) from empleado;");
           //la contidad de columnas que tiene la consulta
           int id=0;
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             id = rs.getInt(1);
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return id+1; 
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return 0;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return 0;
   }
   }

}
