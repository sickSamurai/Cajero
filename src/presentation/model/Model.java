package presentation.model;

import logic.cardReader.CardReader;
import logic.database.account.AccountDAO;
import logic.database.card.CardDAO;

public class Model {

	private static Model singleton;
	private CardReader reader;
	private CardDAO cardDAO;
	private AccountDAO accountDAO;

	private Model() {
		reader = CardReader.getInstance();
		cardDAO = CardDAO.getInstance();
		accountDAO = AccountDAO.getInstance();
	}

	public static Model getInstance() {
		if (singleton == null) {
			singleton = new Model();
		}
		return singleton;
	}

	public String getCardNumber() {
		return reader.getCardNumber();
	}
	
	public boolean cardExists(String cardNumber) {
		return cardDAO.cardExists(cardNumber);
	}

	public boolean accountState(String cardNumber) {
		return accountDAO.isActive(cardNumber);
	}

}
