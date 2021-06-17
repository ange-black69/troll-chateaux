package Strategies;

import Entities.Player;
import common.Game;
import common.GameState;

/**
 * Class permettant de résoudre l'affrontement entre deux stratégies
 * différentes.
 */
public class StrategySolver {

    private final Game game;

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

        // Si on joue toujours !
        if(game.getGameState() == GameState.BEGIN) {
        /*
        Les deux joueurs ont envoyés le meme nombre de pierres.
        Egalité !
         */
            if (result_s1 == result_s2) {
                System.out.println("les deux joueurs ont envoyé le meme nombre de pierre, le troll ne bouge pas");
                return;
            }
        /*
        Si le joueur 1 a envoyé plus de pierres,
        alors le troll va en direction du joueur 2.
         */
            if (result_s1 > result_s2) {
                System.out.println("la stratégie du joueur 1 est gagnante sur le joueur 2 !");
                game.getTroll().deplacerVersJoueur2();
            } else {
                System.out.println("la stratégie du joueur 2 est gagnante sur le joueur 1 !");
                game.getTroll().deplacerVersJoueur1();
            }
        }
        // La partie est terminée pour x ou y raisons
        else
        {
            /*
            Un des deux joueurs n'a plus de pierres à lancer !
             */
            if(game.getGameState() == GameState.PLAYER_ONE_NO_MORE_ROCKS
                    || game.getGameState() == GameState.PLAYER_TWO_NO_MORE_ROCKS)
            {
                System.out.println("[StrategySolver] La partie est terminée car un des deux joueurs " +
                        "n'a plus de pierres !");

                // On va calculer la "distance" la plus proche entre le troll et un des joueurs

                int trollPos = game.getTroll().getIndice();
                int playerOnePos = p1.getIndice();
                int playerTwopos = p2.getIndice();

                // Le troll est a la meme distance des deux joueurs, match nul !
                if((Math.abs(trollPos - playerOnePos)) == (trollPos - playerTwopos))
                {
                    game.setGameState(GameState.DRAW);
                }
                // Le troll est plus proche du joueur 1 !
                else if((Math.abs(trollPos - playerOnePos)) < (trollPos - playerTwopos))
                {
                    // Le joueur 2 gagne !
                    game.setGameState(GameState.PLAYER_TWO_WIN);
                }
                // Le troll est plus proche du joueur 2 !
                else if ((Math.abs(trollPos - playerOnePos)) > (trollPos - playerTwopos))
                {
                    // Le joueur 1 gagne !
                    game.setGameState(GameState.PLAYER_ONE_WIN);

                }

            }

        }

    }


}
