
package presentation.view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.constant.LimitValues;
import presentation.template.TemplateButton;
import presentation.template.TemplateFrame;

public class TransferFrame extends TemplateFrame {

	private Font font;
	private JLabel lblNumeroCuenta;
	private JLabel lblMonto;
	private JTextField txtNumeroCuenta;
	private JTextField txtMonto;
	private JButton btnContinue;

	public TransferFrame() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 25);
		this.lblNumeroCuenta = new JLabel();
		this.lblMonto = new JLabel();
		this.txtMonto = new JTextField();
		this.txtNumeroCuenta = new JTextField();
		this.btnContinue = new TemplateButton();
		this.validarTexto(txtMonto);
		this.validarTexto(txtNumeroCuenta);
	}

	public JButton getBtnContinue() {
		return btnContinue;
	}

	public JTextField getTxtNumeroCuenta() {
		return txtNumeroCuenta;
	}

	public JTextField getTxtMonto() {
		return txtMonto;
	}

	private void setLblNumeroCuentaProperties() {
		this.lblNumeroCuenta.setFont(font);
		this.lblNumeroCuenta.setText("Ingrese el numero de cuenta Destino:");
		this.lblNumeroCuenta.setSize((int) (this.getWidth() * 0.45), (int) (this.getHeight() * 0.05));
		this.lblNumeroCuenta.setLocation((int) (this.getWidth() * 0.33), (int) (this.getHeight() * 0.25));
	}

	private void setLblMontoProperties() {
		this.lblMonto.setFont(font);
		this.lblMonto.setText("Ingrese el Valor a Transferir:");
		this.lblMonto.setSize((int) (this.getWidth() * 0.45), (int) (this.getHeight() * 0.05));
		this.lblMonto.setLocation((int) (this.getWidth() * 0.37), (int) (this.getHeight() * 0.5));
	}

	private void setTxtNumeroCuentaProperties() {
		this.txtNumeroCuenta.setFont(font);
		this.txtNumeroCuenta.setSize((int) (this.getWidth() * 0.3), (int) (this.getHeight() * 0.05));
		this.txtNumeroCuenta.setLocation((int) (this.getWidth() * 0.35), (int) (this.getHeight() * 0.35));
	}

	private void setTxtMontoProperties() {
		this.txtMonto.setFont(font);
		this.txtMonto.setSize((int) (this.getWidth() * 0.3), (int) (this.getHeight() * 0.05));
		this.txtMonto.setLocation((int) (this.getWidth() * 0.35), (int) (this.getHeight() * 0.60));
	}

	private void setBtnContinueProperties() {
		this.btnContinue.setSize((int) (this.getWidth() * 0.20), (int) (this.getHeight() * 0.1));
		this.btnContinue.setLocation((int) (this.getWidth() * 0.40), (int) (this.getHeight() * 0.80));
		this.btnContinue.setText("Continuar");
	}

	private void validarTexto(JTextField txt) {
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});
	}

	public boolean campoVacio() {
		return getTxtNumeroCuenta().getText().equals("") || getTxtMonto().getText().equals("");
	}
	
	public boolean montoInsuficiente() {
		return Long.parseLong(getTxtMonto().getText()) < LimitValues.MIN_TRANSFER_AMOUNT;
	}	

	@Override
	public void setComponentsProperties() {
		this.setLblNumeroCuentaProperties();
		this.setLblMontoProperties();
		this.setTxtNumeroCuentaProperties();
		this.setTxtMontoProperties();
		this.setBtnContinueProperties();
	}

	@Override
	public void addComponents() {
		this.add(lblNumeroCuenta);
		this.add(lblMonto);
		this.add(txtNumeroCuenta);
		this.add(txtMonto);
		this.add(btnContinue);
	}

	public void addController(ActionListener listener) {
		btnContinue.addActionListener(listener);
	}

}
