
import architecture.Controleur;
import architecture.Fenetre;
import vue.VueMonstronator;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueMonstronator.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
