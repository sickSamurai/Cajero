package presentation.template;

import java.awt.Font;
import javax.swing.JButton;

public class TemplateButton extends JButton {

    public TemplateButton() {
        setFocusPainted(false);
        setBackground(ColorConstants.getBlack());
        setForeground(ColorConstants.getWhite());
        setFont(new Font("Comic Sans MS", Font.BOLD, 25));
    }

}
