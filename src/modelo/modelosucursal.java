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
 * @author alfredo
 */
public class modelosucursal {
    private String id;
    private String locacion;
    private String nombre;
    private String telefono;
    private ConexionBD conexion = new ConexionBD();
    
    public boolean Insertar(String id, String locacion, String nombre, String telefono) 
    {            
        try {
            Connection con = conexion.abrirConexion();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            
            //Update en la tabla destino
            int registro = s.executeUpdate(
                 "insert into sucursal(idSucursal, locación, nombre, telefono)values("
                         + "'"+id+"','"+locacion+"','"+nombre+"',,'"+telefono+"');");
            
            conexion.cerrarConexion(con);
            return true;
            
        }catch (SQLException e){
            return false;
        }
    }
}
