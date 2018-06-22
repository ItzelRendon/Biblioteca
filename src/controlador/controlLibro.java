package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modeloLibro;
import vista.Libro;

public class controlLibro implements ActionListener, MouseListener{
     private modeloLibro modelo;
     private Libro vista;

    
     public controlLibro(modeloLibro modelo, Libro vista){
         this.modelo = modelo;
         this.vista = vista;
         this.vista.txt_ISBN.addActionListener(this);
         this.vista.txt_Titulo.addActionListener(this);
         this.vista.txt_Autor.addActionListener(this);
         this.vista.jcb_Genero.addActionListener(this);
         this.vista.jsp_Paginas.addMouseListener(this);
         this.vista.txt_Editorial.addActionListener(this);
         this.vista.btn_Agregar.addActionListener(this);
         this.vista.btn_Cancelar.addActionListener(this);
                 
         desabilitar();
     }
     
     public void iniciarVista(){
         vista.setVisible(true);
     }
     
     //Limpia los JTextField
     public void Limpiar(){
        vista.txt_ISBN.setText("");
        vista.txt_Titulo.setText("");
        vista.txt_Autor.setText("");
        vista.jcb_Genero.setSelectedIndex(0);
        vista.jsp_Paginas.setValue(0);
        vista.txt_Editorial.setText("");
     }
     
     //Se valida si los campos estas vacios o no
     public String validacionCamposVacios()
    {
        if(vista.txt_ISBN.getText().isEmpty() || vista.txt_Titulo.getText().isEmpty() || vista.txt_Autor.getText().isEmpty() || vista.jcb_Genero.getName().isEmpty() || vista.jsp_Paginas.getName().isEmpty() || vista.txt_Editorial.getText().isEmpty())
            return "Favor de llenar todos los campos"; 
        else return null;
    }
     
     //Habilita botones
     public void habilitar(){
         vista.btn_Agregar.setEnabled(true);
         vista.btn_Cancelar.setEnabled(true);
     }
     
     //Desabilita botones
     public void desabilitar(){
         vista.btn_Agregar.setEnabled(false);
         vista.btn_Cancelar.setEnabled(false);
     }
     
     //Compara si los campos no estan vacios para habilitar los botones
     public void CamposVacios(){
        if(vista.txt_ISBN.getText().isEmpty() || vista.txt_Titulo.getText().isEmpty() || vista.txt_Autor.getText().isEmpty() || vista.jcb_Genero.getName().isEmpty() || vista.jsp_Paginas.getName().isEmpty() || vista.txt_Editorial.getText().isEmpty())
            desabilitar();
        else
             habilitar();
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public void actionPerformed(ActionEvent evento){
         CamposVacios();//Funcion para habilitar 
         if(vista.btn_Agregar == evento.getSource()) {
            if(validacionCamposVacios()==null)
            {
                //Inserta Destino
                if(modelo.Insertar(vista.txt_ISBN.getText(), vista.txt_Titulo.getText(), vista.jcb_Genero.setSelectedIndex(), vista.txt_Autor.getText(), vista.txt_Editorial.getText(), vista.jsp_Paginas.setValue())){
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                    Limpiar();
                }
            }
         else 
            JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
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