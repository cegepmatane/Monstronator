package vue;

import java.io.File;
import java.util.List;

import controleur.ControleurMonstronator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.SVGPath;

public class VuePartieMonstre extends TabPane{
	
	private VueModelePartieMonstre PARTIESMONSTRE;
	private ControleurMonstronator controleur;
	
	
	public VuePartieMonstre() {
		super();
		this.controleur = new ControleurMonstronator();
		PARTIESMONSTRE = new VueModelePartieMonstre();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setId("tabPanneau");
		this.setTabMinWidth(93.6);
		creationTabs();
	}
	
	public void creationTabs() {
		Tab temp;
		AnchorPane temp_Anchor;
		for (File NomTab : PARTIESMONSTRE.getParties_Monstre()) {
			temp_Anchor = new AnchorPane();
			temp_Anchor.setId("Anchor-"+NomTab.getName());
			temp = new Tab(NomTab.getName(), temp_Anchor);
			temp.setText(NomTab.getName());
			temp.setId(NomTab.getName());
			this.getTabs().add(temp);
			System.out.println(NomTab.getName());
		}
		int counter = 0;
		for (List<File> partie_Monstre : PARTIESMONSTRE.getListeContenantListePartieMonstre()) {
			remplirTab(partie_Monstre
					, this.getTabs().get(counter));
			counter++;
		}
	}
	
	private void remplirTab(List<File> parties_Monstre, Tab tab) {
		AnchorPane tabAnchorPane = (AnchorPane)((tab.getContent()).lookup("#Anchor-"+(tab.getId())));
		String tabName = tab.getId();
		GridPane gridPane = new GridPane();
		gridPane.setId("GridPane-"+tabName);
		tabAnchorPane.getChildren().add(gridPane);
		
		int x = 1;
		int y = 0;
		int counter = 0;
		for (File partieMonstre : parties_Monstre) {
			gridPane.add(creerButton(partieMonstre, tabName, counter, gridPane), x, y);
			x++;
			if (x == 5) {
				y++;
				x %= 4;
			}
			counter++;
		}
		
		
	}
	
	private Button creerButton(File partieMonstre, String tabname, int counter, GridPane gridPane) {
		// set button
		Button button = new Button();
		String id = "button-"+tabname+"-"+counter;
		button.setId(id);
		// set graphic
		
		// image 
		ImageView buttonImage = new ImageView();
		System.out.println((partieMonstre.getPath()).substring(4));
		Image _temp = new Image((partieMonstre.getPath()).substring(4));
		System.out.println(_temp.getUrl());
		buttonImage.setImage(_temp);
		buttonImage.setId(_temp.getUrl());	
		buttonImage.setId(id+"-ImageView");
		System.out.println(id+"-ImageView");
		buttonImage.setPickOnBounds(true);
		buttonImage.setPreserveRatio(true);
		buttonImage.setFitHeight(80);
		buttonImage.setFitWidth(80);
		button.setGraphic(buttonImage);
		button.setMaxHeight(100);
		button.setMaxWidth(100);
		System.out.println("Button Graphic : " + button.getGraphic().getId());
		button.setOnAction(new ClicBouttonPanneau(this.controleur, id, button, (partieMonstre.getPath()).substring(4)));
		// grid pane margin
		gridPane.setMargin(button,new Insets(1.8, 1.8, 1.8, 1.8) );
		return button;
	}
	
	

	public static class ClicBouttonPanneau implements EventHandler<ActionEvent> {
		ControleurMonstronator controleur;
		String id;
		String ImgURL;
		Button button;

		public ClicBouttonPanneau(ControleurMonstronator controleur, String id, Button button, String ImgURL)
		{
			this.controleur = controleur;
			this.id = id;
			this.button = button;
			this.ImgURL = ImgURL;
			
		}

		public void handle(ActionEvent e)
		{
			System.out.println("action ClicBouttonPanneau - handle("+id+") ");
			System.out.println("button image " + button.getGraphic().getId());
			controleur.notifierClicPartieMonstre();
			if (VueMonstronator.instance.GetUrlImageSelectioner().equals(ImgURL)) {
				VueMonstronator.instance.setUrlImageSelectioner("");
			} else {
				VueMonstronator.instance.setUrlImageSelectioner(ImgURL);			
			}
			
		}
	}

}

