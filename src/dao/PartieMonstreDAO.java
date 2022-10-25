package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PartieMonstreDAO {
	
	File folder_Monstre;
	
	List<File> parties_Monstre;
    
    List<List<File>> liste_contenant_liste_parti_monstre;
    
    public PartieMonstreDAO() {
    	ParsePartieMonstre();
    }
	
	public void ParsePartieMonstre() {
		
		folder_Monstre = new File("src/vue/decoration/SVG/Monsters");
		
		parties_Monstre = new ArrayList<>();

//	    System.out.println("folder_Monstre : ");
//	    System.out.println(folder_Monstre);
//	    System.out.println(folder_Monstre.listFiles());
//    	System.out.println("\nContent : ");
	    for (final File fileEntry : folder_Monstre.listFiles()) {
//	    	System.out.println("fileEntry : ");
//	    	System.out.println(fileEntry);
	    	parties_Monstre.add(fileEntry);
	    }
	    
//	    System.out.println("\nparties_Monstre : ");
//	    System.out.println(parties_Monstre);
	    
	    liste_contenant_liste_parti_monstre = new ArrayList<List<File>>();
	    List<File> temp;
	    for (File parti_monstre : parties_Monstre) {
	    	temp = new ArrayList<>();
//	        System.out.println(parti_monstre);
	        for (final File fileEntry : parti_monstre.listFiles()) {
	        	temp.add(fileEntry);
	        }
	        liste_contenant_liste_parti_monstre.add(temp);
	    }
	}

	public File getFolder_Monstre() {
		return folder_Monstre;
	}

	public List<File> getParties_Monstre() {
//		System.out.println("DOA.PartieMonstre.getParties_Monstre");
		return parties_Monstre;
	}

	public List<List<File>> getListe_contenant_liste_partie_monstre() {
		return liste_contenant_liste_parti_monstre;
	}
	
	
	
	

}
