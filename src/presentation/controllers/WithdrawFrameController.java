package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.facade.LogicFacade;
import presentation.model.ViewManager;
import presentation.view.WithdrawFrame;

public class WithdrawFrameController implements ActionListener {

    LogicFacade facade;
    ViewManager updater;
    WithdrawFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getButton10k()) {
            
        } else if (e.getSource() == frame.getButton30k()) {

        } else if (e.getSource() == frame.getButton60k()) {

        } else if (e.getSource() == frame.getButton80k()) {

        } else if (e.getSource() == frame.getButton100k()) {

        } else if (e.getSource() == frame.getButton200k()) {
            
        } else if (e.getSource() == frame.getButton300k()) {

        }
    }

}
