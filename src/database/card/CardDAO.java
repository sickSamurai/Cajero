package database.card;

public class CardDAO implements ICardDAO {
	@Override
	public CardDTO getCard(String cardNumber) {
		return null;
	}

	@Override
	public boolean cardExists(String cardNumber) {
		return true;
	}

}