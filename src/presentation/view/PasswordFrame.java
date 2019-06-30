package presentation.view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import presentation.constant.ColorConstant;
import presentation.template.TemplateButton;
import presentation.template.TemplateFrame;

public class PasswordFrame extends TemplateFrame {

	private final Font labelsFont;
	private final JLabel passwordText;	
	private JPasswordField passwordField;
	private JButton passwordButton;

	public JPasswordField getPasswordField() {
		return passwordField;
	}	

	public JButton getPasswordButton() {
		return passwordButton;
	}	

	public PasswordFrame() {
		labelsFont = new Font("Comic Sans MS", Font.BOLD, 70);
		passwordText = new JLabel();
		passwordField = new JPasswordField();
		passwordButton = new TemplateButton();		
	}

	@Override
	public void addComponents() {
		add(passwordText);
		add(passwordField);
		add(passwordButton);
	}

	public void addController(ActionListener listener) {
		passwordButton.addActionListener(listener);
	}
	
	@Override
	public void setComponentsProperties() {
		setPasswordTextProperties();
		setPasswordFieldProperties();
		setPasswordButtonProperties();
	}

	private void setPasswordTextProperties() {
		passwordText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
		passwordText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
		passwordText.setForeground(ColorConstant.BLACK);
		passwordText.setFont(labelsFont);
		passwordText.setText("Ingrese su contraseña");
		passwordText.setHorizontalAlignment(JLabel.CENTER);
		passwordText.setVerticalAlignment(JLabel.CENTER);
	}

	private void setPasswordFieldProperties() {
		passwordField.setLocation((int) (getWidth() * 0.35), (int) (getHeight() * 0.60));
		passwordField.setSize((int) (getWidth() * 0.30), (int) (getHeight() * 0.06));
		passwordField.setFont(labelsFont);
		passwordField.setHorizontalAlignment(JPasswordField.CENTER);
		passwordField.setEchoChar('*');
	}

	private void setPasswordButtonProperties() {
		passwordButton.setLocation(passwordField.getX(),
				passwordField.getY() + passwordField.getHeight() + (int) (getHeight() * 0.01));
		passwordButton.setSize(passwordField.getSize());
		passwordButton.setText("ingresar");
	}
        public boolean campoVacio() {
		return getPasswordField().getText().equals("") || getPasswordField().getText().equals("");
	}

}