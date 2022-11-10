package commandPatern;

import vue.VueMonstronator;

public class CommandTaille  extends Command {
	
	protected double old, current;
	protected String id;
	VueMonstronator vue = VueMonstronator.getInstance(); 
	public CommandTaille(String id, double old, double current) {
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
