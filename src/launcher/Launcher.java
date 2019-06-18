package launcher;

import presentacion.GeneralController;
import presentacion.WelcomeFrame;

public class Launcher {

    public static void main(String[] args) {
        WelcomeFrame w = new WelcomeFrame();
        GeneralController controller = new GeneralController();
        controller.setWelcomeFrame(w);
        w.setProperties();
        w.setComponentsProperties();
        w.addComponents();
        w.addListener(controller);
    }

}
