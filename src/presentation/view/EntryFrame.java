package presentation.view;

import java.awt.Font;
import javax.swing.JLabel;

import presentation.constant.ColorConstant;
import presentation.template.TemplateFrame;

public class EntryFrame extends TemplateFrame {

	private Font labelsFont;
	private JLabel welcomeText;
	private JLabel insertText;
	private JLabel warningText;

	public EntryFrame() {
		labelsFont = new Font("Comic Sans MS", Font.BOLD, 100);
		welcomeText = new JLabel();
		insertText = new JLabel();
		warningText = new JLabel();
	}

	private void setWelcomeTextProperties() {
		welcomeText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
		welcomeText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
		welcomeText.setForeground(ColorConstant.BLACK);
		welcomeText.setFont(labelsFont);
		welcomeText.setText("Bienvenido al cajero UD");
		welcomeText.setHorizontalAlignment(JLabel.CENTER);
		welcomeText.setVerticalAlignment(JLabel.CENTER);
	}	

	private void setInsertTextProperties() {
		insertText.setLocation(welcomeText.getX(), welcomeText.getY() + welcomeText.getHeight() + 20);
		insertText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
		insertText.setForeground(ColorConstant.BLACK);
		insertText.setFont(labelsFont);
		insertText.setText("Inserte la tarjeta");
		insertText.setHorizontalAlignment(JLabel.CENTER);
		insertText.setVerticalAlignment(JLabel.CENTER);
	}
	
	private void setWarningTextProperties() {
		warningText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.40));
		warningText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.20));
		warningText.setForeground(ColorConstant.BLACK);
		warningText.setFont(labelsFont);
		warningText.setHorizontalAlignment(JLabel.CENTER);
		warningText.setVerticalAlignment(JLabel.CENTER);
		warningText.setVisible(false);
	}

	public void showWarningMessage(String text) {
		warningText.setText(text);
		insertText.setVisible(false);
		welcomeText.setVisible(false);
		warningText.setVisible(true);
	}
	
	@Override
	public void addComponents() {
		add(welcomeText);
		add(insertText);
		add(warningText);
	}

	@Override
	public void setComponentsProperties() {		
		setWelcomeTextProperties();
		setInsertTextProperties();
		setWarningTextProperties();
	}
}
