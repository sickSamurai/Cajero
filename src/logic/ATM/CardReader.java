package logic.ATM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardReader extends Observable implements Runnable {
	
	private final File file;
	private final Thread vigilantThread;

	public CardReader() {
		file = new File("C:\\tarjeta\\numeroTarjeta.txt");
		vigilantThread = new Thread(this);
	}	

	public String readNumber() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			return bufferedReader.readLine();
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
			return null;
		}
	}

	@Override
	public void run() {
		while (!file.exists()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
				Thread.currentThread().interrupt();
			}
		}
        setChanged();
        notifyObservers();
	}

	public void start() {
		vigilantThread.start();
	}

}
