package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import vue.VueModeleImageFond;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	private VueModeleImageFond BGModele;
	
	//protected LEGUME legumeChoisis;

	public ControleurMonstronator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMonstronator()");
		
	}
	
	public void initialiser()
	{
		 vue = VueMonstronator.getInstance();
		 BGModele = VueModeleImageFond.getInstance();
	}

	public void notifierCarte() {
		System.out.println("notifier carte");
		
	}

	public void notifierClic(double x, double y) {
		vue.afficherSelection(x, y);
	}

	public void notifierClicPartieMonstre() {
		// TODO Auto-generated method stub
	}
	
	public void notifierBackground() {
		vue.changerBackGround(BGModele.getProchainFond());
	}
	
	public void setDefaultBackGround() {
		vue.changerBackGround(BGModele.getFondSelectionne());
	}
	

}
