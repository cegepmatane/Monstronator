package vue;
import java.io.File;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurMonstronator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class VueMonstronator extends Vue{

	protected ControleurMonstronator  controleur;
	protected static VueMonstronator  instance = null; 
	public static VueMonstronator  getInstance() {if (null == instance)instance = new VueMonstronator(); return VueMonstronator.instance;};
	private String urlImg = "";

	private int indexPartieMonstre;

	private AnchorPane BackGroundAnchor;
	private ImageView BackGroundImageView;
	
	//this variable needs to go in the Main class, outside of the start() method
	private long lastRefreshTime = 0;
	
	
	private VueMonstronator()
	{
		super("monstronator.fxml", VueMonstronator .class, 1294, 743);
		super.controleur = this.controleur = new ControleurMonstronator();
		Logger.logMsg(Logger.INFO, "new VueMonstronator()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		
		// creation et remplisage du tabPane
		AnchorPane AnchorPaneMonstreTabPane = (AnchorPane)lookup("#panneau-membre");
		VuePartieMonstre paneauPartieMonstre = new VuePartieMonstre();
		AnchorPaneMonstreTabPane.getChildren().add(paneauPartieMonstre);
		
		Pane paneButtonBackGround = (Pane)lookup("#boutton-changer-bg");
		Button actionChangerBackGround = (Button) paneButtonBackGround.getChildren().get(0);
		actionChangerBackGround.setOnAction(e -> {
			System.out.println("Handle.actionChangerBackGround");
			controleur.notifierBackground();
		});
		
		
		BackGroundAnchor = (AnchorPane)lookup("#background-monstre");
		BackGroundImageView = (ImageView) BackGroundAnchor.getChildren().get(0);
		Rectangle RectangleClickPartie = (Rectangle) BackGroundAnchor.getChildren().get(1);
		

		RectangleClickPartie.setOnMouseClicked(arg0 -> {
			System.out.print("Placer Handle: ");
			double x = arg0.getX();
			double y = arg0.getY();
			System.out.println("x / y: "+ x+" / "+y);
			controleur.notifierClic(x, y);


		});
		
		// Scene refresh
		/*
		Scene scene = BackGroundAnchor.getScene();
		scene.addPreLayoutPulseListener(() -> {
		    long refreshTime = System.nanoTime();
		    System.out.println("Scene refreshed, refresh time: "+ (refreshTime - lastRefreshTime));
		    lastRefreshTime = refreshTime;
		});
		*/
		
	}
	
	private Button selectionAllume = null;
	
	
	public void allumerSelection(Button legume) {
		if(selectionAllume != null) this.selectionAllume.setStyle("-fx-background-color:transparent;-fx-opacity:1;");
		selectionAllume = legume;
		this.selectionAllume.setStyle("-fx-background-color:yellow;-fx-opacity:0.6;");
	}
	
	public void setUrlImageSelectionee(String urlString) {
		urlImg = urlString;
	}
	
	public String GetUrlImageSelectionee() {
		return urlImg;
	}
	
	public void afficherSelection(double x, double y) {
		if (!urlImg.isBlank()) {
			ImageView composantPlacee = new ImageView();
			composantPlacee.setImage(new Image(urlImg));
			composantPlacee.setFitHeight(100);
			composantPlacee.setPreserveRatio(true);
			composantPlacee.setX(x - (composantPlacee.getBoundsInParent().getWidth() / 2));
			composantPlacee.setY(y - 50);

			String identifiant = "composantPlacee-"+indexPartieMonstre;
			composantPlacee.setId(identifiant);
			composantPlacee.setOnMouseClicked(e ->
					controleur.notifierClicModifier(identifiant));
			indexPartieMonstre++;
			System.out.println("Identifiant = " + identifiant);

			BackGroundAnchor.getChildren().add(composantPlacee);
		}
	}
	
	public void changerBackGround(File file) {
		System.out.println((file.getPath()).substring(4));
		BackGroundImageView.setImage(new Image((file.getPath()).substring(4)));
		//BackGroundImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

		//	@Override
		//	public void handle(MouseEvent arg0) {
		//		System.out.print("Placer Handle: ");
        //    	double x = arg0.getX();
        //    	double y = arg0.getY();
        //    	System.out.println("x / y: "+ x+" / "+y);
        //    	controleur.notifierClic(x, y);
		//	}

			
		//});
	}
}
