package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurJardinator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import modele.jardinModele.LEGUME;

public class VueJardinator extends Vue {

	protected ControleurJardinator controleur;
	protected static VueJardinator instance = null; 
	public static VueJardinator getInstance() {if(null==instance)instance = new VueJardinator();return VueJardinator.instance;}; 
	private String urlImg;
	
	
	private VueJardinator() 
	{
		super("jardinator.fxml", VueJardinator.class, 1294,743);
		super.controleur = this.controleur = new ControleurJardinator();
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
            	System.out.println("Choisir carrote");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/carotte.png";
            	allumerSemis(actionChoisirCarrote);
            }
        });
		
		Button actionChoisirChou = (Button)lookup("#choisir-chou");
		actionChoisirChou.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir chou");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/chou.png";
            	allumerSemis(actionChoisirChou);
            }
        });
		
		Button actionChoisirChampignon = (Button)lookup("#choisir-champignon");
		actionChoisirChampignon.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir champignon");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/champignon.png";
            	allumerSemis(actionChoisirChampignon);
            }
        });
		
		Button actionChoisirLaitue = (Button)lookup("#choisir-laitue");
		actionChoisirLaitue.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir laitue");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/laitue.png";
            	allumerSemis(actionChoisirLaitue);
            }
        });
		
		Button actionChoisirChouFleu = (Button)lookup("#choisir-chou-fleur");
		actionChoisirChouFleu.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir chou-fleu");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/chou-fleur.png";
            	allumerSemis(actionChoisirChouFleu);
            }
        });
		
		Button actionChoisirOignon = (Button)lookup("#choisir-oignon");
		actionChoisirOignon.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir oignon");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/oignon.png";
            	allumerSemis(actionChoisirOignon);
            }
        });
		
		Button actionChoisirPanais = (Button)lookup("#choisir-panais");
		actionChoisirPanais.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir panais");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/panais.png";
            	allumerSemis(actionChoisirPanais);
            }
        });
		
		
		Button actionChoisirRadis = (Button)lookup("#choisir-radis");
		actionChoisirRadis.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	System.out.println("Choisir radis");
            	controleur.notifierLegume();
            	urlImg = "vue/decoration/semis/radis.png";
            	allumerSemis(actionChoisirRadis);
            }
        });
		
		
		
		Rectangle jardin = (Rectangle)lookup("#jardin-terre");
		jardin.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("jardin handle");
            	controleur.notifierJardin();
            	double x = arg0.getX();
            	double y = arg0.getY();
            	System.out.println("x / y: "+ x+" / "+y);
            	controleur.notifierClick(x, y);
			}

			
		});
		

	}
	
	private Button semisAllume = null;
	
	
	public void allumerSemis(Button legume) {
		if(semisAllume!=null) this.semisAllume.setStyle("-fx-background-color:transparent;-fx-opacity:1;");
		semisAllume = legume;
		this.semisAllume.setStyle("-fx-background-color:yellow;-fx-opacity:0.6;");
		}
	
	
	public void afficherLegume(double x, double y) {
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
