package launcher;

import logic.cardReader.CardReader;
import presentation.model.CardReaderObserver;
import presentation.model.ViewUpdater;

public class Launcher {

    public static void main(String[] args) {                
        ViewUpdater.getInstance().showEntryFrame();
        CardReaderObserver updater = new CardReaderObserver();
        CardReader reader = CardReader.getInstance();
        reader.addObserver(updater);
        reader.start();
    }

}
