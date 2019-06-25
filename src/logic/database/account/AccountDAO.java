package logic.database.account;

public class AccountDAO implements IAccountDAO {
	
	private static AccountDAO singleton;

	private AccountDAO() {
		//constructor vacio
	}

	public static AccountDAO getInstance() {
		if (singleton == null) {
			singleton = new AccountDAO();
		}
		return singleton;
	}

	@Override
	public void updateBalance(long balance) {
		// no implementado aun
	}

	@Override
	public AccountDTO getAccount(String accountNumber) {
		return null;
	}

	@Override
	public boolean getState(String accountNumber) {
		return true;
	}

}
