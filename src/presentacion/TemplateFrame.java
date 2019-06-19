package presentacion;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class TemplateFrame extends JFrame {
        
    public void addComponents(){}
    
    public void setProperties() {
        setUndecorated(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(Integer.parseInt("191919", 16)));
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false);
        setVisible(true);
    }
    
}
