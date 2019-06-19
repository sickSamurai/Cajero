package presentacion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class TemplateButton extends JButton {
    
    public TemplateButton(){
        setFocusPainted(false);
        setBackground(Color.WHITE);
        setFont(new Font("Comic Sans MS", Font.BOLD, 25));
    }
    
}
