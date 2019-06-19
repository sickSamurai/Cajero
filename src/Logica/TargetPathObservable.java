package Logica;

import java.util.Observable;

public class TargetPathObservable extends Observable {

    private String ruta;

    public void setRuta(String ruta) {
        this.ruta = ruta;
        synchronized (this) {
            this.setChanged();
            this.notifyObservers();
        }

    }

    public String getRuta() {
        return ruta;
    }
}
