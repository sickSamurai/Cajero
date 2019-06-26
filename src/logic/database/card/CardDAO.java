package logic.database.card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.database.connector.Conector;

public class CardDAO implements ICardDAO {

	private static CardDAO singleton;

	private CardDAO() {
	}

	public static CardDAO getInstance() {
		if (singleton == null) {
			singleton = new CardDAO();
		}
		return singleton;
	}

	@Override
	public CardDTO selectCard(String cardNumber) {
		CardDTO card = new CardDTO();
		try {
			Conector.tryConnect();
			Connection connection = Conector.getConnection();
			String sentence = "SELECT* FROM tarjeta WHERE numero_tarjeta = ?";
			PreparedStatement statement = connection.prepareStatement(sentence);
			statement.setString(1, cardNumber);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				card.setNumeroTarjeta(result.getString("numero_tarjeta"));
				card.setClave(result.getString("clave"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
		} finally {
			Conector.tryClose();
		}
		return card;
	}

	@Override
	public boolean cardExists(String cardNumber) {
		return selectCard(cardNumber).getNumeroTarjeta() != null;
	}

}
