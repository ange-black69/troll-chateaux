package common;

import Entities.Case;
import Entities.Chemin;
import Entities.Player;
import Entities.Troll;
import Strategies.DumbStrat;
import Strategies.PrudenteStrat;
import Strategies.StrategySolver;

public class Game {

    private Troll troll;
    private Chemin chemin;
    private Player joueur1;
    private Player joueur2;

    private final StrategySolver strategySolver = new StrategySolver(this);

    private static final int TAILLE_CHEMIN = 7;

    public Game()
    {
        chemin = new Chemin(TAILLE_CHEMIN);

        joueur1 = new Player(10, 0, (short)1,this);
        joueur2 = new Player(10,TAILLE_CHEMIN-1, (short)2, this);

    /*    Main.logger.info("joueur 1 : " + joueur1.toString());
        Main.logger.info("joueur 2 : " + joueur2.toString());*/
        troll = new Troll(chemin);

        chemin.afficherChemin();

        chemin.changeCasePosition(troll.getIndice(), 2);

        chemin.afficherChemin();

        Main.logger.warning("------------APPLICATION DES STRATEGIES------------");

        joueur1.setPlayerStrategy(new DumbStrat());
        joueur1.applyStrategy();
        joueur2.setPlayerStrategy(new PrudenteStrat());
        joueur2.applyStrategy();


    }


    public Troll getTroll() {
        return troll;
    }

    public Chemin getChemin() {
        return chemin;
    }

    public Player getJoueur1() {
        return joueur1;
    }

    public Player getJoueur2() {
        return joueur2;
    }

    public static int getTailleChemin() {
        return TAILLE_CHEMIN;
    }


}
