package common;

import Entities.Chemin;
import Entities.Player;
import Entities.Troll;
import Strategies.DumbStrat;
import Strategies.PrudenteStrat;
import Strategies.RandomStrat;
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
        System.out.println("--------- INITIALISATION DE BASE ---------");

        chemin = new Chemin(this,tailleChemin);
        joueur1 = new Player(10, 0, (short)1,this);
        joueur2 = new Player(10, tailleChemin -1, (short)2, this);
        troll = new Troll(chemin);

        System.out.println(chemin.toString());
        System.out.println(joueur1.toString());
        System.out.println(joueur2.toString());
        System.out.println(troll.toString());

        gameState = GameState.BEGIN;

        while(gameState == GameState.BEGIN)
        {

            chemin.afficherChemin();

            System.out.println("------------DEFINITION DES STRATEGIES------------");

            joueur1.setPlayerStrategy(new RandomStrat());
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
        System.out.println("la partie est finie ! gamestate : " + gameState);
        if(gameState == GameState.PLAYER_ONE_WIN)
        {
            System.out.println("Le joueur 1 gagne !");
            return;
        }
        if(gameState == GameState.PLAYER_TWO_WIN)
        {
            System.out.println("Le joueur 2 gagne !");
            return;
        }
        if(gameState == GameState.DRAW)
        {
            System.out.println("Match nul !");
        }

    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

}
