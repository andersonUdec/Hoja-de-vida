/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Andres Chila
 */
public class DialogoVistaTabla extends JDialog {
    JPanel panel;
    JTable tablaPersona;
    
    private DefaultTableModel dtm;
    private VentanaPrincipal ventana;
    public DialogoVistaTabla(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setSize(570, 300);
        setTitle("Vista Tabla");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Personas"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        dtm = new DefaultTableModel();
        tablaPersona = new JTable(dtm);
        
        Object[] columna = {"Cedula", "Correo", "Nombre", "Apellido", "Fecha Nacimiento", "profesion", "genero"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaPersona);
        scrollPane.setBounds(30, 30, 500, 200);
        panel.add(scrollPane);
    }
    
    public void actualizarTablaPersona() {
         List<Persona> lista = this.ventana.getPanel1().getListaPersona();
         for (Persona persona : lista) {
             Object[] fila = {persona.getCedula(), persona.getCorreo(), persona.getNombre(), persona.getApellido(), persona.getFechaNac(), persona.getProfesion(), persona.getGenero()};
             dtm.addRow(fila);
        }
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }
    
}
