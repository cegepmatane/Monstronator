package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ImageFondDAO {
	
	File fichierImage;
	
	List<File> listeImages;
	
	public ImageFondDAO() {
		analyseImageFond();
	}
	
	private void analyseImageFond() {
		fichierImage = new File("src/vue/decoration/background");
		
		listeImages = new ArrayList<>();

		Collections.addAll(listeImages, Objects.requireNonNull(fichierImage.listFiles()));
	}

	public File getFichierImage() {
		return fichierImage;
	}

	public List<File> getListeImages() {
		return listeImages;
	}
}
