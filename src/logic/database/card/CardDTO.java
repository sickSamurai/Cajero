package logic.database.card;

public class CardDTO {

	private String cardNumber;
	private String accountNumber;
	private String password;
	private boolean active;
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return active;
	}

	public void setCardNumber(String numeroTarjeta) {
		this.cardNumber = numeroTarjeta;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPassword(String clave) {
		this.password = clave;
	}

	public void setActive(boolean activa) {
		this.active = activa;
	}

}