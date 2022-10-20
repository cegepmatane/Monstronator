package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.BackGroundModele;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	private BackGroundModele BGModele;
	
	//protected LEGUME legumeChoisis;

	public ControleurMonstronator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMonstronator()");
	}
	
	public void initialiser()
	{
		 vue = VueMonstronator.getInstance();
		 BGModele = BackGroundModele.getInstance();
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
		vue.changerBackGround(BGModele.getNextBackground());
	}
	

}
