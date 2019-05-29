package launcher;

import presentacion.WelcomeFrame;

public class Launcher {

    public static void main(String[] args) {
        WelcomeFrame w = new WelcomeFrame();
        w.setProperties();
        w.setWelcomeTextProperties();
        w.addComponents();
        w.setVisible(true);
    }

}
