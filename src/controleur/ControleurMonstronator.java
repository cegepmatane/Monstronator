package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.Exporteur;
import modele.MonstreModele;
import vue.VueModeleImageFond;
//import modele.MonstreModele.LEGUME;
import vue.VueMonstronator;

public class ControleurMonstronator extends Controleur{
	private VueMonstronator  vue;
	private VueModeleImageFond modeleImageFond;
	private MonstreModele monstreModele; 
	private String derniereImageSelectionnee;
	private String couleurSelectionnee;

	public ControleurMonstronator() {
		Logger.logMsg(Logger.INFO, "new ControleurMonstronator()");
		
	}
	
	public void initialiser() {
		 vue = VueMonstronator.getInstance();
		 modeleImageFond = VueModeleImageFond.getInstance();
		 monstreModele = MonstreModele.getInstance();
	}

	public void notifierClic(double x, double y) {
		vue.afficherSelection(x, y);
	}
	public void notifierClicCouleur(String couleur) {
		System.out.println("notifierClicCouleur("+ couleur+")");
		couleurSelectionnee = couleur;
	}
	
	public void notifierBackground() {
		monstreModele.saveBackGround(vue.changerBackGround(modeleImageFond.getProchainFond()));
	}

	public void notifierClicModifier(String identifiant) {
		System.out.println("notifierClicModifier("+identifiant+");");
		derniereImageSelectionnee = identifiant;
		double grosseur = vue.getGrosseurImage(identifiant);
		System.out.println("Height :" + grosseur);
		vue.afficherValeurGrosseur(grosseur);
		
	}

	public void notifierClicAppliquer()	{
		if (derniereImageSelectionnee == null) return;
		vue.appliquerGrosseur(derniereImageSelectionnee);
		vue.appliquerCouleur(derniereImageSelectionnee,couleurSelectionnee);
		
	}
	
	public void notifierChangementDonnee(String imagePlacee, double x, double y, double taille, String couleur, String idObject) {
		monstreModele.miseAJouerDonnee(imagePlacee, x, y, taille, couleur, idObject);
	}
	public void notifierChangementCouleur(String couleur, String idObject) {
		monstreModele.miseAJouerDonnee(couleur, idObject);
	}
	public void notifierChangementTaille(double taille, String idObject) {
		monstreModele.miseAJouerDonnee(taille, idObject);
	}
	
	public void notifierSauvegarde() {
		monstreModele.sauvegarde();
	}

}
