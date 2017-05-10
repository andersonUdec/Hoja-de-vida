/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Andres Chila
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    private Panel1 panel1;
    private JMenuBar JMmenuBar;
    private JMenu JMArchivo, JMVer;
    private JMenuItem JMICrear, JMIAyuda, JMISalir, JMITabla;
    private DialogoVistaTabla dialogTabla;
    
    private static final String CREAR = "CREAR";
    
    private static final String AYUDA = "AYUDA";
    
    private static final String SALIR = "SALIR";
    
    private static final String VER = "VER";
    
    public VentanaPrincipal(){
        setSize(800, 600);
        setTitle("Hoja de vida");
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
               
        JMmenuBar = new JMenuBar();        
        setJMenuBar(JMmenuBar);
        
        JMArchivo = new JMenu("Archivo");
        
        JMICrear = new JMenuItem("Crear");
        JMICrear.addActionListener(this);
        setVisible(true);
        
        JMIAyuda = new JMenuItem("Ayuda");
        JMIAyuda.addActionListener(this);
        setVisible(true);
        
        JMISalir = new JMenuItem("Salir");
        JMISalir.addActionListener(this);
        setVisible(true);
        
        JMArchivo.add(JMICrear);
        JMArchivo.add(JMIAyuda);
        JMArchivo.add(JMISalir); 
        JMmenuBar.add(JMArchivo);
        
        JMITabla = new JMenuItem("Tabla");
        JMITabla.addActionListener(this);
        setVisible(true);
        
        JMVer = new JMenu("Ver");
        JMVer.add(JMITabla);
        JMmenuBar.add(JMVer);
        
        dialogTabla = new DialogoVistaTabla(this);
        
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JMICrear) {
            panel1 = new Panel1(this);
            panel1.setBounds(10, 10, 760, 540);
            add(panel1);
        }
        else if(e.getSource()== JMITabla){        
            dialogTabla.actualizarTablaPersona();
            dialogTabla.setVisible(true);
        }
        else if(e.getSource()==JMISalir) {
            System.exit(0);
        }
    }

    public Panel1 getPanel1() {
        return panel1;
    }
    
}
