package modele;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.PartieMonstreDAO;

public class PartieMonstreModele {
	
	File folder_Monstre;
	
	List<File> parties_Monstre;
    
    List<List<File>> liste_contenant_liste_parti_monstre;
    
    PartieMonstreDAO dao;
    
    public PartieMonstreModele () {
    	dao = new PartieMonstreDAO();
        folder_Monstre = dao.getFolder_Monstre();
    	parties_Monstre = dao.getParties_Monstre();
    	liste_contenant_liste_parti_monstre = dao.getListe_contenant_liste_parti_monstre();
    }


	public List<File> getParties_Monstre() {
		System.out.println("Model.getParties_Monstre()");
		return parties_Monstre;
	}

	public List<List<File>> getListe_contenant_liste_parti_monstre() {
		return liste_contenant_liste_parti_monstre;
	}
    
    
    
    
}
