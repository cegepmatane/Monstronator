package commandPatern;

import vue.VueMonstronator;

public class CommandCouleur extends Command {

	private String old, current;
	protected String id;
	VueMonstronator vue = VueMonstronator.getInstance(); 
	public CommandCouleur(String id, String old, String current) {
		this.old = old;
		this.current = current;
		this.id =id;
	}

	@Override
	public void executer() {
		vue.appliquerCouleur(id,current);
	}

	@Override
	public void annuler() {
		vue.appliquerCouleur(id,old);
	}

}
