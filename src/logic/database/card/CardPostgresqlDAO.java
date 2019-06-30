package logic.database.card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.database.connector.Conector;

public class CardPostgresqlDAO implements ICardDAO {

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
				card.setCardNumber(result.getString("numero_tarjeta"));
				card.setAccountNumber(result.getString("numero_cuenta"));
				card.setPassword(result.getString("clave"));
				card.setActive(result.getBoolean("esta_activa"));
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
		return selectCard(cardNumber).getCardNumber() != null;
	}
	
	@Override
	public String accountNumberAssociated(String cardNumber) {
		return selectCard(cardNumber).getAccountNumber(); 
	}
	
	@Override
	public boolean isCardActive(String cardNumber) {
		return selectCard(cardNumber).isActive();
	}
	
	@Override
	public boolean passwordCorrect(String cardNumber, String password) {
		return password.equals(selectCard(cardNumber).getPassword());
	}

	@Override
	public void desactivateCard(String cardNumber) {
		try {
			Conector.tryConnect();
			Connection connection = Conector.getConnection();
			String sentence = "UPDATE tarjeta SET esta_activa=? WHERE numero_tarjeta=?";
			PreparedStatement statement = connection.prepareStatement(sentence);
			statement.setBoolean(1, false);
			statement.setString(2, cardNumber);
			String rowsAfected = Integer.toString(statement.executeUpdate());
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, rowsAfected);
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
		} finally {
			Conector.tryClose();
		}
	}
}
