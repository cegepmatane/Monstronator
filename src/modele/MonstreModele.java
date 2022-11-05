package modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import donnee.Exporteur;
import vue.VueModeleImageFond;

public class MonstreModele {
	
	protected static MonstreModele instance = null; 
	public static MonstreModele getInstance() {
		if(null==instance)
			instance = new MonstreModele(); return MonstreModele.instance;
	}
	
	public class PartieMonstre {
		String imageURL;
		double x, y, taille;
		String couleur;
		
		PartieMonstre(String imageURL, double x, double y, double taille, String couleur){
			this.imageURL = imageURL;
			this.x=x;
			this.y=y;
			this.taille=taille;
			this.couleur=couleur;
		}
		public void UpdateObject(double taille, String couleur) {
			this.taille=taille;
			this.couleur=couleur;
		}
		public void UpdateObject(double taille) {
			this.taille=taille;
		}
		public void UpdateObject(String couleur) {
			this.couleur=couleur;
		}
	}
	
	private HashMap<String, PartieMonstre> partiesMonstre = new HashMap<String, PartieMonstre>();
	private String BackgroundURL;
	
	public void miseAJouerDonnee(String imagePlacee, double x, double y, double taille, String couleur, String idPartie) {
		PartieMonstre tempPartieMonstre = partiesMonstre.get(idPartie);
		if (tempPartieMonstre == null) {
			partiesMonstre.put(idPartie, new PartieMonstre(imagePlacee, x, y, taille, couleur));
		} else {
			(tempPartieMonstre).UpdateObject(taille, couleur);
		}
	}
	public void miseAJouerDonnee(double taille, String idPartie) {
		PartieMonstre tempPartieMonstre = partiesMonstre.get(idPartie);
		tempPartieMonstre.UpdateObject(taille);
	}
	public void miseAJouerDonnee(String couleur, String idPartie) {
		PartieMonstre tempPartieMonstre = partiesMonstre.get(idPartie);
		tempPartieMonstre.UpdateObject(couleur);
	}
	
	public void saveBackGround(String backgroundURL){
		BackgroundURL = backgroundURL;
	}
	
	public String getBackground() {
		return BackgroundURL;
	}
	
	public void sauvegarde() {
		Exporteur.getInstance().sauvegarder(partiesMonstre, BackgroundURL);
	}
}

