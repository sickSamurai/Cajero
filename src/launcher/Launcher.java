package launcher;

import Logica.TargetPathObservable;
import presentacion.WelcomeFrame;

public class Launcher {

    public static void main(String[] args) {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        TargetPathObservable ruta = new TargetPathObservable();                              
        welcomeFrame.setProperties();
        welcomeFrame.setComponentsProperties();
        welcomeFrame.addComponents();
        ruta.addObserver(welcomeFrame);        
    }

}
