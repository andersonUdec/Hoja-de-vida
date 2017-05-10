/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

/**
 *
 * @author Andres Chila
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andres Chila
 */
public class Panel1 extends JPanel implements ActionListener, ItemListener{
     private VentanaPrincipal ventana;
     private JLabel LImagen;
     private JLabel LCedula;
     private JLabel LCorreo;
     private JLabel LNombre;
     private JLabel LFechaNac;
     private JLabel LProfesion;
     private JTextField TFCedula;
     private JTextField TFCorreo;
     private JTextField TFNombre;
     private JTextField TFechaNac;
     private JComboBox CBProfesion;
     private JCheckBox CBHombre, CBMujer;
     private JButton BGuardar;
     private ButtonGroup  CBGroupGenero;
     private List<Persona> listaPersona;
     private Persona persona;
     private String genero = "";
            
    public Panel1(VentanaPrincipal ventana) {
        
         listaPersona = new ArrayList<Persona>();
         this.ventana = ventana;
         setBorder(BorderFactory.createTitledBorder("Info"));
         setLayout(null);
         
         LImagen = new JLabel("Imagen:");
         LImagen.setBounds(480, 50, 150, 11);
         add(LImagen);
         
         LCedula = new JLabel("Cedula:");
         LCedula.setBounds(480, 70, 150, 11);
         add(LCedula);
         
         LCorreo = new JLabel("Correo:");
         LCorreo.setBounds(480, 90, 150, 11);
         add(LCorreo);
         
         LNombre = new JLabel("Nombre:");
         LNombre.setBounds(480, 110, 150, 11);
         add(LNombre);
         
         LFechaNac = new JLabel("Fecha nacimiento:");
         LFechaNac.setBounds(480, 130, 160, 11);
         add(LFechaNac);
         
         LProfesion = new JLabel("Profesion:");
         LProfesion.setBounds(480, 150, 160, 11);
         add(LProfesion);
         
         TFCedula = new JTextField();
         TFCedula.setBounds(530, 70, 120, 16);
         add(TFCedula);
         
         TFCorreo = new JTextField();
         TFCorreo.setBounds(530, 90, 120, 16);
         add(TFCorreo);
         
         TFNombre = new JTextField();
         TFNombre.setBounds(530, 110, 120, 16);
         add(TFNombre);
         
         TFechaNac = new JTextField();
         TFechaNac.setBounds(590, 130, 120, 16);
         add(TFechaNac);
         
         CBProfesion = new JComboBox(Profesion.values());
         CBProfesion.setBounds(550, 150, 120, 16);
         add(CBProfesion);
         
         CBGroupGenero = new ButtonGroup();
         
         CBHombre = new JCheckBox("Hombre");
         CBHombre.setBounds(476, 170, 80, 16);
         CBHombre.addItemListener(this);
         add(CBHombre);
         
         CBMujer = new JCheckBox("Mujer");
         CBMujer.setBounds(560, 170, 110, 16);
         CBMujer.addItemListener(this);
         add(CBMujer);
         
         CBGroupGenero.add(CBMujer);
         CBGroupGenero.add(CBHombre);
         
         BGuardar = new JButton("Guardar");
         BGuardar.addActionListener(this);
         BGuardar.setBounds(600, 230, 110, 20);
         add(BGuardar);
         
         
      }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BGuardar){
            if(ValidarDatosPersona() && validarCorreo() && ValidarNombre() && ValidarCedula()){
                persona = new Persona(TFCedula.getText(), TFCorreo.getText(), TFNombre.getText(), TFechaNac.getText(), (Profesion)CBProfesion.getSelectedItem(), genero);
                listaPersona.add(persona);
                JOptionPane.showMessageDialog(this, "Persona creada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                vaciarDatos();
            }
        }
    }
    private boolean validarCorreo(){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(TFCorreo.getText());
        if (mather.find() == true) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un correo valido.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "recuerde que el formato es ejemplo@Dominio.com", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    private boolean ValidarNombre(){
        if((TFNombre.getText().contains("1"))||(TFNombre.getText().contains("2"))||(TFNombre.getText().contains("3"))||(TFNombre.getText().contains("4"))||(TFNombre.getText().contains("5"))||(TFNombre.getText().contains("6"))||(TFNombre.getText().contains("7"))||(TFNombre.getText().contains("8"))||(TFNombre.getText().contains("9"))||(TFNombre.getText().contains("0"))){
            JOptionPane.showMessageDialog(this, "El nombre no puede contener numeros.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private boolean ValidarCedula(){
        Pattern pattern1 = Pattern.compile("^[_0-9-]");
        Matcher mather = pattern1.matcher(TFCedula.getText());
        if (mather.find() == true) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "La cedula solo puede tener numeros.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    private void vaciarDatos() {
        TFCedula.setText("");
        TFCorreo.setText("");
        TFNombre.setText("");
        TFechaNac.setText("");
        LNombre.setForeground(Color.BLACK);
        LCedula.setForeground(Color.black);
        LCorreo.setForeground(Color.black);
        LFechaNac.setForeground(Color.black);
        LProfesion.setForeground(Color.black);
        CBProfesion.setSelectedIndex(0);
        CBHombre.setSelected(false);
        CBMujer.setSelected(false);
        
    }
    public boolean ValidarDatosPersona(){
        if(TFCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar cedula.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCedula.setForeground(Color.red);
            return false;
        }
        if(TFCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un correo.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCorreo.setForeground(Color.red);
            return false;
        }
        if(TFNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombre.setForeground(Color.red);
            return false;
        }
        if(TFechaNac.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una fecha de nacimento.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LFechaNac.setForeground(Color.red);
            return false;
        }
        else if(CBProfesion.getSelectedItem() == Profesion.SELECCIONE) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una profesion.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        else if (genero == ""){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un genero.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }    

    @Override
    public void itemStateChanged(ItemEvent it) {
        if(it.getSource() == CBHombre){
            genero= "Hombre";
        }
        else if(it.getSource() == CBMujer){
            genero= "Mujer";
        }
    }
     public List<Persona> getListaPersona() {
        return listaPersona;
    }
}

