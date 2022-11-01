package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PartieMonstreDAO {
	
	File fichierMonstre;
	
	List<File> partiesMonstre;
    
    List<List<File>> listeContenantListePartieMonstre;
    
    public PartieMonstreDAO() {
    	AnalysePartieMonstre();
    }
	
	public void AnalysePartieMonstre() {
		
		fichierMonstre = new File("src/vue/decoration/PNG/Monsters");
		
		partiesMonstre = new ArrayList<>();

//	    System.out.println("folder_Monstre : ");
//	    System.out.println(folder_Monstre);
//	    System.out.println(folder_Monstre.listFiles());
//    	System.out.println("\nContent : ");
	    for (final File fileEntry : fichierMonstre.listFiles()) {
//	    	System.out.println("fileEntry : ");
//	    	System.out.println(fileEntry);
	    	partiesMonstre.add(fileEntry);
	    }
	    
//	    System.out.println("\nparties_Monstre : ");
//	    System.out.println(parties_Monstre);
	    
	    listeContenantListePartieMonstre = new ArrayList<List<File>>();
	    List<File> temp;
	    for (File partieMonstre : partiesMonstre) {
	    	temp = new ArrayList<>();
//	        System.out.println(parti_monstre);
	        for (final File fileEntry : partieMonstre.listFiles()) {
	        	temp.add(fileEntry);
	        }
	        listeContenantListePartieMonstre.add(temp);
	    }
	}


	public File getFichierMonstre() {
		return fichierMonstre;
	}

	public List<File> getParties_Monstre() {
//		System.out.println("DOA.PartieMonstre.getParties_Monstre");
		return partiesMonstre;
	}

	public List<List<File>> getListeContenantListePartieMonstre() {
		return listeContenantListePartieMonstre;
	}
}
