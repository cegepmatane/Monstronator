package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import vue.VueModeleImageFond;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	private VueModeleImageFond modeleImageFond;

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
}
