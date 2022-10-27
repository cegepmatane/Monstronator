package vue;

import java.io.File;
import java.util.List;

import dao.PartieMonstreDAO;

public class VueModelePartieMonstre {
	
	File fichier_Monstre;
	List<File> parties_Monstre;
    List<List<File>> listeContenantListePartieMonstre;
    PartieMonstreDAO dao;
    
    public VueModelePartieMonstre()
	{
    	dao = new PartieMonstreDAO();

		fichier_Monstre = dao.getFolder_Monstre();
    	parties_Monstre = dao.getParties_Monstre();
    	listeContenantListePartieMonstre = dao.getListeContenantListePartieMonstre();
    }


	public List<File> getPartiesMonstre()
	{
		System.out.println("VueModelerPartieMonstre.getParties_Monstre()");
		return parties_Monstre;
	}

	public List<List<File>> getListeContenantListePartieMonstre()
	{
		System.out.println("VueModelePartieMonstre.getListeContenantListePartieMonstre()");
		return listeContenantListePartieMonstre;
	}
}
