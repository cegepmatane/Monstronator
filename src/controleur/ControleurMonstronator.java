package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import vue.VueModeleImageFond;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	private VueModeleImageFond modeleImageFond;
	private String derniereImageSelectionnee;

	public ControleurMonstronator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMonstronator()");
		
	}
	
	public void initialiser()
	{
		 vue = VueMonstronator.getInstance();
		 modeleImageFond = VueModeleImageFond.getInstance();
	}

	public void notifierClic(double x, double y) {
		vue.afficherSelection(x, y);
	}
	
	public void notifierBackground()
	{
		vue.changerBackGround(modeleImageFond.getProchainFond());
	}

	public void notifierClicModifier(String identifiant)
	{
		System.out.println("notifierClicModifier("+identifiant+");");

		derniereImageSelectionnee = identifiant;

		double grosseur = vue.getGrosseurImage(identifiant);
		System.out.println("Height :" + grosseur);
		vue.afficherValeurGrosseur(grosseur);


		vue.getCouleurSelectionee();
		vue.changerCouleur();
	}

	public void notifierClicAppliquerGrosseur()
	{
		if (derniereImageSelectionnee == null) return;
		vue.appliquerGrosseur(derniereImageSelectionnee);
	}
}
