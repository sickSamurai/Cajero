package logic.database.account;

public interface IAccountDAO {

	public void updateBalance(long saldoCuenta);

	public AccountDTO getAccount(String numeroCuenta);
	
	public boolean getState(String numeroCuenta);	
}
