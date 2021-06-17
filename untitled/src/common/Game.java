package common;

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


    GameState gameState;

    private final StrategySolver strategySolver = new StrategySolver(this);

    private int tailleChemin;

    public Game(int tailleChemin)
    {
        this.tailleChemin = tailleChemin;
        chemin = new Chemin(tailleChemin);

        joueur1 = new Player(10, 0, (short)1,this);
        joueur2 = new Player(10, tailleChemin -1, (short)2, this);

    /*    Main.logger.info("joueur 1 : " + joueur1.toString());
        Main.logger.info("joueur 2 : " + joueur2.toString());*/
        troll = new Troll(chemin);

        gameState = GameState.BEGIN;

        while(gameState == GameState.BEGIN)
        {

            chemin.afficherChemin();

            System.out.println("------------DEFINITION DES STRATEGIES------------");

            joueur1.setPlayerStrategy(new DumbStrat());
            joueur2.setPlayerStrategy(new PrudenteStrat());

            System.out.println("------------CONFRONTATION DES STRATEGIES------------");

            strategySolver.solve(joueur1,joueur2);

            chemin.afficherChemin();


        }

        gameOver();







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

    public int getTailleChemin() {
        return tailleChemin;
    }

    public void gameOver()
    {
        System.out.println("la partie est finie !");
        if(gameState == GameState.PLAYER_ONE_NO_MORE_ROCKS)
        {
            System.out.println("Le joueur 1 n'a plus de pierres à lancer !");
        }
        else if(gameState == GameState.PLAYER_TWO_NO_MORE_ROCKS)
        {
            System.out.println("Le joueur 1 n'a plus de pierres à lancer !");
        }

    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

}
