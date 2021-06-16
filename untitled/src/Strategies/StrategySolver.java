package Strategies;

import Entities.Player;
import common.Game;

import javax.jws.WebService;

/**
 * Class permettant de résoudre l'affrontement entre deux stratégies
 * différentes.
 */
public class StrategySolver {

    Game game;

    /**
     *
     * @param game
     */
    public StrategySolver(Game game)
    {
        this.game = game;
    }

    /**
     * Calcul le résultat de l'application des deux stratégies des Joueurs.
     * @param p1 : Player
     * @param p2 : Player
     */
    public void solve(Player p1, Player p2)
    {
        int result_s1 = p1.applyStrategy();
        int result_s2 = p2.applyStrategy();

        /*
        Si le joueur 1 a envoyé plus de pierres,
        alors le troll va en direction du joueur 2.
         */
        if(result_s1 > result_s2)
        {
            game.getTroll().deplacerVersJoueur2();
        }
        else
        {
            game.getTroll().deplacerVersJoueur1();
        }

    }


}
