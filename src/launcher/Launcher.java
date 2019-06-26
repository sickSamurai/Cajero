package launcher;

import logic.cardReader.CardReader;
import presentation.controllers.OperationFrameController;
import presentation.controllers.TransferFrameController;
import presentation.controllers.WithdrawFrameController;
import presentation.model.ViewManager;
import presentation.view.EntryFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.TransferFrame;
import presentation.view.WithdrawFrame;

public class Launcher {

    public static void main(String[] args) {
        ViewManager manager = ViewManager.getInstance();
        EntryFrame entryFrame = new EntryFrame();
        OperationFrame operationFrame = new OperationFrame();
        OperationFrameController operationController = new OperationFrameController();
        TransferFrameController transferController = new TransferFrameController();
        WithdrawFrame withDraw = new WithdrawFrame();
        PasswordFrame passwordFrame = new PasswordFrame();
        TransferFrame transferFrame = new TransferFrame();
        CardReader cardReader = CardReader.getInstance();        
        manager.setEntryFrame(entryFrame);
        operationFrame.addActionListener(operationController);
        transferFrame.addActionListener(transferController);
        manager.setOperationFrame(operationFrame);
        operationController.setOperationFrame(operationFrame);
        transferController.setTransferFrame(transferFrame);
        manager.setWithdrawFrame(withDraw);
        manager.setPasswordFrame(passwordFrame);   
        manager.setTransferFrame(transferFrame);
        manager.showEntryFrame();
        cardReader.addObserver(manager);
        cardReader.start();
    }

}
