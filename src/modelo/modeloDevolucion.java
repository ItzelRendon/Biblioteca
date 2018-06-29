/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Holi
 */
public class modeloDevolucion {
    private ConexionBD conexion = new ConexionBD();
    
    public DefaultTableModel librosDetalleRenta(int idRenta){
        try{
            //PARA ABRIR A LA BASE DE DATOS
            Connection con = conexion.abrirConexion();
            //PARA GENERAR CONSULTAS
            Statement s = con.createStatement();
            //PARA ESTABLECER EL MODELO AL JTABLE
            DefaultTableModel modelo;
            
            try{
                //EJECUTAR LA CONSULTA
                ResultSet rs = s.executeQuery("select libro.isbn as 'ISBN', libro.titulo as 'Titulo', detallerenta.cantidadLibro as 'Cantidad'"
                        + "from libro, renta, detallerenta where "+idRenta+" = renta_idRenta and detallerenta.libro_ISBN = libro.isbn and "
                        + ""+idRenta+" = renta.idRenta;");
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
                //CREANDO LAS FILAS PARA LA TABLA
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
    
    public boolean actualizarInventario(String isbn, int sucursal, int existencia)
    {   try
            {
                Connection con= conexion.abrirConexion(); 
                Statement s= con.createStatement(); 
                int registro =s.executeUpdate("update inventario set existencia = "+existencia+" where sucursal_idSucursal = "+sucursal+" and libro_isbn = '"+isbn+"';"); 
                conexion.cerrarConexion(con); 
                return true; 
            }
            catch(SQLException e)
            {
                return false; 
            }catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
                return false;
            }
    }
    public int agarrarExistencia(String isbn, int sucursal)
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select existencia from inventario where sucursal_idSucursal = "+sucursal+" and libro_isbn = '"+isbn+"';");
           //la contidad de columnas que tiene la consulta
           int existencia=0;
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             existencia = rs.getInt(1);
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return existencia; 
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
    
    public String [][] agarrarCantidadIBSN(int idRenta, int filas)
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select libro.isbn, detallerenta.cantidadLibro "
                        + "from libro, renta, detallerenta where "+idRenta+" = renta_idRenta and detallerenta.libro_ISBN = libro.isbn and "
                        + ""+idRenta+" = renta.idRenta;");
            
           //la contidad de columnas que tiene la consulta
           String [][] array = new String [filas][2];
           int i =0;
            while(rs.next()) {
            //Si hay resultados obtengo el valor. 
             array[i][0] = rs.getString(1); //isbn
             array[i][1] = rs.getString(2); //cantidad
             System.out.println(array[i][0]+" "+array[i][1]+"\n");
             i++;
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return array; 
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
    
    public int agarrarSucursal(int idEmpleado)
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select sucursal_idSucursal from empleado where idEmpleado = "+idEmpleado+";");
           //la contidad de columnas que tiene la consulta
            int sucursal = 0;
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             sucursal = rs.getInt(1);
            }
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return sucursal; 
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

    public boolean fechaEntrega(String fecha, int idRenta)
    {   try
            {
                Connection con= conexion.abrirConexion(); 
                Statement s= con.createStatement(); 
                s.executeUpdate("update renta set fechaEntrega = '"+fecha+"' where idRenta = "+idRenta+";"); 
                conexion.cerrarConexion(con); 
                return true; 
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la base de datos.");
                return false; 
            }catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
                return false;
            }
    }
    
    public String checarFecha(int idRenta)
    {   try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("select fechaEntrega from renta where idRenta = "+idRenta+";");
            //la contidad de columnas que tiene la consulta
           String resultado="";
            if(rs.next()) {
            //Si hay resultados obtengo el valor. 
             resultado = rs.getString(1);
            }
            String fecha=null;
            if(resultado!=null)
                fecha = rs.getString(1);
            //cerrar conexión
            conexion.cerrarConexion(con); 
            return fecha; 
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos.");
            return null;    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor.");
            return null;
        }
    }

}
