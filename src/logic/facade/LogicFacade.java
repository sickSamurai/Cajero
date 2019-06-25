package logic.facade;

import logic.ATM.ATM;
import logic.cardReader.CardReader;
import logic.database.account.AccountDAO;
import logic.database.card.CardDAO;

public class LogicFacade {
	
	private static LogicFacade singleton;
	private ATM atm;	
	private CardDAO cardDAO;
	private AccountDAO accountDAO;
	private CardReader cardReader;
	
	private LogicFacade(){
		atm = new ATM();		
		cardDAO = CardDAO.getInstance();
		accountDAO = AccountDAO.getInstance();
		cardReader = CardReader.getInstance();
	}
	
	public static LogicFacade getInstance() {
		if (singleton == null) {
			singleton = new LogicFacade();
		}
		return singleton;
	}
	
	public boolean cardExists(String cardNumber) {
		return cardDAO.cardExists(cardNumber);
	}

	public boolean accountState(String number) {
		return accountDAO.getState(number);
	}
	
	public String getCardNumber() {
		return cardReader.getCardNumber();
	}
	
}
