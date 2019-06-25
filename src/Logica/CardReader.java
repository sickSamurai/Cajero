
package Logica;

public class CardReader {
    
    public boolean cardIn;
    
    public CardReader(){
        this.cardIn = false;
    }

    public boolean isCardIn() {
        return cardIn;
    }

    public void insertedCard(){
        this.cardIn = true;
    }
    
}
