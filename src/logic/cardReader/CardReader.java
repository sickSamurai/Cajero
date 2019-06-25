package logic.cardReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardReader extends Observable {

	private boolean isCardIn;
	private final File file;

	public boolean fileExists() {
		return file.exists();
	}

	public CardReader() {
		file = new File("D:\\tarjeta\\numeroTarjeta.txt");
		isCardIn = false;
	}

	public boolean isCardIn() {
		return isCardIn;
	}

	public String getCardNumber() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			return bufferedReader.readLine();
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
			return null;
		}
	}

	public void insertCard() {
		isCardIn = true;
		setChanged();
		notifyObservers();
	}

}
