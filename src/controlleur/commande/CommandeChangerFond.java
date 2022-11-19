package controlleur.commande;

import java.io.File;

import vue.VueModeleImageFond;
import vue.VueMonstronator;

public class CommandeChangerFond extends Commande{
	
	protected File nouveauFond, ancienFond;
	protected VueMonstronator vue = VueMonstronator.getInstance();
	protected VueModeleImageFond modeleImageFond = VueModeleImageFond.getInstance();
	
	public CommandeChangerFond(File nouveauFond) {
		this.nouveauFond = nouveauFond;
	}
	
	@Override
	public void executer() {
		vue.changerBackGround(nouveauFond);
	}
	
	@Override
	public void annuler() {
		vue.changerBackGround(ancienFond);
	}
}
