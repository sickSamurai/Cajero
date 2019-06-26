package presentation.model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import logic.facade.LogicFacade;
import presentation.view.WithdrawFrame;
import presentation.view.OperationFrame;
import presentation.view.PasswordFrame;
import presentation.view.EntryFrame;
import presentation.view.TransferFrame;

public class ViewManager implements Observer {

    private static ViewManager singleton;
    private final LogicFacade facade;
    private EntryFrame entryFrame;
    private OperationFrame operationFrame;
    private PasswordFrame passwordFrame;
    private WithdrawFrame withdrawFrame;
    private TransferFrame transferFrame;

    private ViewManager() {
        facade = LogicFacade.getInstance();
    }

    public static ViewManager getInstance() {
        if (singleton == null) {
            singleton = new ViewManager();
        }
        return singleton;
    }

    public void setEntryFrame(EntryFrame entryFrame) {
        this.entryFrame = entryFrame;
    }

    public void setOperationFrame(OperationFrame operationFrame) {
        this.operationFrame = operationFrame;
    }

    public void setPasswordFrame(PasswordFrame passwordFrame) {
        this.passwordFrame = passwordFrame;
    }

    public void setWithdrawFrame(WithdrawFrame withdrawFrame) {
        this.withdrawFrame = withdrawFrame;
    }
    
    public void setTransferFrame(TransferFrame transferFrame) {
        this.transferFrame = transferFrame;
    }

    public void showEntryFrame() {
        entryFrame.init();
    }

    public void showEntryFrameWarningMessage(String text) {
        entryFrame.showWarningMessage(text);
    }

    public void goToOperationFrame() {
        entryFrame.dispose();
        operationFrame.init();
    }
    
    public void goToWithdrawFrame() {
        operationFrame.dispose();
        withdrawFrame.init();
    }
    
    public void goToTransferFrame() {
        operationFrame.dispose();
        transferFrame.init();
    }
    
    public void goToPasswordFrame(){
        transferFrame.dispose();
        passwordFrame.init();
    }

    @Override
    public void update(Observable o, Object arg) {
        String cardNumber = facade.getCardNumber();
        if (!facade.cardExists(cardNumber)) {
            showEntryFrameWarningMessage("NO HAY TARJETA");
        } else if (!facade.accountState(cardNumber)) {
            showEntryFrameWarningMessage("LLAME A SU ENTIDAD");
        } else {
            goToOperationFrame();            
        }
    }
    
}
