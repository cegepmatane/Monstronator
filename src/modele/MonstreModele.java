package modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import vue.VueModeleImageFond;

public class MonstreModele {
	
	protected static MonstreModele instance = null; 

	public static MonstreModele getInstance() {
		if(null==instance)
			instance = new MonstreModele(); return MonstreModele.instance;
	}
	
	public class PartieMonstre {
		protected Object object;
		protected double x, y;
		double taille;
		String couleur;
		
		PartieMonstre(Object obj, double x, double y, double taille, String couleur){
			object = obj;
			this.x=x;
			this.y=y;
			this.taille=taille;
			this.couleur=couleur;
		}
	}
	
	// TODO change list to hash map with id of object
	
	protected List<PartieMonstre> partiesMonstre = new LinkedList<PartieMonstre>();
	
	public void addPartie(Object obj, double x, double y, double taille, String couleur) {
		partiesMonstre.add(new PartieMonstre(obj, x, y, taille, couleur));
	}
	
}
