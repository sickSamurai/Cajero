package launcher;

import presentacion.Model;
import presentacion.WelcomeFrame;

public class Launcher {

    public static void main(String[] args) {                
        Model m = new Model();
        m.showWelcomeFrame();
        m.startVigilant();       
    }

}
