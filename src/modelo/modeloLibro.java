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
            return false;
        }
    }
    
    public DefaultTableModel destinoConsultar(){
        try{
            //PARA ABRIR A LA BASE DE DATOS
            Connection con = conexion.abrirConexion();
            //PARA GENERAR CONSULTAS
            Statement s = con.createStatement();
            //PARA ESTABLECER EL MODELO AL JTABLE
            DefaultTableModel modelo;
            
            try{
                //EJECUTAR LA CONSULTA
                ResultSet rs = s.executeQuery("SELECT `libro_isbn`, `titulo`, `nombre`, `existencia` FROM `inventario` "
                        + "INNER JOIN libro ON inventario.libro_isbn=libro.isbn "
                        + "INNER JOIN sucursal ON inventario.sucursal_idSucursal=sucursal.idSucursal");
                //PARA ESTABLECER EL MODELO AL JTABLE
                modelo = new DefaultTableModel();
                //OBTENIENDO LA INFORMACION DE LAS COLUMNAS
                //QUE ESTAN SIENDO CONSULTADAS
                ResultSetMetaData rsMd = rs.getMetaData();
                //LA CANTIDAD DE COLUMNAS QUE TIENE LA CONSULTA
                int cantidadColumnas = rsMd.getColumnCount();
                //ESTABLECER COMO CABECERAS EL NOMBRE EL NOMBRE DE LAS COLUMNAS
                for(int i=1; i<=cantidadColumnas; i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                //CREANDO LAS FILAS PARA LA TABLE
                while (rs.next()){
                    Object[]fila=new Object[cantidadColumnas];
                    for(int i = 0; i<cantidadColumnas; i++){
                        fila[i]=rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{
            conexion.cerrarConexion(con);
        }
        } catch (SQLException e) {
        return null;
    }
}
}