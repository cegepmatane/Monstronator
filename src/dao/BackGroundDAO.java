package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BackGroundDAO {
	
	File folder_BackGround;
	
	List<File> images_BackGround_List;
	
	public BackGroundDAO() {
		parseImagesBackground();	
	}
	
	private void parseImagesBackground() {
		folder_BackGround = new File("src/vue/decoration/background");
		images_BackGround_List = new ArrayList<>();
		
		images_BackGround_List = new ArrayList<>();

	    for (final File fileEntry : folder_BackGround.listFiles()) {
	    	images_BackGround_List.add(fileEntry);
	    }
	    
	}
	
	

	public File getFolder_BackGround() {
		return folder_BackGround;
	}

	public List<File> getImages_BackGround_List() {
		return images_BackGround_List;
	}

}
