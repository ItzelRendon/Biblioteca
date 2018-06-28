package modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class modeloLibro {
    private String ISBN;
    private String Titulo;
    private String Genero;
    private String Autor;
    private String Editorial;
    private String Paginas;
    private ConexionBD conexion = new ConexionBD();
    
    public boolean InsertarLibro(String ISBN, String Titulo, String Genero, String Autor, String Editorial, String Paginas) {            
        try {
            Connection con = conexion.abrirConexion();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            
            //Update en la tabla destino
            int registro = s.executeUpdate(
                 "insert into libro(isbn, titulo, genero, autor, editorial, paginas)values("
                         +"'"+ISBN+"','"+Titulo+"','"+Genero+"','"+Autor+"','"+Editorial+"','"+Paginas+"');");
            
            conexion.cerrarConexion(con);
            return true;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
    }
    
    public boolean InsertarInventario(String ISBN, int id_Sucursal, int Existencia) {            
        try {
            Connection con = conexion.abrirConexion();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            
            //Update en la tabla destino
            int registro = s.executeUpdate(
                 "insert into inventario(libro_isbn, sucursal_idSucursal, existencia)values("
                         +"'"+ISBN+"','"+id_Sucursal+"','"+Existencia+"');");
            
            conexion.cerrarConexion(con);
            return true;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
    }
}