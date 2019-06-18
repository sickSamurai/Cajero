package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralController implements ActionListener{
    private WelcomeFrame welcomeFrame;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == welcomeFrame.getReadCardButton()) {
            welcomeFrame.dispose();
        }
    }

    public void setWelcomeFrame(WelcomeFrame welcomeFrame) {
        this.welcomeFrame = welcomeFrame;
    }
     
}
