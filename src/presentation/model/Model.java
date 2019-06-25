package presentation.model;

import java.util.Observable;
import java.util.Observer;

import database.account.AccountDAO;
import database.card.CardDAO;
import logic.ATM.ATM;
import logic.cardReader.CardReader;
import logic.cardReader.Vigilant;
import presentation.view.AmountFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.EntryFrame;

public class Model implements Observer {

	private EntryFrame entryFrame;
	private OperationFrame operationFrame;
	private PasswordFrame passwordFrame;
	private AmountFrame amountFrame;
	private ATM atm;
	private CardDAO cardDAO;
	private AccountDAO accountDAO;
	private CardReader cardReader;
	private Vigilant vigilant;

	public Model() {
		entryFrame = new EntryFrame();
		passwordFrame = new PasswordFrame();
		operationFrame = new OperationFrame();
		amountFrame = new AmountFrame();
		atm = new ATM();
		cardReader= new CardReader();
		vigilant = new Vigilant();	
		cardDAO = new CardDAO();
		accountDAO = new AccountDAO();
	}

	public void goToPasswordFrame() {
		entryFrame.dispose();
		passwordFrame.init();
	}

	public void showWelcomeFrame() {
		entryFrame.init();
	}

	public void startVigilant() {
		cardReader.addObserver(this);
		vigilant.setCardReader(cardReader);
		vigilant.start();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String cardNumber = cardReader.getCardNumber();
		if (cardDAO.cardExists(cardNumber)) {
			if (accountDAO.getState(cardNumber)) {
				goToPasswordFrame();
			} else {
				entryFrame.showWarningMessage("Cuenta desactivada");
			}
		} else {
			entryFrame.showWarningMessage("Tarjeta no registrada");
		}
	}
}