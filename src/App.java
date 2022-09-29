
import architecture.Controleur;
import architecture.Fenetre;
import vue.VueJardinator;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueJardinator.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
