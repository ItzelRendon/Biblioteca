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
//            
            return a; 
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
            return null;    
        }
    }
    
    public String[] nombreLibro(String id){
        try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT titulo FROM libro WHERE isbn = "+id+";");
           //la contidad de columnas que tiene la consulta
            String a [] = new String[2];
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             a[0] = rs.getString(1);
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
}
