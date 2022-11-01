package vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import controleur.ControleurMonstronator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.SVGPath;

import javax.imageio.ImageIO;

public class VuePartieMonstre extends TabPane{
	
	private VueModelePartieMonstre partieMonstre;
	private ControleurMonstronator controleur;
	
	
	public VuePartieMonstre()
	{
		super();
		this.controleur = new ControleurMonstronator();
		partieMonstre = new VueModelePartieMonstre();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setId("tabPanneau");
		this.setTabMinWidth(93.6);
		creationOngets();
	}
	
	public void creationOngets()
	{
		Tab tempTab;
		AnchorPane tempAnchor;
		for (File NomTab : partieMonstre.getPartiesMonstre()) {
			tempAnchor = new AnchorPane();
			tempAnchor.setId("Anchor-"+NomTab.getName());
			tempTab = new Tab(NomTab.getName(), tempAnchor);
			tempTab.setText(NomTab.getName());
			tempTab.setId(NomTab.getName());
			this.getTabs().add(tempTab);
			System.out.println(NomTab.getName());
		}
		int counter = 0;
		for (List<File> partieMonstre : partieMonstre.getListeContenantListePartieMonstre()) {
			remplirOnglet(partieMonstre, this.getTabs().get(counter));
			counter++;
		}
	}
	
	private void remplirOnglet(List<File> partiesMonstre, Tab onglet)
	{
		AnchorPane ongletAnchorPane = (AnchorPane)((onglet.getContent()).lookup("#Anchor-"+(onglet.getId())));
		String nomOnglet = onglet.getId();
		GridPane gridPane = new GridPane();
		gridPane.setId("GridPane-"+nomOnglet);
		ongletAnchorPane.getChildren().add(gridPane);
		
		int x = 1;
		int y = 0;
		int numeroBouton = 0;
		for (File partieMonstre : partiesMonstre) {
			gridPane.add(creerBoutton(partieMonstre, nomOnglet, numeroBouton), x, y);
			x++;
			if (x == 5) {
				y++;
				x %= 4;
			}
			numeroBouton++;
		}
	}
	
	private Button creerBoutton(File partieMonstre, String nomOnglet, int numeroBouton) {
		// set button
		Button bouton = new Button();
		String id = "button-"+nomOnglet+"-"+numeroBouton;
		bouton.setId(id);
		// set graphic
		
		//  image
		ImageView imageBouton = new ImageView();
		System.out.println((partieMonstre.getPath()).substring(4));
		Image tempImage = new Image((partieMonstre.getPath()).substring(4));
		System.out.println(tempImage.getUrl());

		imageBouton.setImage(tempImage);
		imageBouton.setId(tempImage.getUrl());
		imageBouton.setId(id+"-ImageView");
		System.out.println(id+"-ImageView");
		
		
		
		imageBouton.setPickOnBounds(true);
		imageBouton.setPreserveRatio(true);
		imageBouton.setFitHeight(80);
		imageBouton.setFitWidth(80);

		bouton.setGraphic(imageBouton);
		bouton.setMaxHeight(100);
		bouton.setMaxWidth(100);
		System.out.println("Button Graphic : " + bouton.getGraphic().getId());
		bouton.setOnAction(new ClicBoutonPanneau(this.controleur, id, bouton, (partieMonstre.getPath()).substring(4)));

		// grid pane margin
		GridPane.setMargin(bouton,new Insets(1.8, 1.8, 1.8, 1.8) );

		return bouton;
	}

	public static class ClicBoutonPanneau implements EventHandler<ActionEvent> {
		ControleurMonstronator controleur;
		String id;
		String imageURL;
		Button bouton;

		public ClicBoutonPanneau(ControleurMonstronator controleur, String id, Button bouton, String imageURL)
		{
			this.controleur = controleur;
			this.id = id;
			this.bouton = bouton;
			this.imageURL = imageURL;
		}

		public void handle(ActionEvent e)
		{
			System.out.println("action ClicBoutonPanneau - handle("+id+") ");
			System.out.println("button image " + bouton.getGraphic().getId());
			//controleur.notifierClicPartieMonstre();
			if (VueMonstronator.instance.GetUrlImageSelectionee().equals(imageURL))
			{
				VueMonstronator.instance.setUrlImageSelectionee("");
			} else {
				VueMonstronator.instance.setUrlImageSelectionee(imageURL);
			}
		}
	}
}

