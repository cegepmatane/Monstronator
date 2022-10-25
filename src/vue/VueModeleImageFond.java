package vue;

import java.io.File;
import java.util.List;

import dao.BackGroundDAO;

public class VueModeleImageFond {

	protected static VueModeleImageFond instance = null; 

	public static VueModeleImageFond getInstance() {
		if(null==instance)
			instance = new VueModeleImageFond(); return VueModeleImageFond.instance;
	}
	
	File dossierImage;
	
	List<File> listeImages;
	
	int selection = 0;
	
	BackGroundDAO dao;
    
    public VueModeleImageFond() {
    	dao = new BackGroundDAO();
    	dossierImage = dao.getFolder_BackGround();
    	listeImages = dao.getImages_BackGround_List();
    }
	
	public File getFondSelectionne() {
		return listeImages.get(selection);
	}
	
	public File getProchainFond() {
		selection = (selection + 1) % listeImages.size();
		return listeImages.get(selection);
	}

	//public File getDossierImage() { return dossierImage; }
	//public List<File> getListeImages() { return listeImages; }
}
