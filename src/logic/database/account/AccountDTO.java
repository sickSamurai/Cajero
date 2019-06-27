package logic.database.account;

public class AccountDTO {

	private String accountNumber;
	private long balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public long getBalance() {
		return balance;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}	

	public void setBalance(long balanceAviable) {
		this.balance = balanceAviable;
	}
	

}