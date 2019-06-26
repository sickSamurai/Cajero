package logic.ATM;

import logic.database.account.AccountDAO;
import logic.database.account.AccountDTO;
import logic.database.card.CardDAO;
import logic.database.card.CardDTO;

public class ATM {

	private AccountDAO accountDAO;
	private CardDAO cardDAO;
	private String actualCardNumber;
	private String actualAccountNumber;

	public ATM() {
		accountDAO = AccountDAO.getInstance();
		cardDAO = CardDAO.getInstance();
	}

	public void bloquearTarjeta(AccountDTO cuenta) {

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

	public boolean validarRetiro(AccountDTO cuentaDTO) {
		return false;
	}
}