package logic.ATM;

import logic.database.account.AccountDAO;
import logic.database.account.AccountDTO;
import logic.database.card.CardDAO;
import logic.database.card.CardDTO;

public class ATM {

	private static ATM singleton;
	private AccountDAO accountDAO;
	private CardDAO cardDAO;
	private String actualCardNumber;
	private String actualAccountNumber;

	private ATM() {
		accountDAO = AccountDAO.getInstance();
		cardDAO = CardDAO.getInstance();
	}

	public static ATM getInstance() {
		if (singleton == null)
			singleton = new ATM();
		return singleton;
	}

	public String getActualCardNumber() {
		return actualCardNumber;
	}

	public void setActualCardNumber(String actualCardNumber) {
		this.actualCardNumber = actualCardNumber;
	}

	public String getActualAccountNumber() {
		return actualAccountNumber;
	}

	public void setActualAccountNumber(String actualAccountNumber) {
		this.actualAccountNumber = actualAccountNumber;
	}

	public void desactivateAccount() {
		accountDAO.desactivateAccount(actualAccountNumber);
	}

	public void realizarTransaccion(long monto, String destinyAccountNumber) {
		long originBalance = accountDAO.getBalance(actualAccountNumber) - monto;
		long destinyBalance = accountDAO.getBalance(destinyAccountNumber) + monto;
		accountDAO.updateBalance(actualAccountNumber, originBalance);
		accountDAO.updateBalance(destinyAccountNumber, destinyBalance);
	}

	public void retirarDinero(long monto) {
		long newBalance = accountDAO.getBalance(actualAccountNumber) - monto;
		accountDAO.updateBalance(actualAccountNumber, newBalance);
	}

	public boolean validarClave(String password) {
		return cardDAO.passwordCorrect(actualCardNumber, password);
	}

}