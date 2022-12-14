package donnee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modele.MonstreModele;
import modele.MonstreModele.Background;
import modele.MonstreModele.PartieMonstre;

public class Exporteur {
	protected static Exporteur instance = null; 
	public static Exporteur getInstance() {
		if(null==instance)
			instance = new Exporteur(); return Exporteur.instance;
	}
	
	public static String NOM_FICHIER = "export.xml";
	
	
	public void sauvegarder(HashMap<String, PartieMonstre> partiesMonstre, Background BackgroundURL) {
		String texte = "";
		if (partiesMonstre!=null) {
			for(Map.Entry mapentry : partiesMonstre.entrySet()) {
				texte += ((PartieMonstre)mapentry.getValue()).exporterXML();
			}
		}
		if (BackgroundURL != null) {
			texte += BackgroundURL.exporterXML();			
		}
		texte = "<sauvegarde>" + texte + "</sauvegarde>";
		
		try {
			FileWriter fichier = new FileWriter(NOM_FICHIER,false);
			fichier.write(texte);
			fichier.close();
		}
		catch(IOException ioe) {
		}
	}

	public void sauvegarderBackground(Exportable objet) {
		String texte = "<sauvegarde>" + objet.exporterXML() + "</sauvegarde>";
		
		try {
			FileWriter fichier = new FileWriter(NOM_FICHIER,false);
			fichier.write(texte);
			fichier.close();
		}
		catch(IOException ioe) {}
	}
	
	
}
