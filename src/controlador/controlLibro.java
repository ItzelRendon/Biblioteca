package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modeloLibro;
import modelo.modeloLibro2;
import vista.Frame;
import vista.Libro;
import vista.Libro2;
import vista.menu;

/**
 *
 * @author Adriana
 */

public class controlLibro implements ActionListener, MouseListener{
    private modeloLibro modelo;
    private Libro vista;
    private Libro2 vista2;
    private Frame frame;
    private String [] empleado;
    private int id_Sucursal;
    
    public controlLibro(modeloLibro modelo, Libro vista, Frame frame, Libro2 vista2, String [] empleado){
        this.modelo = modelo;
        this.vista = vista;
        this.vista2 = vista2;
        this.frame = frame;
        this.empleado = empleado;
        this.vista.txt_ISBN.addActionListener(this);
        this.vista.txt_Titulo.addActionListener(this);
        this.vista.txt_Autor.addActionListener(this);
        this.vista.jcb_Genero.addActionListener(this);
        this.vista.jsp_Paginas.addMouseListener(this);
        this.vista.txt_Editorial.addActionListener(this);
        this.vista.btn_Agregar.addActionListener(this);
        this.vista.btn_Cancelar.addActionListener(this);
        this.vista.btn_Inventario.addActionListener(this);
        
        desabilitar();
    }
     
    public void iniciarVista(){
        vista.setVisible(true);
        this.vista.jcb_Genero.setSelectedItem(null);
        Nombre_Sucursal();        
        vista.txt_Sucursal.setEnabled(false);
    }
    
    public void Nombre_Sucursal(){
        if(empleado[3].equals("1")){
            vista.txt_Sucursal.setText("NORTE");
            id_Sucursal=1;
        }
        else if(empleado[3].equals("2")){
            vista.txt_Sucursal.setText("SUR");
            id_Sucursal=2;
        }
        else if(empleado[3].equals("3")){
            vista.txt_Sucursal.setText("CENTRO");
            id_Sucursal=3;
        }
    }
     
    //Limpia los JTextField
    public void Limpiar(){
        vista.txt_ISBN.setText("");
        vista.txt_Titulo.setText("");
        vista.txt_Autor.setText("");
        vista.jcb_Genero.setSelectedItem(null);
        vista.jsp_Paginas.setValue(0);
        vista.jsp_Existencia.setValue(0);
        vista.txt_Editorial.setText("");
    }
     
    //Habilita botones
    public void habilitar(){
        vista.btn_Agregar.setEnabled(true);
     }
     
    //Desabilita botones
    public void desabilitar(){
        vista.btn_Agregar.setEnabled(false);
    }
    
    //Se valida si los campos estas vacios o no
     public String validacionCamposVacios()
    {
        if(vista.txt_ISBN.getText().isEmpty() || vista.txt_Titulo.getText().isEmpty() || vista.txt_Autor.getText().isEmpty() || vista.jcb_Genero.getSelectedItem().toString().isEmpty() || vista.jsp_Paginas.getValue().toString().isEmpty() || vista.txt_Editorial.getText().isEmpty())
            return "Favor de llenar todos los campos"; 
        else return null;
    }

    //Compara si los campos no estan vacios para habilitar los botones
    public void CamposVacios(){
        if(vista.txt_ISBN.getText().isEmpty() || vista.txt_Titulo.getText().isEmpty() || vista.txt_Autor.getText().isEmpty() || vista.jcb_Genero.getSelectedItem().toString().isEmpty() || vista.jsp_Paginas.getValue().toString().isEmpty() || vista.txt_Editorial.getText().isEmpty())
            desabilitar();
        else
            habilitar();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        CamposVacios();//Funcion para habilitar 
        if(vista.btn_Agregar == evento.getSource()) {
            if(validacionCamposVacios()==null)
            {
                if(modelo.InsertarLibro(vista.txt_ISBN.getText(), vista.txt_Titulo.getText(), 
                    vista.jcb_Genero.getSelectedItem().toString(), vista.txt_Autor.getText(), 
                    vista.txt_Editorial.getText(), vista.jsp_Paginas.getValue().toString())){
                if(modelo.InsertarInventario(vista.txt_ISBN.getText(), id_Sucursal, 
                    Integer.parseInt(vista.jsp_Existencia.getValue().toString()))){
                JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                Limpiar();
                }
            }
            else 
            JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
            }
        }
        
        if(vista.btn_Cancelar == evento.getSource()){
            Limpiar();
            desabilitar();
            menu vistaMenu = new menu();
            controladorMenu control = new controladorMenu(vistaMenu, frame, empleado);
            new CambiaPanel(frame.pnl_cambiante,vistaMenu);
            control.iniciarVista();
        }
        
        if(vista.btn_Inventario == evento.getSource()){
            modeloLibro2 modelo = new modeloLibro2(); 
            controlLibro2 con = new controlLibro2(modelo, vista2); 
            con.iniciarVista(); 
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }  
}