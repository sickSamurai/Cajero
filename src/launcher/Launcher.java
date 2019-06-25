package launcher;

import logic.cardReader.CardReader;
import presentation.controllers.OperationFrameController;
import presentation.controllers.WithdrawFrameController;
import presentation.model.ViewManager;
import presentation.view.EntryFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.WithdrawFrame;

public class Launcher {

    public static void main(String[] args) {
        ViewManager manager = ViewManager.getInstance();
        EntryFrame entryFrame = new EntryFrame();
        OperationFrame operationFrame = new OperationFrame();
        OperationFrameController controller = new OperationFrameController();
        WithdrawFrame withDraw = new WithdrawFrame();
        PasswordFrame passwordFrame = new PasswordFrame();
        CardReader cardReader = CardReader.getInstance();        
        manager.setEntryFrame(entryFrame);
        operationFrame.addActionListener(controller);
        manager.setOperationFrame(operationFrame);
        controller.setOperationFrame(operationFrame);        
        manager.setWithdrawFrame(withDraw);
        manager.setPasswordFrame(passwordFrame);         
        manager.showEntryFrame();
        cardReader.addObserver(manager);
        cardReader.start();
    }

}
