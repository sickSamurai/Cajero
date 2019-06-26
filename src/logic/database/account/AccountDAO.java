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
	public AccountDTO selectByAccountNumber(String numeroCuenta) {
		AccountDTO account = new AccountDTO();
		Conector.tryConnect();
		try {
			Connection connection = Conector.getConnection();
			String sentence = "SELECT* FROM cuenta WHERE numero_cuenta = ?";
			PreparedStatement statement;
			statement = connection.prepareStatement(sentence);
			statement.setString(1, numeroCuenta);
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
	public AccountDTO selectByCardNumber(String cardNumber) {
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
	public long getBalance(String accountNumber) {
		return selectByAccountNumber(accountNumber).getBalance();
	}

	@Override
	public void updateBalance(String accountNumber, long newBalance) {
		try {
			Conector.tryConnect();
			Connection connection = Conector.getConnection();
			String sentence = "UPDATE cuenta SET saldo=? WHERE numero_cuenta=?";
			PreparedStatement statement = connection.prepareStatement(sentence);
			statement.setLong(1, newBalance);
			statement.setString(2, accountNumber);
			String rowsAfected = Integer.toString(statement.executeUpdate());
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, rowsAfected);
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
		} finally {
			Conector.tryClose();
		}
	}

	@Override
	public void desactivateAccount(String accountNumber) {
		try {
			Conector.tryConnect();
			Connection connection = Conector.getConnection();
			String sentence = "UPDATE cuenta SET esta_activa=? WHERE numero_cuenta=?";
			PreparedStatement statement = connection.prepareStatement(sentence);
			statement.setBoolean(1, false);
			statement.setString(2, accountNumber);
			String rowsAfected = Integer.toString(statement.executeUpdate());
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, rowsAfected);
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
		} finally {
			Conector.tryClose();
		}
	}

	@Override
	public boolean isActive(String cardNumber) {
		return selectByCardNumber(cardNumber).isActive();
	}

}
