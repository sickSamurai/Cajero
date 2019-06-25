
package logica;

import java.io.File;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vigilant extends Thread {

	private CardReader reader;
	private final File file;

	public Vigilant() {
		reader = new CardReader();
		file = new File("D:\\tarjeta\\numeroTarjeta.txt");
	}
	
	public void addObserver(Observer o) {
		reader.addObserver(o);
	}
	
	@Override
	public void run() {
		while (reader.isCardIn() == false) {
			if (file.exists()) {
				reader.insertCard();
				Logger.getLogger(Vigilant.class.getName()).log(Level.INFO, "La tarjeta ha sido insertada");
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
