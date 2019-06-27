package logic.database.card;

import java.sql.SQLException;

public interface ICardDAO {
	public CardDTO selectCard(String cardNumber);
	public boolean cardExists(String cardNumber);
	public boolean isCardActive(String cardNumber);
	public boolean passwordCorrect(String accountNumber, String password);
	public String accountNumberAssociated(String cardNumber);
	public void desactivateCard(String cardNumber);
}