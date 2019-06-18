package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeFrame extends StandardFrame {

    private Model model;
    private JLabel welcomeText;
    private JButton readCardButton;
    private Font welcomeTextFont;
    private Font readCardButtonFont;

    public WelcomeFrame() {
        model = new Model();
        welcomeText = new JLabel();
        readCardButton = new JButton();
        welcomeTextFont = new Font("Comic Sans MS", Font.BOLD, 100);
        readCardButtonFont = new Font("Comic Sans MS", Font.BOLD, 25);
    }

    public JButton getReadCardButton() {
        return readCardButton;
    }

    public void addListener(ActionListener listener) {
        readCardButton.addActionListener(listener);
    }

    public void addComponents() {
        add(welcomeText);
        add(readCardButton);
    }

    public void setComponentsProperties() {
        setWelcomeTextProperties();
        setReadCardButtonProperties();
    }

    private void setWelcomeTextProperties() {
        welcomeText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        welcomeText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setFont(welcomeTextFont);
        welcomeText.setText("Bienvenido al cajero UD");
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setVerticalAlignment(JLabel.CENTER);
    }

    private void setReadCardButtonProperties() {
        readCardButton.setLocation((int) (welcomeText.getX() + welcomeText.getWidth() * 0.25), welcomeText.getY() + welcomeText.getHeight() + (int) (getHeight() * 0.10));
        readCardButton.setSize((int) (welcomeText.getWidth() * 0.50), (int) (getHeight() * 0.10));
        readCardButton.setFocusPainted(false);
        readCardButton.setBackground(Color.WHITE);
        readCardButton.setFont(readCardButtonFont);
        readCardButton.setText("PULSE EL BOTON PARA INGRESAR CUENTA");
    }

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
