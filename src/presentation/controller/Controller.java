package presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import logic.ATM.Session;
import logic.ATM.CardReader;
import presentation.constant.LimitValues;
import presentation.template.TemplateFrame;
import presentation.view.*;

public class Controller implements ActionListener, Observer {

	private EntryFrame entryFrame;
	private OperationFrame operationFrame;
	private TransferFrame transferFrame;
	private WithdrawFrame withdrawFrame;
	private PasswordFrame passwordFrame;
	private Session session;

	public void setEntryFrame(EntryFrame entryFrame) {
		this.entryFrame = entryFrame;
	}

	public void setOperationFrame(OperationFrame operationFrame) {
		this.operationFrame = operationFrame;
	}

	public void setTransferFrame(TransferFrame transferFrame) {
		this.transferFrame = transferFrame;
	}

	public void setWithdrawFrame(WithdrawFrame withdrawFrame) {
		this.withdrawFrame = withdrawFrame;
	}

	public void setPasswordFrame(PasswordFrame passwordFrame) {
		this.passwordFrame = passwordFrame;
	}

	public void changeFrame(TemplateFrame actualFrame, TemplateFrame nextFrame) {
		actualFrame.dispose();
		nextFrame.init();
	}

	public void init() {
		operationFrame.addController(this);
		transferFrame.addController(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		String readedNumber = ((CardReader) o).readNumber();
		session = new Session(readedNumber);
		if (!session.cardExists(readedNumber)) {
			entryFrame.showWarningMessage("La tarjeta no esta registrada");
		} else if (!session.isCardActive()) {
			entryFrame.showWarningMessage("La tarjeta esta desactivada");
		} else {
			changeFrame(entryFrame, operationFrame);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == operationFrame.getTransferButton()) {
			session.setOption(1);
			changeFrame(operationFrame, transferFrame);
		}
		if (e.getSource() == operationFrame.getWithdrawButton()) {
			session.setOption(2);
			changeFrame(operationFrame, withdrawFrame);
		}
		if (e.getSource() == transferFrame.getBtnContinue()) {
			if (transferFrame.campoVacio()) {
				JOptionPane.showMessageDialog(transferFrame, "Faltan campos por rellenar");
			} else if (transferFrame.montoInsuficiente()) {
				JOptionPane.showMessageDialog(transferFrame,
						"La Transferencia minima es de" + " " + LimitValues.MIN_TRANSFER_AMOUNT);
			} else if (!session.isTransferPosible(transferFrame.getTxtNumeroCuenta().getText())) {
				JOptionPane.showMessageDialog(transferFrame,
						"Saldo insuficiente" + " " + LimitValues.MIN_TRANSFER_AMOUNT);
			} else {
				changeFrame(transferFrame, passwordFrame);
			}
		}
		if (e.getSource() == passwordFrame.getPasswordButton()) {
			if (session.passwordCorrect(passwordFrame.getPasswordField().getText())) {
				if (session.getOptionSelected() == 1) {
					Long amount = Long.parseLong(transferFrame.getTxtMonto().getText());
					String destinyAccountNumber = transferFrame.getTxtNumeroCuenta().getText();
					session.transfer(amount, destinyAccountNumber);
				} else if (session.getOptionSelected() == 2) {
					// no implementado aun
				}
			} else {
				JOptionPane.showMessageDialog(passwordFrame, "contraseña incorrecta");
			}
		}
	}
}
