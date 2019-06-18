package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StandardFrame extends JFrame {

    protected JButton closeButton;
    protected JButton minimazeButton;

    private void setCloseButtonProperties() {
        closeButton.setLocation((int) (getWidth() * 0.95), 0);

    }
}
