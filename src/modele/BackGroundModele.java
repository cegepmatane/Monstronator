package modele;

import java.io.File;
import java.util.List;

import dao.BackGroundDAO;
import dao.PartieMonstreDAO;
import vue.VueMonstronator;

public class BackGroundModele {

	protected static BackGroundModele  instance = null; 
	public static BackGroundModele getInstance() {if(null==instance)instance = new BackGroundModele(); return BackGroundModele.instance;}; 
	
	File folder_BackGround;
	
	List<File> images_BackGround_List;
	
	int selected = 0;
	
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
	
	public File getSelectedBackground() {
		return images_BackGround_List.get(selected);
	}
	
	public File getNextBackground() {
		selected = (selected+1)%images_BackGround_List.size();
		return images_BackGround_List.get(selected);
	}

}
