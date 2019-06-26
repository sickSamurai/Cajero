package presentation.template;

import java.awt.Font;
import javax.swing.JButton;

import presentation.constant.ColorConstant;

public class TemplateButton extends JButton {

    public TemplateButton() {
        setFocusPainted(false);
        setBackground(ColorConstant.getBlack());
        setForeground(ColorConstant.getWhite());
        setFont(new Font("Comic Sans MS", Font.BOLD, 25));
    }

}
