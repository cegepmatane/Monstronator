package modele;

import java.io.File;
import java.util.List;

import dao.BackGroundDAO;
import dao.PartieMonstreDAO;

public class BackGroundModele {
	
	File folder_BackGround;
	
	List<File> images_BackGround_List;
	
	BackGroundDAO dao;
    
    public BackGroundModele () {
    	dao = new BackGroundDAO();
    	folder_BackGround = dao.getFolder_BackGround();
    	images_BackGround_List = dao.getImages_BackGround_List();
    }

	public File getFolder_BackGround() {
		return folder_BackGround;
	}

	public List<File> getImages_BackGround_List() {
		return images_BackGround_List;
	}

}
