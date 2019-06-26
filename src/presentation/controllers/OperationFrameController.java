package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.facade.LogicFacade;
import presentation.model.ViewManager;
import presentation.view.OperationFrame;

public class OperationFrameController implements ActionListener{

    private OperationFrame frame;
    private ViewManager updater;
    private LogicFacade facade;

    public void setOperationFrame(OperationFrame frame){
        this.frame = frame;
    }
    
    public OperationFrameController() {        
        updater = ViewManager.getInstance();
        facade = LogicFacade.getInstance();        
    }
           
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getWithdrawButton()){
            updater.goToWithdrawFrame();
        }else if(e.getSource() == frame.getTransferButton()){
            updater.goToTransferFrame();
        }
    }
    
}
