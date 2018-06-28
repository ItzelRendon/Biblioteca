/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.controlelegirsucursal;
import javax.swing.JFrame;
import vista.elegirsucursal;
/**
 *
 * @author Holi
 */
public class ConexionBD {
    public JFrame vista;
    public Connection abrirConexion() throws SQLException{
        Connection con;
        //Para conectarnos a nuestrza base de datos
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            if (controlelegirsucursal.ip != "localhost")
            con = DriverManager.getConnection("jdbc:mysql://"+controlelegirsucursal.ip+":3306/biblioteca", "root", "123456");
            else 
            con = DriverManager.getConnection("jdbc:mysql://"+controlelegirsucursal.ip+":3306/biblioteca", "root", "");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo abrir la conexión con la BD.");
            if (JOptionPane.showConfirmDialog(vista,"¿Desea cambiar de servidor?", "Libreria",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
            {
               elegirsucursal vistasu = new elegirsucursal();
               controlelegirsucursal cs = new controlelegirsucursal(vistasu,1);
               cs.iniciarVista();
            }
            con=null;
        }
        return con;
    }
            
    public void cerrarConexion(Connection c)
            throws SQLException{
        try{
            if(!c.isClosed()){
                c.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión de la BD.");
        }
    }
    
}
