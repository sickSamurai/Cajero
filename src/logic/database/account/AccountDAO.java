package logic.database.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import logic.database.connector.Conector;

public class AccountDAO implements IAccountDAO {

	private static AccountDAO singleton;

	private AccountDAO() {
		// constructor vacio
	}

	public static AccountDAO getInstance() {
		if (singleton == null) {
			singleton = new AccountDAO();
		}
		return singleton;
	}

	@Override
	public void updateBalance(long balance) {
		// no implementado aun
	}

	@Override
	public AccountDTO selectAccount(String cardNumber) {
		AccountDTO account = new AccountDTO();
		try {
			Conector.tryConnect();
			Connection connection = Conector.getConnection();
			String sentence = "SELECT* FROM cuenta WHERE numero_tarjeta = ?";
			PreparedStatement statement = connection.prepareStatement(sentence);
			statement.setString(1, cardNumber);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				account.setAccountNumber(result.getString("numero_cuenta"));
				account.setCardNumber(result.getString("numero_tarjeta"));
				account.setBalanceAviable(result.getLong("saldo"));
				account.setActive(result.getBoolean("esta_activa"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
		} finally {
			Conector.tryClose();
		}
		return account;
	}

	@Override
	public boolean isActive(String cardNumber) {
		return selectAccount(cardNumber).isActive();
	}

}
