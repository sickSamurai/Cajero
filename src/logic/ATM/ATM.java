package logic.ATM;

import logic.database.account.AccountDAO;
import logic.database.account.AccountDTO;
import logic.database.card.CardDAO;
import logic.database.card.CardDTO;

public class ATM {

	private AccountDAO accountDAO;
	private CardDAO cardDAO;

	public ATM() {
		accountDAO = AccountDAO.getInstance();
		cardDAO = CardDAO.getInstance();
	}

	public void bloquearTarjeta(AccountDTO cuenta) {

	}

	public void realizarTransaccion(long monto, String originAccountNumber, String destinyAccountNumber) {
		long originBalance = accountDAO.getBalance(originAccountNumber) - monto; 
		long destinyBalance = accountDAO.getBalance(destinyAccountNumber) + monto;
		accountDAO.updateBalance(originAccountNumber, originBalance);
		accountDAO.updateBalance(destinyAccountNumber, destinyBalance);
	}

	public void retirarDinero(String accountNumber, long monto) {
		long newBalance = accountDAO.getBalance(accountNumber) - monto;
		accountDAO.updateBalance(accountNumber, newBalance);
	}

	public boolean validarClave(String clave) {
		int intentos = 0;

	}

	public boolean validarRetiro(AccountDTO cuentaDTO) {
		return false;
	}
}