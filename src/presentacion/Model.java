package presentacion;

import java.util.Observable;
import java.util.Observer;

import logica.Cajero;
import logica.Vigilant;

public class Model implements Observer {

	private Cajero cajero;	
	private WelcomeFrame welcomeFrame;
	private Vigilant vigilant;

	public Model() {
		cajero = new Cajero();
		vigilant = new Vigilant();
		welcomeFrame = new WelcomeFrame();		
	}
	
	public void goToOptionsFrame() {
		welcomeFrame.dispose();		
	}
	
	public void showWelcomeFrame() {
		welcomeFrame.init();		
	}
	
	public void startVigilant() {
		vigilant.addObserver(this);				
		vigilant.start();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		goToOptionsFrame();
	}
}