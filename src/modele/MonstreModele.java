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
		
		PartieMonstre(Object obj, double x, double y){
			object = obj;
			this.x=x;
			this.y=y;
		}
	}
	
	protected List<PartieMonstre> partiesMonstre = new LinkedList<PartieMonstre>();
	
	public void addPartie(Object obj, double x, double y) {
		partiesMonstre.add(new PartieMonstre(obj, x, y));
	}
	
}
