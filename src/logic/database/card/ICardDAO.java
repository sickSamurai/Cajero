package logic.database.card;

import java.sql.SQLException;

public interface ICardDAO {
	public CardDTO selectCard(String cardNumber) throws SQLException;
	public boolean cardExists(String cardNumber);
}