package presentation.template;

import java.awt.Toolkit;
import javax.swing.JFrame;

import presentation.constant.ColorConstant;

public abstract class TemplateFrame extends JFrame {

    public abstract void addComponents();

    public abstract void setComponentsProperties();

    public void init() {
        setProperties();
        setComponentsProperties();
        addComponents();
    }

    public void setProperties() {
        setUndecorated(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(ColorConstant.WHITE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false);
        setVisible(true);
    }

}
