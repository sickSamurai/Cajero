
package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vigilant extends Thread{
    
    public CardReader reader;
    public final File file;
    
    public Vigilant(){
        this.reader = new CardReader();
        this.file = new File("G:\\tarjeta\\numeroTarjeta.txt");
    }
    
    public void run(){
        
        while(reader.isCardIn() == false){
               
            if(file.exists()){
                this.reader.insertedCard();
                System.out.println("La tarjeta ha sido insertada");
            }else {
                System.out.println("No hay tarjeta insertada");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Vigilant.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    
        }
    }
}
