package presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import presentation.model.Model;
import presentation.template.TemplateFrame;
import presentation.view.*;

public class Controller implements ActionListener, Observer {

	private static Model model = Model.getInstance();
	private EntryFrame entryFrame;
	private OperationFrame operationFrame;
	private TransferFrame transferFrame;
	private WithdrawFrame withdrawFrame;
	private PasswordFrame passwordFrame;

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
		String cardNumber = model.getCardNumber();
		if (!model.cardExists(cardNumber)) {
			entryFrame.showWarningMessage("No hay tarjeta");
		} else if (!model.accountState(cardNumber)) {
			entryFrame.showWarningMessage("llame a su entidad");
		} else {
			model.setActualCardNumber(cardNumber);
			model.setActualAccountNumber(cardNumber);			
			changeFrame(entryFrame, operationFrame);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == operationFrame.getTransferButton())
			changeFrame(operationFrame, transferFrame);		
		if (e.getSource() == operationFrame.getWithdrawButton())
			changeFrame(operationFrame, withdrawFrame);
		if (e.getSource() == transferFrame.getBtnContinue()) {
			if (transferFrame.getTxtNumeroCuenta().getText().equals("")
					|| transferFrame.getTxtMonto().getText().equals("")) {
				JOptionPane.showMessageDialog(transferFrame, "Faltan campos por rellenar");
			} else if (Integer.parseInt(transferFrame.getTxtMonto().getText()) < 50000) {
				JOptionPane.showMessageDialog(transferFrame, "La Transferencia minima es de $50.000");
			} else {
				long monto = Long.parseLong(transferFrame.getTxtMonto().getText());
				String numeroCuentaDestino = (transferFrame.getTxtNumeroCuenta().getText());
				
				changeFrame(transferFrame, passwordFrame);
			}
		}

	}

}
