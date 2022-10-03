package vue;
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
import javafx.scene.shape.Rectangle;
import modele.MonstreModele;
import vue.FxmlId;

public class VueMonstronator extends Vue{

	protected ControleurMonstronator  controleur;
	protected static VueMonstronator  instance = null; 
	public static VueMonstronator  getInstance() {if(null==instance)instance = new VueMonstronator();return VueMonstronator.instance;}; 
	private String urlImg;
	
	
	private VueMonstronator () 
	{
		super("monstronator.fxml", VueMonstronator .class, 1294,743);
		super.controleur = this.controleur = new ControleurMonstronator ();
		Logger.logMsg(Logger.INFO, "new VueJardinator()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		Button actionChoisirCarrote = (Button)lookup("#choisir-carotte");
		actionChoisirCarrote.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("handle");
            	controleur.notifierSelection();
            	urlImg = "vue/decoration/semis/carotte.png";
            	allumerSelection(actionChoisirCarrote);
            }
        });
		
			
		Rectangle carte = (Rectangle)lookup(FxmlId.CARTE);
		carte.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("carte handle");
            	controleur.notifierCarte();
            	double x = arg0.getX();
            	double y = arg0.getY();
            	System.out.println("x / y: "+ x+" / "+y);
            	controleur.notifierClick(x, y);
			}
			
		});
		
	}
	
	private Button selectionAllume = null;
	
	
	public void allumerSelection(Button legume) {
		if(selectionAllume!=null) this.selectionAllume.setStyle("-fx-background-color:transparent;-fx-opacity:1;");
		selectionAllume = legume;
		this.selectionAllume.setStyle("-fx-background-color:yellow;-fx-opacity:0.6;");
		}
	
	
	public void afficherSelection(double x, double y) {
		ImageView legumePlantee = new ImageView();
		legumePlantee.setImage(new Image(urlImg));
		legumePlantee.setFitHeight(100);
		legumePlantee.setPreserveRatio(true);
		legumePlantee.setX(x-(legumePlantee.getBoundsInParent().getWidth()/2));
		legumePlantee.setY(y-50);
		AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
		cloture.getChildren().add(legumePlantee);
	}
}
