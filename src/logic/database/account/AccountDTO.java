package logic.database.account;

public class AccountDTO {

	private String accountNumber;
	private String cardNumber;
	private long balanceAviable;
	private boolean active;	

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setBalanceAviable(long balanceAviable) {
		this.balanceAviable = balanceAviable;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public long getBalanceAviable() {
		return balanceAviable;
	}
	
	public boolean isActive() {
		return active;
	}

}