package vue.evenement;
import controleur.ControleurMonstronator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClicBouttonPanneau implements EventHandler<ActionEvent> {
    ControleurMonstronator controleur;
    String id;

    public ClicBouttonPanneau(ControleurMonstronator controleur, String id)
    {
        this.controleur = controleur;
        this.id = id;
    }

    public void handle(ActionEvent e)
    {
        System.out.println("action ClicBouttonPanneau - handle("+id+") ");
        controleur.notifierClicPartieMonstre();
    }
}
