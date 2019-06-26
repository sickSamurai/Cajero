
package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import logic.facade.LogicFacade;
import presentation.model.ViewManager;
import presentation.view.TransferFrame;

public class TransferFrameController implements ActionListener {
    
    private TransferFrame frame;
    private ViewManager updater;
    private LogicFacade facade;
    
    public void setTransferFrame(TransferFrame frame){
        this.frame = frame;
    }
    
    public TransferFrameController() {        
        updater = ViewManager.getInstance();
        facade = LogicFacade.getInstance();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.getBtnContinue()){
            if(frame.getTxtNumeroCuenta().getText().equals("") || frame.getTxtMonto().getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Faltan Campos por rellenar");
            }else if (Integer.parseInt(frame.getTxtMonto().getText()) < 50000){
                JOptionPane.showMessageDialog(frame, "La Transferencia mínima es de $50.000");
            }else {
                updater.goToPasswordFrame();
            }
        }
    }
    
}
