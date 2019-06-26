package logic.database.account;

public interface IAccountDAO {

	public void updateBalance(long saldoCuenta);

	public AccountDTO selectAccount(String numeroCuenta);
	
	public boolean isActive(String numeroCuenta);	
}
