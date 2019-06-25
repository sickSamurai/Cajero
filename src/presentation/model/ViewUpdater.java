package presentation.model;

import logic.ATM.ATM;
import logic.database.account.AccountDAO;
import logic.database.card.CardDAO;
import presentation.view.AmountFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.EntryFrame;

public class ViewUpdater {
	private static ViewUpdater singleton;
	private EntryFrame entryFrame;
	private OperationFrame operationFrame;
	private PasswordFrame passwordFrame;
	private AmountFrame amountFrame;
	
	
	private ViewUpdater() {
		entryFrame = new EntryFrame();
		passwordFrame = new PasswordFrame();
		operationFrame = new OperationFrame();
		amountFrame = new AmountFrame();		
	}

	public static ViewUpdater getInstance() {
		if (singleton == null) {
			singleton = new ViewUpdater();
		}
		return singleton;
	}
	
	public void showEntryFrame() {
		entryFrame.init();
	}
	
	public void updateEntryFrame(String text) {
		entryFrame.showWarningMessage(text);
	}
	
	public void goToPasswordFrame() {
		entryFrame.dispose();
		passwordFrame.init();
	}	

}