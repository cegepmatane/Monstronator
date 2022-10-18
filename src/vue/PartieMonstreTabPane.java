package vue;

import java.io.File;
import java.util.List;

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
	
	
	public PartieMonstreTabPane() {
		super();
		PARTIESMONSTRE = new PartieMonstreModele();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
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
		
		int x =0;
		int y =0;
		int counter = 0;
		for (File partieMonstre : parties_Monstre) {
			gridPane.add(creerButton(partieMonstre, tabName, counter), x, y);
			x++;
			if (x==4) {
				y++;
				x=x%3;
			}
			counter++;
		}
		
	}
	
	private static Button creerButton(File partieMonstre, String tabname, int counter) {
		Button button = new Button();
		button.setId("button-"+tabname+"-"+counter);
		button.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	// TODO Handler
            }
        });
		return button;
	}
	
	
	
}
