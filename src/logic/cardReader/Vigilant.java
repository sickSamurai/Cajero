package logic.cardReader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Vigilant extends Thread {

	private CardReader cardReader;	
	
	public void setCardReader(CardReader cardReader) {
		this.cardReader = cardReader;
	}
	
	@Override
	public void run() {
		while (!cardReader.isCardIn()) {
			if (cardReader.fileExists()) {
				cardReader.insertCard();
				Logger.getLogger(Vigilant.class.getName()).log(Level.INFO, "La tarjeta ha sido insertada");
				interrupt();
			} else {
				Logger.getLogger(Vigilant.class.getName()).log(Level.INFO, "No hay tarjeta insertada");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ex) {
					Logger.getLogger(Vigilant.class.getName()).log(Level.SEVERE, null, ex);
					interrupt();
				}
			}
		}
	}
}
