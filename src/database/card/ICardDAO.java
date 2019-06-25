package database.card;

public interface ICardDAO {
	public CardDTO getCard(String cardNumber);
	public boolean cardExists(String cardNumber);
}