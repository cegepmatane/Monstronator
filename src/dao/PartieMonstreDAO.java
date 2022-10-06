package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PartieMonstreDAO {
	
	File folder_Monstre;
	
	List<File> parties_Monstre;
    List<String> parties_Monstre_Nom;
    
    List<List<File>> liste_contenant_liste_parti_monstre;
    List<List<String>> liste_contenant_liste_parti_monstre_nom;
	
	public void ParsePartieMonstre() {
		
		folder_Monstre = new File("vue/decoration/SVG");
	    
		parties_Monstre = new ArrayList<>();
		parties_Monstre_Nom = new ArrayList<>();
	    System.out.println(folder_Monstre);
	    for (final File fileEntry : folder_Monstre.listFiles()) {
	    	parties_Monstre.add(fileEntry);
	    	parties_Monstre_Nom.add(fileEntry.getName());
	    }
	    
	    List<File> temp;
	    List<String> temp_nom;
	    for (File parti_monstre : parties_Monstre) {
	    	temp = new ArrayList<>();
	    	temp_nom = new ArrayList<>();
	        System.out.println(parti_monstre);
	        for (final File fileEntry : parti_monstre.listFiles()) {
	        	temp.add(fileEntry);
	        	temp_nom.add(fileEntry.getName());
	        }
	        liste_contenant_liste_parti_monstre.add(temp);
	        liste_contenant_liste_parti_monstre_nom.add(temp_nom);
	    }
	}

	public File getFolder_Monstre() {
		return folder_Monstre;
	}

	public List<File> getParties_Monstre() {
		return parties_Monstre;
	}

	public List<String> getParties_Monstre_Nom() {
		return parties_Monstre_Nom;
	}

	public List<List<File>> getListe_contenant_liste_parti_monstre() {
		return liste_contenant_liste_parti_monstre;
	}

	public List<List<String>> getListe_contenant_liste_parti_monstre_nom() {
		return liste_contenant_liste_parti_monstre_nom;
	}
	
	
	
	

}
