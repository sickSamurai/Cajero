package logic.database.account;

public interface IAccountDAO {	

	public AccountDTO selectByAccountNumber(String accountNumber);

	public long selectBalance(String accountNumber);	

	public void updateBalance(String accountNumber, long balance);
	
}
