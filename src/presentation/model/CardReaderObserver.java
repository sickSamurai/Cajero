package presentation.model;

import java.util.Observable;
import java.util.Observer;

import logic.facade.LogicFacade;

public class CardReaderObserver implements Observer {

	private ViewUpdater updater;
	private LogicFacade facade;

	public CardReaderObserver() {
		updater = ViewUpdater.getInstance();
		facade = LogicFacade.getInstance();
	}

	@Override
	public void update(Observable o, Object arg) {
		String cardNumber = facade.getCardNumber();
		if (facade.cardExists(cardNumber)) {
			if (facade.accountState(cardNumber))
				updater.goToPasswordFrame();
			else
				updater.updateEntryFrame("Cuenta desactivada");
		} else
			updater.updateEntryFrame("Tarjeta no registrada");
	}

}
