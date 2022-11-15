package controleur.commande;

import vue.VueMonstronator;

public class CommandeTaille  extends Commande {
	
	protected double old, current;
	protected String id;
	VueMonstronator vue = VueMonstronator.getInstance(); 
	public CommandeTaille(String id, double old, double current) {
		this.old = old;
		this.current = current;
		this.id =id;
	}

	@Override
	public void executer() {
		vue.vraimentAppliquerGrosseur(id, current);
	}

	@Override
	public void annuler() {
		vue.vraimentAppliquerGrosseur(id, old);		
	}

}
