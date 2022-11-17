package controleur.commande;

import java.util.ArrayList;
import java.util.List;

import vue.VueMonstronator;

public class CommandModele {
	
	protected static CommandModele instance = null;
	public static CommandModele  getInstance() {if (null == instance)instance = new CommandModele(); return CommandModele.instance;};
	
	protected List<Commande> historique = new ArrayList<Commande>();
	protected List<Commande> historiqueUndo = new ArrayList<Commande>();
	
	public void ajouterHistorique(Commande cmd) {
		historique.add(cmd);
		cmd.executer();
	}
	
	public void undo() {
		System.out.println("Undo index: "+(historique.size()-1)+" size: "+historique.size());
		Commande cmd =historique.get(historique.size()-1);
		cmd.annuler();
		historiqueUndo.add(cmd);
		historique.remove(cmd);
	}
	
	public void redo() {
		System.out.println("Undo index: "+(historiqueUndo.size()-1)+" size: "+historiqueUndo.size());
		Commande cmd =historiqueUndo.get(historiqueUndo.size()-1);
		cmd.executer();
		historique.add(cmd);
		historiqueUndo.remove(cmd);
	}
	
	
}
