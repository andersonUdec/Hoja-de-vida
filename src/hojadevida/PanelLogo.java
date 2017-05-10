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
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelLogo extends JPanel{
    private JLabel imagen;
    private VentanaPrincipal ventana;
    
    public PanelLogo(VentanaPrincipal ventana) {
         
        this.ventana = ventana;
        setBackground(Color.WHITE);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        
        ImageIcon icon = new ImageIcon("Imagenes/result.png");        
        imagen = new JLabel();
        imagen.setIcon(icon);
        add(imagen);
        
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
    }
}