package logic.database.card;

public class CardDAO implements ICardDAO {

    private static CardDAO singleton;

    private CardDAO() {
        // constructor vacio
    }

    public static CardDAO getInstance() {
        if (singleton == null) {
            singleton = new CardDAO();
        }
        return singleton;
    }

    @Override
    public CardDTO getCard(String cardNumber) {
        return null;
    }

    @Override
    public boolean cardExists(String cardNumber) {
        return true;
    }

}
