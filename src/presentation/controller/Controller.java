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
        private EndFrame endFrame;
	private Session session;
        private long selectedAmount;

            
	public Controller() {
		session = new Session();
	}
	
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
        public void setEndFrame(EndFrame endFrame) {
		this.endFrame = endFrame;
	}

	public void changeFrame(TemplateFrame actualFrame, TemplateFrame nextFrame) {
		actualFrame.dispose();
		nextFrame.init();
	}

	public void init() {
		operationFrame.addController(this);		
		transferFrame.addController(this);
		withdrawFrame.addController(this);
		passwordFrame.addController(this);
                
	}

	@Override
	public void update(Observable o, Object arg) {
		String readedNumber = ((CardReader) o).readNumber();
		session.setCardNumber(readedNumber);
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
			session.setOperation(1);
			changeFrame(operationFrame, transferFrame);
                        
		}
		if (e.getSource() == operationFrame.getWithdrawButton()) {
			session.setOperation(2);
			changeFrame(operationFrame, withdrawFrame);
                        
		}
		if (e.getSource() == withdrawFrame.getButton10k()) {
                        selectedAmount = 10000;			
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                        
		}
		if (e.getSource() == withdrawFrame.getButton30k()) {
			selectedAmount = 30000;
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                       
		}
		if (e.getSource() == withdrawFrame.getButton60k()) {
			selectedAmount = 60000;
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                        
		}
		if (e.getSource() == withdrawFrame.getButton80k()) {
			selectedAmount = 80000;
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                        
		}
		if (e.getSource() == withdrawFrame.getButton100k()) {
                        selectedAmount = 100000;
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                        
		}
		if (e.getSource() == withdrawFrame.getButton200k()) {
                        selectedAmount = 200000;
                    if (!session.isTransferPosible(selectedAmount)) {
                        JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }                        
		}
		if (e.getSource() == withdrawFrame.getButton300k()) {
                        selectedAmount = 300000;
                    if (!session.isTransferPosible(selectedAmount)) {
                            JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }                            
                }
		if (e.getSource() == withdrawFrame.getOtherButton()) {
                    selectedAmount = Long.parseLong(JOptionPane.showInputDialog(withdrawFrame , "Inserte el monto:"));
                    if (!session.isTransferPosible(selectedAmount)) {
				JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
                    }else{                        
                        changeFrame(withdrawFrame, passwordFrame);
                    }
                                    
		}
		if (e.getSource() == transferFrame.getBtnContinue()) {
			if (transferFrame.campoVacio()) {
				JOptionPane.showMessageDialog(transferFrame, "Faltan campos por rellenar");
			} else if (transferFrame.montoInsuficiente()) {
				JOptionPane.showMessageDialog(transferFrame,
						"La Transferencia minima es de" + " " + LimitValues.MIN_TRANSFER_AMOUNT);
			} else if (!session.isTransferPosible(Long.parseLong(transferFrame.getTxtMonto().getText()))) {
				JOptionPane.showMessageDialog(transferFrame, "Saldo insuficiente");
			} else if (!session.transferAccountExists(transferFrame.getTxtNumeroCuenta().getText())) {
				JOptionPane.showMessageDialog(transferFrame, "La cuenta de destino no existe");
			}else if(session.isSameAccount(transferFrame.getTxtNumeroCuenta().getText())){
                                JOptionPane.showMessageDialog(transferFrame, "No puede transferir dinero a esta cuenta"); 
                        }else {
                            selectedAmount= Long.parseLong(transferFrame.getTxtMonto().getText());
                            changeFrame(transferFrame, passwordFrame);
                        }
		}
		if (e.getSource() == passwordFrame.getPasswordButton()) {
                    int contador = 0;
                    if(passwordFrame.campoVacio()){
                        JOptionPane.showMessageDialog(passwordFrame, "inserte una contraseña");                        
                    }else if (contador == 2){
                        session.desactiveCard();
                        changeFrame(passwordFrame, endFrame); 
                        endFrame.showWarningMessage("Su tarjeta ha sido desactivada");                                               
                    }else if (!session.isPasswordCorrect(passwordFrame.getPasswordField().getText())){
                        JOptionPane.showMessageDialog(passwordFrame, "contraseña incorrecta");
                        contador++;                        
                    }else if (session.getOperationSelected()==2){                        
                        session.withdraw(selectedAmount);
                        changeFrame(passwordFrame, endFrame); 
                    }else if (session.getOperationSelected()==1){                        
                        session.transfer(selectedAmount , transferFrame.getTxtNumeroCuenta().getText());
                        changeFrame(passwordFrame, endFrame); 
                    }
                    
		}
	}
}
