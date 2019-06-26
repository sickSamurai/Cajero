package logic.cardReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardReader extends Observable implements Runnable {

    private static CardReader singleton;
    private boolean cardIn;
    private final File file;
    private final Thread vigilantThread;

    private CardReader() {
        cardIn = false;
        file = new File("G:\\tarjeta\\numeroTarjeta.txt");
        vigilantThread = new Thread(this);
    }

    public static CardReader getInstance() {
        if (singleton == null) {
            singleton = new CardReader();
        }
        return singleton;
    }

    public String getCardNumber() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void insertCard() {
        cardIn = true;
        setChanged();
    }

    @Override
    public void run() {
        while (!cardIn) {
            try {
                if (file.exists()) {
                    insertCard();
                    notifyObservers();
                } else {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }

        }
    }

    public void start() {
        vigilantThread.start();
    }

}
