package controleur.commande;

import vue.VueMonstronator;

public class CommandeCouleur extends Commande {

	private String old, current;
	protected String id;
	VueMonstronator vue = VueMonstronator.getInstance(); 
	public CommandeCouleur(String id, String old, String current) {
		this.old = old;
		this.current = current;
		this.id =id;
	}

	@Override
	public void executer() {
		vue.vraimentAppliquerCouleur(id,current);
	}

	@Override
	public void annuler() {
		vue.vraimentAppliquerCouleur(id,old);
	}

}
