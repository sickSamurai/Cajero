package launcher;

import presentation.model.Model;
import presentation.view.EntryFrame;

public class Launcher {

    public static void main(String[] args) {                
        Model m = new Model();
        m.showWelcomeFrame();
        m.startVigilant();       
    }

}
