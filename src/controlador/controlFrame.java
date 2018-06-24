/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloEmpleado;
import modelo.modeloLibro;
import vista.Empleado;
import vista.Frame;
import vista.Libro;

/**
 *
 * @author Holi
 */
public class controlFrame {
    
    private Frame vista;
    
    public controlFrame(Frame vista)
    {
<<<<<<< HEAD
        this.vista=vista;
=======
        this.vista = vista;
>>>>>>> ced6e8dd9e2cc8126b9f855dee68cfb8b4e4eb71
    }
    
    public void iniciar()
            
    {
<<<<<<< HEAD
        this.vista.setSize(500, 700);
=======
        vista.setSize(495, 700);
        vista.setLocationRelativeTo(null);
>>>>>>> ced6e8dd9e2cc8126b9f855dee68cfb8b4e4eb71
        this.vista.setVisible(true);
        this.vista.pnl_cambiante.removeAll();
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Crea objetos del siguiente panel
//        Empleado vistaemp = new Empleado();
//        modeloEmpleado modeloemp = new modeloEmpleado();
//        controlEmpleado controlemp = new controlEmpleado(modeloemp, vistaemp);
          Libro vistaemp = new Libro();
          modeloLibro modeloemp = new modeloLibro();
          controlLibro controlemp = new controlLibro(modeloemp, vistaemp);
        //Lo añade al panel
        this.vista.pnl_cambiante.add(vistaemp);
        this.vista.pnl_cambiante.revalidate();
        this.vista.pnl_cambiante.repaint();
        //Y lo muestra.
        controlemp.iniciarVista();
    }
    
}
