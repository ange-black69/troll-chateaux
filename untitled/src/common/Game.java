package common;

import Entities.Chemin;
import Entities.Player;
import Entities.Troll;
import Strategies.*;

/**
 * Class représentant notre jeu avec des instances des joueurs, de troll, de chemin et d'un agrégateur des
 * stratégies.
 */
public class Game {

    private Troll troll;
    private Chemin chemin;
    private Player joueur1;
    private Player joueur2;


    GameState gameState;

    private final StrategySolver strategySolver = new StrategySolver(this);

    private int tailleChemin;
    private int nombreDePierresDepart;

    /**
     * Construit un jeu avec la taille de chemin (nombre de cases) et le nombre de pierres que possède chaque joueurs
     * au début de la partie
     * @param tailleChemin : nombre de cases composant le chemin.
     * @param nombreDePierresDepart : nombre de pierres dans le stock des joueurs.
     */
    public Game(int tailleChemin, int nombreDePierresDepart)
    {
        this.tailleChemin = tailleChemin;
        this.nombreDePierresDepart = nombreDePierresDepart;

        System.out.println("--------- INITIALISATION DE BASE ---------");

        chemin = new Chemin(this,tailleChemin);
        joueur1 = new Player(nombreDePierresDepart, 0, (short)1,this);
        joueur2 = new Player(nombreDePierresDepart, tailleChemin -1, (short)2, this);

        //Construit notre troll à mi-chemin des deux joueurs
        troll = new Troll(chemin,chemin.getCasesList().length / 2);

        System.out.println(chemin.toString());
        System.out.println(joueur1.toString());
        System.out.println(joueur2.toString());
        System.out.println(troll.toString());

        gameState = GameState.BEGIN;

        System.out.println("------------DEFINITION DES STRATEGIES------------");

        /*
        Comme nous ne sommes pas en stratégie mixte, on définit la stratégie de chaque joueur une fois pour toute.
        On aurait pu placer ces deux lignes dans notre while si nous voulions faire en sorte qu'a chaque tour, un
        joueur ait la possibilité de changer de stratégie.
         */
        joueur1.setPlayerStrategy(new PrudenteStrat());
        joueur2.setPlayerStrategy(new PrudenteStrat());

        while(gameState == GameState.BEGIN)
        {

            chemin.afficherChemin();

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
        if(gameState == GameState.PLAYER_ONE_WIN || gameState == GameState.TROLL_ON_PLAYER_TWO)
        {
            System.out.println("Le joueur 1 gagne !");
            return;
        }
        if(gameState == GameState.PLAYER_TWO_WIN || gameState == GameState.TROLL_ON_PLAYER_ONE)
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
