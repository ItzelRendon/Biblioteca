package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modeloLibro;
import vista.Libro;

<<<<<<< HEAD
public class controlLibro implements ActionListener, MouseListener{
    private modeloLibro modelo;
    private Libro vista;
=======
public class controlLibro implements ActionListener, MouseListener
{
     private modeloLibro modelo;
     private Libro vista;
>>>>>>> ced6e8dd9e2cc8126b9f855dee68cfb8b4e4eb71

    
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
        this.vista.jcb_Genero.setSelectedItem(null);
    }
     
    //Limpia los JTextField
    public void Limpiar(){
        vista.txt_ISBN.setText("");
        vista.txt_Titulo.setText("");
        vista.txt_Autor.setText("");
        vista.jcb_Genero.setSelectedItem(null);
        vista.jsp_Paginas.setValue(0);
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
<<<<<<< HEAD
    public void actionPerformed(ActionEvent evento){
        CamposVacios();//Funcion para habilitar 
        if(vista.btn_Agregar == evento.getSource()) {
            if(validacionCamposVacios()==null)
            {
                if(modelo.Insertar(vista.txt_ISBN.getText(), vista.txt_Titulo.getText(), vista.jcb_Genero.getSelectedItem().toString(), vista.txt_Autor.getText(), vista.txt_Editorial.getText(), vista.jsp_Paginas.getValue().toString())){
                JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                Limpiar();
=======
    public void actionPerformed(ActionEvent evento)
    {
         CamposVacios();//Funcion para habilitar 
         if(vista.btn_Agregar == evento.getSource()) 
         {
            if(validacionCamposVacios()==null)
            {
                //Inserta Destino
                if(modelo.Insertar(vista.txt_ISBN.getText(), vista.txt_Titulo.getText(), vista.jcb_Genero.getActionCommand(), vista.txt_Autor.getText(), vista.txt_Editorial.getText(), vista.jsp_Paginas.getName()))
                {
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                    Limpiar();
>>>>>>> ced6e8dd9e2cc8126b9f855dee68cfb8b4e4eb71
                }
            }
            else 
            JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
        }
        
        if(vista.btn_Cancelar == evento.getSource()){
            Limpiar();
            desabilitar();
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