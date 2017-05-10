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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
     private JLabel LCedula, LCorreo, LNombre, LApellido, LFechaNac, LProfesion, LGenero;
     private JTextField TFCedula;
     private JTextField TFCorreo;
     private JTextField TFNombre, TFApellido;
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
         LImagen.setBounds(50, 80, 150, 13);
         add(LImagen);
         
         LNombre = new JLabel("Nombre:");
         LNombre.setBounds(50, 110, 150, 13);
         add(LNombre);
         
         LApellido = new JLabel("Apellido:");
         LApellido.setBounds(170, 110, 150, 13);
         add(LApellido);
         
         LCedula = new JLabel("Cedula:");
         LCedula.setBounds(50, 150, 150, 13);
         add(LCedula);
         
         LCorreo = new JLabel("Correo:");
         LCorreo.setBounds(50, 200, 150, 13);
         add(LCorreo);
         
         LFechaNac = new JLabel("Fecha nacimiento:");
         LFechaNac.setBounds(175, 150, 160, 13);
         add(LFechaNac);
         
         LProfesion = new JLabel("Profesion:");
         LProfesion.setBounds(180, 200, 160, 13);
         add(LProfesion);
         
         LGenero = new JLabel("Genero:");
         LGenero.setBounds(50, 250, 120, 13);
         add(LGenero);
         
         TFCedula = new JTextField();
         TFCedula.setBounds(50, 170, 120, 16);
         add(TFCedula);
         
         TFCorreo = new JTextField();
         TFCorreo.setBounds(50, 220, 120, 16);
         add(TFCorreo);
         
         TFNombre = new JTextField();
         TFNombre.setBounds(50, 130, 120, 16);
         add(TFNombre);
         
         TFApellido = new JTextField();
         TFApellido.setBounds(171, 130, 120, 16);
         add(TFApellido);
         
         TFechaNac = new JTextField();
         TFechaNac.setBounds(175, 170, 120, 16);
         add(TFechaNac);
         
         CBProfesion = new JComboBox(Profesion.values());
         CBProfesion.setBounds(180, 220, 120, 16);
         add(CBProfesion);
         
         CBGroupGenero = new ButtonGroup();
         
         CBHombre = new JCheckBox("Hombre");
         CBHombre.setBounds(48, 270, 80, 16);
         CBHombre.addItemListener(this);
         add(CBHombre);
         
         CBMujer = new JCheckBox("Mujer");
         CBMujer.setBounds(140, 270, 110, 16);
         CBMujer.addItemListener(this);
         add(CBMujer);
         
         CBGroupGenero.add(CBMujer);
         CBGroupGenero.add(CBHombre);
         
         BGuardar = new JButton("Guardar");
         BGuardar.addActionListener(this);
         BGuardar.setBounds(250, 330, 110, 20);
         add(BGuardar);
         
         
      }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BGuardar){
            if(ValidarDatosPersona() && validarCorreo() && ValidarNombre() && ValidarApellido() && ValidarCedula() && ValidarFecha()){
                persona = new Persona(TFCedula.getText(), TFCorreo.getText(), TFNombre.getText(), TFApellido.getText(), TFechaNac.getText(), (Profesion)CBProfesion.getSelectedItem(), genero);
                listaPersona.add(persona);
                JOptionPane.showMessageDialog(this, "Persona creada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                vaciarDatos();
                EscrituraFichero();
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
    private boolean ValidarApellido(){
        if((TFApellido.getText().contains("1"))||(TFApellido.getText().contains("2"))||(TFApellido.getText().contains("3"))||(TFApellido.getText().contains("4"))||(TFApellido.getText().contains("5"))||(TFApellido.getText().contains("6"))||(TFApellido.getText().contains("7"))||(TFApellido.getText().contains("8"))||(TFApellido.getText().contains("9"))||(TFApellido.getText().contains("0"))){
            JOptionPane.showMessageDialog(this, "El apellido no puede contener numeros.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private boolean ValidarCedula(){
        Pattern pattern1 = Pattern.compile("^[0-9]");
        Matcher mather = pattern1.matcher(TFCedula.getText());
        if (mather.find() == true) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "La cedula solo puede tener numeros.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    private boolean ValidarFecha(){
        Pattern pattern2 = Pattern.compile("\\d[1-31]/\\d[1-12]/\\d[1970-2017]");
        Matcher mather = pattern2.matcher(TFechaNac.getText()); 
         if (mather.find() == true) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "Debe ingresar una fecha valida.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "recuerde que el formato es 12/12/2012 MM/dd/yyyy", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    private void vaciarDatos() {
        TFCedula.setText("");
        TFCorreo.setText("");
        TFNombre.setText("");
        TFApellido.setText("");
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
        
        if(TFNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombre.setForeground(Color.red);
            return false;
        }
        if(TFApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un apellido.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LApellido.setForeground(Color.red);
            return false;
        }
        if(TFechaNac.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una fecha de nacimento.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LFechaNac.setForeground(Color.red);
            return false;
        }
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
    
    public void EscrituraFichero(){
        try
        {
            File archivo = new File ("Archivos/persona.txt");
            FileWriter escribir = new FileWriter (archivo,true);
            escribir.write(persona.toString());
            escribir.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void LecturaFichero(){
        try{
            File archivo = new File ("Archivos/persona.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String linea = br.readLine();
            String palabra[] = linea.split(";");
            System.out.println(linea);
            int i;
            for(i=0;i<palabra.length;i++){
                String bufer[] = palabra[i].split(",");
                Persona person1 = new Persona(bufer[0], bufer[1], bufer[2], bufer[3], bufer[4], Profesion.valueOf(bufer[5]), bufer[6]);
                listaPersona.add(person1);
            }
        }
        catch(FileNotFoundException e){
             JOptionPane.showMessageDialog(this, "Aun no hay personas", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
     public List<Persona> getListaPersona() {
        return listaPersona;
    }
}

