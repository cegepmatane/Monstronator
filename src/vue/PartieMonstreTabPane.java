package vue;

import java.io.File;
import java.util.List;

import controleur.ControleurMonstronator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import modele.PartieMonstreModele;

public class PartieMonstreTabPane extends TabPane{
	
	private PartieMonstreModele PARTIESMONSTRE;
	private ControleurMonstronator controleur;
	
	
	public PartieMonstreTabPane() {
		super();
		this.controleur = new ControleurMonstronator();
		PARTIESMONSTRE = new PartieMonstreModele();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setId("tabPanneau");
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
		}
		int counter = 0;
		for (List<File> partie_Monstre : PARTIESMONSTRE.getListe_contenant_liste_parti_monstre()) {
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
		
		int x = 0;
		int y = 0;
		int counter = 0;
		for (File partieMonstre : parties_Monstre) {
			gridPane.add(creerButton(partieMonstre, tabName, counter), x, y);
			x++;
			if (x == 4) {
				y++;
				x %= 3;
			}
			counter++;
		}
		
	}
	
	private Button creerButton(File partieMonstre, String tabname, int counter) {
		Button button = new Button();
		String id = "button-"+tabname+"-"+counter;
		button.setId(id);
		button.setOnAction(new ClicBouttonPanneau(this.controleur, id));
		return button;
	}

	public static class ClicBouttonPanneau implements EventHandler<ActionEvent> {
		ControleurMonstronator controleur;
		String id;

		public ClicBouttonPanneau(ControleurMonstronator controleur, String id)
		{
			this.controleur = controleur;
			this.id = id;
		}

		public void handle(ActionEvent e)
		{
			System.out.println("action ClicBouttonPanneau - handle("+id+") ");
			controleur.notifierClicPartieMonstre();
		}
	}

}

