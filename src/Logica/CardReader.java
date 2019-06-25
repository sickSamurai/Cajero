package logica;

import java.util.Observable;

public class CardReader extends Observable {

	private boolean isCardIn;
	
	public CardReader() {
		isCardIn = false;
	}
	
	public boolean isCardIn() {
		return isCardIn;
	}

	public void insertCard() {
		isCardIn = true;
		setChanged();
		notifyObservers();
	}	

}
