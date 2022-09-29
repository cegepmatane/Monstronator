package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.jardinModele.LEGUME;
import vue.VueJardinator;

public class ControleurJardinator extends Controleur{
	private VueJardinator vue;
	protected LEGUME legumeChoisis;

	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
	}
	
	public void initialiser()
	{
		 vue = VueJardinator.getInstance();
	}

	public void notifierLegume() {
		System.out.println("notifier legume");
		
	}
	public void notifierJardin() {
		System.out.println("notifier jardin");
		
	}

	public void notifierClick(double x, double y) {
		vue.afficherLegume(x, y);
	}
	

}
