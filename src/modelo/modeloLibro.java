package modelo;

import java.sql.*;

public class modeloLibro {
    private String ISBN;
    private String Titulo;
    private String Genero;
    private String Autor;
    private String Editorial;
    private String Paginas;
    private ConexionBD conexion = new ConexionBD();
    
    public boolean Insertar(String ISBN, String Titulo, String Genero, String Autor, String Editorial, String Paginas) {            
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
            return false;
        }
    }
}
