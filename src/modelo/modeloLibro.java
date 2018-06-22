package modelo;

import java.sql.*;

public class modeloLibro {
    private String ISBN;
    private String Titulo;
    private String Genero;
    private String Autor;
    private String Editorial;
    private int Paginas;
    private Conexion conexion = new Conexion();
    
    public boolean Insertar(String ISBN, String Titulo, String Genero, String Autor, String Editorial, int Paginas) {            
        try {
            Connection con = conexion.abrirConexion();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            
            //Update en la tabla destino
            int registro = s.executeUpdate(
                 "insert into libro(isbn, titulo, genero, autor, editorial, paginas)values("
                         + "'"+ISBN+"','"+Titulo+"','"+Genero+"',,'"+Autor+"','"+Editorial+"''"+Paginas+"');");
            
            conexion.cerrarConexion(con);
            return true;
            
        }catch (SQLException e){
            return false;
        }
    }
}
