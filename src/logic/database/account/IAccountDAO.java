package logic.database.account;

public interface IAccountDAO {

	public AccountDTO selectByCardNumber(String cardNumber);

	public AccountDTO selectByAccountNumber(String accountNumber);

	public long getBalance(String numeroCuenta);

	public void updateBalance(String numeroCuenta, long saldoCuenta);

	public void desactivateAccount(String accountNumber);

	public boolean isActive(String cardNumber);
	
}
