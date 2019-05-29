package presentacion;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class WelcomeFrame extends JFrame {

    private WelcomeController controller;
    private Model model;
    JLabel welcomeText;

    public WelcomeFrame() {
        controller = new WelcomeController();
        model = new Model();
        welcomeText = new JLabel("pepe");
    }

    public void addComponents() {
        add(welcomeText);
    }

    public void setProperties() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setWelcomeTextProperties() {        
        welcomeText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        welcomeText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.5));
        welcomeText.setFont(new Font("Times new roman",Font.BOLD ,200));
    }

}
