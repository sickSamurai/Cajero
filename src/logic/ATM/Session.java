package logic.ATM;

import logic.database.account.AccountPostgresqlDAO;
import logic.database.account.IAccountDAO;
import logic.database.card.CardPostgresqlDAO;
import logic.database.card.ICardDAO;

public class Session {

	private String actualCardNumber;
	private int operationSelected;
	private IAccountDAO accountDAO;
	private ICardDAO cardDAO;

	public Session() {
		accountDAO = new AccountPostgresqlDAO();
		cardDAO = new CardPostgresqlDAO();
	}

	public void setCardNumber(String cardNumber) {
		this.actualCardNumber = cardNumber;
	}

	public String getActualCardNumber() {
		return actualCardNumber;
	}

	public int getOperationSelected() {
		return operationSelected;
	}

	public void setOperation(int option) {
		operationSelected = option;
	}

	public boolean cardExists(String cardNumber) {
		return cardDAO.cardExists(cardNumber);
	}

	public boolean isCardActive() {
		return cardDAO.isCardActive(actualCardNumber);
	}

	public void desactiveCard() {
		cardDAO.desactivateCard(actualCardNumber);
	}

	public boolean isPasswordCorrect(String password) {
		return cardDAO.passwordCorrect(actualCardNumber, password);
	}

	public boolean isTransferPosible(long amount) {
		String originAccountNumber = cardDAO.accountNumberAssociated(actualCardNumber);
		long originBalance = accountDAO.selectBalance(originAccountNumber);		
		return originBalance >= amount;
	}
        public boolean isSameAccount(String destinyAccountNumber){
                String originAccountNumber = cardDAO.accountNumberAssociated(actualCardNumber);
                String destinyAccount = destinyAccountNumber;
                System.out.println(originAccountNumber);
                System.out.println(destinyAccount);
                return originAccountNumber.equals(destinyAccount);
                               
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