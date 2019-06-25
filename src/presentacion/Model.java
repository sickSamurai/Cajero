package presentacion;

import Logica.Cajero;
import Logica.CardReader;
import Logica.Vigilant;

public class Model {

	private WelcomeFrame principalView;
	public Cajero m_Cajero;
        public CardReader reader;
        public Vigilant vigilant;
        
	public Model(){
            this.principalView = new WelcomeFrame(this);
            this.reader = new CardReader();
            this.vigilant = new Vigilant();
            this.vigilant.start();
	}
}