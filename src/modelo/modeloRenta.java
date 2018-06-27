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
 * @author ITZEL
 */
public class modeloRenta {
    private ConexionBD conexion = new ConexionBD();
    
    public String[] nombreCliente(String id){
        try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT nombre, apellidos FROM cliente WHERE idCliente = "+id+";");
           //la contidad de columnas que tiene la consulta
            String a [] = new String[2];
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             a[0] = rs.getString(1);
             a[1] = rs.getString(2);
            }
            //cerrar conexión
            conexion.cerrarConexion(con);         
            return a; 
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
            return null;    
        }
    }
    
    public String[] nombreLibro(String idL, String idS){
        try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT libro.titulo, inventario.existencia from libro INNER JOIN inventario ON inventario.libro_isbn = libro.isbn WHERE inventario.sucursal_idSucursal = "+idS+" and libro.isbn = "+idL+";");
           //la contidad de columnas que tiene la consulta
            String a [] = new String[2];
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
//            
            return a; 
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
            return null;    
        }
    }
    
    public boolean insertarRenta(String [][] libros, String frenta, String fdefinida, String idCliente, String idEmpleado){
        try{
            //Se abre la conexion con la bd.
            Connection con = conexion.abrirConexion();
            //Permite crear consultas
            Statement s = con.createStatement();
            //Inserta un registro en la tabla Viaje.
            int idRenta = ultimaRenta();
            System.out.println(""+idRenta);
            int registroRenta = s.executeUpdate(
                 "INSERT INTO `renta`(`fechaRenta`, `fechaDefinida`, "
                         + "`cliente_idCliente`, `empleado_idEmpleado`) VALUES "
                         + "('"+frenta+"','"+fdefinida+"',"+idCliente+","+idEmpleado+")");
                        
            
            //Inserta un registro en la tabla detalleRenta.
            for(int i=0; i<libros.length; i++){
                System.out.println("i2:"+i);
                int registroDetalleRenta = s.executeUpdate(
                        "INSERT INTO `detallerenta`(`renta_idRenta`, "
                                + "`libro_ISBN`, `cantidadLibro`) VALUES "
                                + "("+idRenta+","+libros[i][0]+","+libros[i][2]+")");
            }
                        
            conexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return false;
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    }
    
    public int ultimaRenta(){
        try
        {                   
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'biblioteca' AND TABLE_NAME = 'renta'");
            rs.next();
            //copiar del resultset al array
            int  a  = Integer.parseInt(rs.getString(1));
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return a; 
        }
        catch(SQLException e)
        {
          return -1;    
        }
    }
}
