package launcher;

import logic.ATM.CardReader;
import logic.database.connector.Conector;
import presentation.controller.Controller;
import presentation.view.EntryFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.TransferFrame;
import presentation.view.WithdrawFrame;

public class Launcher {

	private static EntryFrame entryFrame = new EntryFrame();
	private static OperationFrame operationFrame = new OperationFrame();
	private static TransferFrame transferFrame = new TransferFrame();
	private static WithdrawFrame withdrawFrame = new WithdrawFrame();
	private static PasswordFrame passwordFrame = new PasswordFrame();
	private static Controller controller = new Controller();
	private static CardReader reader = new CardReader();	

	public static void initController() {
		controller.setEntryFrame(entryFrame);
		controller.setOperationFrame(operationFrame);
		controller.setTransferFrame(transferFrame);
		controller.setWithdrawFrame(withdrawFrame);
		controller.setPasswordFrame(passwordFrame);
		controller.init();
	}

	public static void startReader() {
		reader.addObserver(controller);
		reader.start();
	}
	
	public static void setConectorValues() {
		Conector.setValues("jdbc:postgresql://localhost/banco", "postgres", "1957");
	}

	public static void main(String[] args) {
		Launcher.setConectorValues();
		Launcher.initController();
		Launcher.startReader();		
		entryFrame.init();
	}

}
