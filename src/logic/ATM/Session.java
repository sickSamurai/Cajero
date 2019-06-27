package logic.ATM;

import logic.database.account.AccountPostgresqlDAO;
import logic.database.account.IAccountDAO;
import logic.database.card.CardPostgresqlDAO;
import logic.database.card.ICardDAO;

public class Session {
	
	private String actualCardNumber;	
	private IAccountDAO accountDAO;
	private ICardDAO cardDAO;
	private int optionSelected;
	private int failedAttemps;
	
	public Session(String cardNumber) {
		this.actualCardNumber = cardNumber;
		accountDAO = new AccountPostgresqlDAO();
		cardDAO = new CardPostgresqlDAO();
	}
	
	public String getActualCardNumber() {
		return actualCardNumber;
	}
	
	public int getOptionSelected() {
		return optionSelected;
	}
	
	public int getFailedAttemps() {
		return failedAttemps;
	}
	
	public void setOption(int option) {
		optionSelected = option;
	}

	public boolean cardExists(String cardNumber) {
		return cardDAO.cardExists(cardNumber);
	}

	public boolean isCardActive() {
		return cardDAO.isCardActive(actualCardNumber);
	}

	public boolean passwordCorrect(String password) {
		return cardDAO.passwordCorrect(actualCardNumber, password);
	}

	public boolean isTransferPosible(String destinyAccountNumber) {
		String originAccountNumber = cardDAO.accountNumberAssociated(actualCardNumber);
		long originBalance = accountDAO.selectBalance(originAccountNumber);
		long destinyBalance = accountDAO.selectBalance(destinyAccountNumber);
		return originBalance >= destinyBalance;
	}
	
	public boolean transferAccountExists(String destinyAccountNumber) {
		return accountDAO.selectByAccountNumber(destinyAccountNumber).getAccountNumber() != null;
	}
	
	public void transfer(long amount, String destinyAccountNumber) {
		String originAccountNumber = cardDAO.accountNumberAssociated(actualCardNumber);		
		long updatedActualBalance = accountDAO.selectBalance(originAccountNumber) - amount;
		long destinyBalance = accountDAO.selectBalance(destinyAccountNumber) + amount;
		accountDAO.updateBalance(originAccountNumber, updatedActualBalance);
		accountDAO.updateBalance(destinyAccountNumber, destinyBalance);
	}

	public void withdraw(long amount) {
		String actualAccountNumber = cardDAO.accountNumberAssociated(actualCardNumber);
		long newBalance = accountDAO.selectBalance(actualAccountNumber) - amount;
		accountDAO.updateBalance(actualAccountNumber, newBalance);
	}
	
}