package logic.database.card;

import java.sql.SQLException;

public interface ICardDAO {
	public CardDTO selectCard(String cardNumber);
	public boolean cardExists(String cardNumber);
	public boolean passwordCorrect(String accountNumber, String password);
}