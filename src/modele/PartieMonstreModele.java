package modele;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.PartieMonstreDAO;

public class PartieMonstreModele {
	
	File folder_Monstre;
	
	List<File> parties_Monstre;
    List<String> parties_Monstre_Nom;
    
    List<List<File>> liste_contenant_liste_parti_monstre;
    List<List<String>> liste_contenant_liste_parti_monstre_nom;
    
    PartieMonstreDAO dao;
    
    public PartieMonstreModele () {
    	dao = new PartieMonstreDAO();
        folder_Monstre = dao.getFolder_Monstre();
    	parties_Monstre = dao.getParties_Monstre();
    	parties_Monstre_Nom = dao.getParties_Monstre_Nom();
    	liste_contenant_liste_parti_monstre = dao.getListe_contenant_liste_parti_monstre();
    	liste_contenant_liste_parti_monstre_nom = dao.getListe_contenant_liste_parti_monstre_nom();
    }
    
    
}
