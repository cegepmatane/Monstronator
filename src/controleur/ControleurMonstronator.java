package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	
	//protected LEGUME legumeChoisis;

	public ControleurMonstronator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMonstronator()");
	}
	
	public void initialiser()
	{
		 vue = VueMonstronator.getInstance();
	}

	public void notifierSelection() {
		System.out.println("notifier selection");
		
	}
	public void notifierCarte() {
		System.out.println("notifier carte");
		
	}

	public void notifierClick(double x, double y) {
		vue.afficherSelection(x, y);
	}
	

}
