/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloDevolucion;
import vista.Devolucion;
import vista.Frame;
import vista.menu;

/**
 *
 * @author Holi
 */
public class controladorDevolucion implements ActionListener{
    
    private modeloDevolucion modelo ;
    private Devolucion vista;
    private Frame frame;
    private String [] empleado;
    int rows=0; 
    
    public controladorDevolucion(modeloDevolucion modelo, Devolucion vista, Frame frame, String [] empleado)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.frame = frame;
        this.empleado = empleado;
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnDevolver.addActionListener(this);
        this.vista.btnVer.addActionListener(this);
    }
    
    public void iniciarVista()
    {
        vista.setVisible(true);
        vista.tblDevolucion.setModel(encabezados());
    }
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
            int b=2;
            //Fecha
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = dateFormat.format(date);
            controlRenta convertirFecha = new controlRenta();
            String sFecha=convertirFecha.formatoFecha(fecha);
            DefaultTableModel model = null;
            
            if(vista.btnVer == e.getSource())
            {
               if(!vista.txtIdRenta.getText().equals(""))
                {
                    if(isNumeric(vista.txtIdRenta.getText()))
                    {
                        model = modelo.librosDetalleRenta(Integer.parseInt(vista.txtIdRenta.getText()));
                        vista.tblDevolucion.setModel(model);
                        rows = model.getRowCount();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Ingrese un id válido");
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "Ingresar un ID");
                }
            }
            if(vista.btnDevolver == e.getSource())
            {
                int sucursal = modelo.agarrarSucursal(Integer.parseInt(empleado[2]));
                String [][] isbnCantidad = modelo.agarrarCantidadIBSN(Integer.parseInt(vista.txtIdRenta.getText()), rows);
                
                for(int i = 0; i < rows; i++)
                {
                    int existencia = modelo.agarrarExistencia(isbnCantidad[i][0], sucursal);
                    existencia = existencia + Integer.parseInt(isbnCantidad[i][1]);
                    //si no se ha regresado la renta
                    String checar=modelo.checarFecha(Integer.parseInt(vista.txtIdRenta.getText()));
                    if(checar==null) {
                        //va a permitar actualizar el inventario
                        if (modelo.actualizarInventario(isbnCantidad[i][0], sucursal, existencia))
                        {
                            //y se le va a agregar la fecha a la tabla renta
                            modelo.fechaEntrega(sFecha, Integer.parseInt(vista.txtIdRenta.getText()));
                            b=1;
                        }
                        else
                            b=0;
                    } else JOptionPane.showMessageDialog(null, "Ya se entrego esta renta");
                      break;
                }
                if(b==1)
                {
                    JOptionPane.showMessageDialog(null, "Libros reestablecidos.");
                }
                else if(b==0)
                    JOptionPane.showMessageDialog(null, "Error el actualizar la base de datos.");
                
                
                vista.txtIdRenta.setText("");
                vista.tblDevolucion.setModel(encabezados());
            }
            if(vista.btnCancelar == e.getSource())
            {
                menu vistaMenu = new menu();

                controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
                //cambio de panel
                CambiaPanel cp = new CambiaPanel(frame.pnl_cambiante, vistaMenu);
                //Y lo muestra.
                control.iniciarVista();
            }
    }
    public DefaultTableModel encabezados()
    {
            DefaultTableModel modelo;
            
                //PARA ESTABLECER EL MODELO AL JTABLE
                modelo = new DefaultTableModel();
                //ESTABLECER COMO CABECERAS EL NOMBRE EL NOMBRE DE LAS COLUMNAS
                
                String [] encabezados = new String [3];
                encabezados[0]="ISBN";
                encabezados[1]="Titulo";
                encabezados[2]="Cantidad";
                for(int i=0; i<=2; i++){
                    modelo.addColumn(encabezados[i]);
                }
                return modelo; 
    }
}
