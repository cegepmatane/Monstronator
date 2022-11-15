package vue;
import java.io.File;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurMonstronator;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modele.MonstreModele;

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
		Button actionSauvegarder = (Button) paneButtonBackGround.getChildren().get(1);
		actionSauvegarder.setOnAction(e -> {
			System.out.println("Handle.actionSauvegarder");
			controleur.notifierSauvegarde();
		});
		
		BackGroundAnchor = (AnchorPane)lookup("#background-monstre");
		BackGroundImageView = (ImageView) BackGroundAnchor.getChildren().get(0);
		Rectangle RectangleClickPartie = (Rectangle) BackGroundAnchor.getChildren().get(1);
		BackGroundImageView.setId("BackGround-Image");

		RectangleClickPartie.setOnMouseClicked(arg0 -> {
			System.out.print("Placer Handle: ");
			double x = arg0.getX();
			double y = arg0.getY();
			System.out.println("x / y: "+ x+" / "+y);
			controleur.notifierClic(x, y);
		});

		Button BoutonAppliquer = (Button)lookup("#bouton-appliquer");
		BoutonAppliquer.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicAppliquer();
		});
		
		
		
		Circle BouttonCouleurBleu = (Circle)lookup("#couleur-bleu");
		BouttonCouleurBleu.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicCouleur("bleu");
		});
		Circle BouttonCouleurRouge = (Circle)lookup("#couleur-rouge");
		BouttonCouleurRouge.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicCouleur("rouge");
		});
		Circle BouttonCouleurJaune = (Circle)lookup("#couleur-jaune");
		BouttonCouleurJaune.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicCouleur("jaune");
		});
		Circle BouttonCouleurVert = (Circle)lookup("#couleur-vert");
		BouttonCouleurVert.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicCouleur("vert");
		});
		Circle BouttonCouleurNoir = (Circle)lookup("#couleur-noir");
		BouttonCouleurNoir.setOnMouseClicked(arg0 -> {
			System.out.println("Appliquer handle()");
			controleur.notifierClicCouleur("noir");
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
		
		Button undoButton = (Button)lookup("#Undo");
		undoButton.setOnMouseClicked(arg0 -> {
			System.out.println("Undo handle()");
			controleur.notifierUndo();
		});
		
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
			controleur.notifierChangementDonnee(urlImg, x, y, 100, "noir", identifiant);
		}
	}

	// La grosseur = height de l'image puisque les images ont un fixed aspect-ratio
	public double getGrosseurImage(String id) {
		ImageView imageSelection = (ImageView)lookup("#"+id);
		return imageSelection.getFitHeight();
	}
	public double getValeurGrosseur(){
		TextField champsGrosseur = (TextField)lookup("#grosseur-valeur");
		return Double.parseDouble(champsGrosseur.getText());
	}

	public void appliquerGrosseur(String id, double oldTaille) {
		controleur.notifierCommandTaille(id, oldTaille, getValeurGrosseur());
	}
	
	public void vraimentAppliquerGrosseur(String id, double grosseur) {
		ImageView imageSelection = (ImageView)lookup("#"+id);
		imageSelection.setFitHeight(grosseur);
		controleur.notifierChangementTaille(grosseur, id);
	}

	public void afficherValeurGrosseur(double grosseur){
		TextField champsGrosseur = (TextField)lookup("#grosseur-valeur");
		champsGrosseur.setText(grosseur + "");
	}

	public void appliquerCouleur(String id, String couleur, String oldCouleur) {
		controleur.notifierCommandCouleur(id, oldCouleur, couleur);
	}
	
	public void vraimentAppliquerCouleur(String id, String couleur) {
		ImageView couleurSelectionee = (ImageView)lookup("#"+id);
		ColorAdjust colorAdjust = new ColorAdjust();
		double hue = 0;
		if (couleur == "bleu") {
			hue = -0.1;
		}
		else if (couleur == "rouge") {
			hue = 0.85;
		}
		else if (couleur == "jaune") {
			hue = -0.78;
		}
		else if (couleur == "vert") {
			hue = -0.6;
		}
		else if (couleur == "noir") {
			colorAdjust.setBrightness(0);
		}
		System.out.println(hue);
		colorAdjust.setHue(hue);
		couleurSelectionee.setEffect(colorAdjust);
		controleur.notifierChangementCouleur(couleur, id);
	}
	
	public String changerBackGround(File file) {
		System.out.println((file.getPath()).substring(4));
		String UrlBackground = (file.getPath()).substring(4);
		BackGroundImageView.setImage(new Image(UrlBackground));
		return UrlBackground;
	}
}
