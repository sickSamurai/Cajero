package database.account;

public class AccountDAO implements IAccountDAO {

	public AccountDAO() {

	}

	@Override
	public void updateBalance(long balance) {
		//no implementado aun
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
