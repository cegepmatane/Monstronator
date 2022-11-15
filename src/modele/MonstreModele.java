package modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import donnee.Exportable;
import donnee.Exporteur;
import vue.VueModeleImageFond;

public class MonstreModele {
	
	protected static MonstreModele instance = null; 
	public static MonstreModele getInstance() {
		if(null==instance)
			instance = new MonstreModele(); return MonstreModele.instance;
	}
	
	public class PartieMonstre implements Exportable{
		String imageURL, couleur;
		double x, y, taille;
		
		PartieMonstre(String imageURL, double x, double y, double taille, String couleur){
			this.imageURL = imageURL;
			this.x=x;
			this.y=y;
			this.taille=taille;
			this.couleur=couleur;
		}
		
		
		public String getImageURL() {
			return imageURL;
		}


		public String getCouleur() {
			return couleur;
		}


		public double getX() {
			return x;
		}


		public double getY() {
			return y;
		}


		public double getTaille() {
			return taille;
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
		@Override
		public String exporterXML() {
			StringBuilder xmlBuilder = new StringBuilder();
			xmlBuilder.append("<PartieMonstre>");
			xmlBuilder.append("<imageURL>");
			xmlBuilder.append(this.imageURL);
			xmlBuilder.append("</imageURL>");
			xmlBuilder.append("<couleur>");
			xmlBuilder.append(this.couleur);
			xmlBuilder.append("</couleur>");
			xmlBuilder.append("<x>");
			xmlBuilder.append(this.x);
			xmlBuilder.append("</x>");
			xmlBuilder.append("<y>");
			xmlBuilder.append(this.y);
			xmlBuilder.append("</y>");
			xmlBuilder.append("<taille>");
			xmlBuilder.append(this.taille);
			xmlBuilder.append("</taille>");
			xmlBuilder.append("</PartieMonstre>");
			
			return xmlBuilder.toString();
		}
		@Override
		public String exporterJSON() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	protected HashMap<String, PartieMonstre> partiesMonstre = new HashMap<String, PartieMonstre>();
	public class Background implements Exportable{
		public String URL;

		@Override
		public String exporterXML() {
			return "<Background><URL>"+URL+"</URL></Background>";
		}

		@Override
		public String exporterJSON() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public double getPartieMonstreTaille(String id) {
		return partiesMonstre.get(id).getTaille();
	}
	
	public String getPartieMonstreCouleur(String id) {
		return partiesMonstre.get(id).getCouleur();
	}
	
	Background background = new Background();
	
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
		background.URL = backgroundURL;
	}
	
	public String getBackground() {
		return background.URL;
	}
	
	public void sauvegarde() {
		Exporteur.getInstance().sauvegarder(partiesMonstre, background);
	}
}

