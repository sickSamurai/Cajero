package presentation.view;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

import presentation.constant.ColorConstant;
import presentation.template.TemplateButton;
import presentation.template.TemplateFrame;

public class OperationFrame extends TemplateFrame {

	private JLabel operationText;
	private Font labelsFont;
	private JButton withdrawButton;
	private JButton transferButton;

	public OperationFrame() {
		operationText = new JLabel();
		withdrawButton = new TemplateButton();
		transferButton = new TemplateButton();
		labelsFont = new Font("Comic Sans MS", Font.BOLD, 70);
	}

	public JButton getWithdrawButton() {
		return withdrawButton;
	}

	public JButton getTransferButton() {
		return transferButton;
	}

	private void setOperationTextProperties() {
		operationText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
		operationText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
		operationText.setForeground(ColorConstant.getBlack());
		operationText.setFont(labelsFont);
		operationText.setText("¿Qué desea hacer?");
		operationText.setHorizontalAlignment(JLabel.CENTER);
		operationText.setVerticalAlignment(JLabel.CENTER);
	}

	private void setWithdrawButtonProperties() {
		withdrawButton.setLocation((int) (getWidth() * 0.72), (int) (getHeight() * 0.50));
		withdrawButton.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
		withdrawButton.setText("Retirar dinero");

	}

	private void setTransferButtonProperties() {
		transferButton.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.50));
		transferButton.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
		transferButton.setText("Transferir dinero");
	}

	@Override
	public void setComponentsProperties() {
		setOperationTextProperties();
		setWithdrawButtonProperties();
		setTransferButtonProperties();
	}

	@Override
	public void addComponents() {
		add(operationText);
		add(withdrawButton);
		add(transferButton);
	}

	public void addController(ActionListener listener) {
		withdrawButton.addActionListener(listener);
		transferButton.addActionListener(listener);
	}

}
