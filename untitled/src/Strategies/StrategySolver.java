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
     * Les stratégies nous retournent le nombre de pierres lancées
     * @param p1 : Player
     * @param p2 : Player
     */
    public void solve(Player p1, Player p2)
    {
        int result_s1 = p1.applyStrategy();
        int result_s2 = p2.applyStrategy();

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
            } else if(result_s1 < result_s2){
                System.out.println("la stratégie du joueur 2 est gagnante sur le joueur 1 !");
                game.getTroll().deplacerVersJoueur1();
            }

            /*Si le joueur 1 n'a plus de pierre, on verifie la position du troll, et on l'avance que si un des deux
            joueurs n'a pas perdu !
             */
            if(p1.getStockPierre() == 0 && game.getGameState() == GameState.BEGIN)
            {
                handlePlayer1NoMoreRocks(p1, p2);
                return;
            }
            /*Si le joueur 2 n'a plus de pierre, on verifie la position du troll, et on l'avance que si un des deux
            joueurs n'a pas perdu !
             */
            if(p2.getStockPierre() == 0 && game.getGameState() == GameState.BEGIN)
            {
                handlePlayer2NoMoreRocks(p1, p2);
                return;
            }

    }

    /**
     * Fonction permettant de gérer le cas ou le joueur 1 n'a plus de pierre.
     * On va appliquer ce que nous dit le sujet : on deplace le troll le nombre de fois qu'il reste de pierres aux
     * joueur 2
     * @param p1 Player
     * @param p2 Player
     */
    private void handlePlayer1NoMoreRocks(Player p1, Player p2)
    {
        System.out.println("[StrategySolver] La partie est terminée car le joueur 1 n'a plus de pierre !");
        System.out.println("[StrategySolver] le joueur 2 possède encore " + p2.getStockPierre() + "pierres ");
        System.out.println("[StrategySolver] le troll bouge donc de " + p2.getStockPierre()
                + " cases en direction du joueur 1 !");

        // On déplace le troll d'autant de pierre(s) qu'il reste au joueur 2
        for(int i = 0; i < p2.getStockPierre(); i++)
        {
            game.getTroll().deplacerVersJoueur1();
        }

                /*
                Si le troll n'a pas atteint le chateau d'un des joueurs, on calcule la distance entre le troll et le
                chateau
                 */
        int trollPos = game.getTroll().getIndice();
        int playerOnePos = p1.getIndice();
        int playerTwopos = p2.getIndice();

        // Le troll est a la meme distance des deux joueurs, match nul !
        if((Math.abs(trollPos - playerOnePos)) == Math.abs(trollPos - playerTwopos))
        {
            game.setGameState(GameState.DRAW);
        }
        // Le troll est plus proche du joueur 1 !
        else if((Math.abs(trollPos - playerOnePos)) < Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 2 gagne !
            game.setGameState(GameState.PLAYER_TWO_WIN);
        }
        // Le troll est plus proche du joueur 2 !
        else if ((Math.abs(trollPos - playerOnePos)) > Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 1 gagne !
            game.setGameState(GameState.PLAYER_ONE_WIN);

        }
    }
    /**
     * Fonction permettant de gérer le cas ou le joueur 2 n'a plus de pierre.
     * On va appliquer ce que nous dit le sujet : on deplace le troll le nombre de fois qu'il reste de pierres aux
     * joueur 1
     * @param p1 : Player
     * @param p2 : Player
     */
    private void handlePlayer2NoMoreRocks(Player p1, Player p2)
    {
        System.out.println("[StrategySolver] La partie est terminée car le joueur 2 n'a plus de pierre !");
        System.out.println("[StrategySolver] le joueur 1 possède encore " + p1.getStockPierre() + "pierres ");
        System.out.println("[StrategySolver] le troll bouge donc de " + p1.getStockPierre()
                + " cases en direction du joueur 2 !");

        // On déplace le troll d'autant de pierre(s) qu'il reste au joueur 1
        for(int i = 0; i < p1.getStockPierre(); i++)
        {
            game.getTroll().deplacerVersJoueur2();
        }

                /*
                Si le troll n'a pas atteint le chateau d'un des joueurs, on calcule la distance entre le troll et le
                chateau
                 */
        int trollPos = game.getTroll().getIndice();
        int playerOnePos = p1.getIndice();
        int playerTwopos = p2.getIndice();

        // Le troll est a la meme distance des deux joueurs, match nul !
        if((Math.abs(trollPos - playerOnePos)) == Math.abs(trollPos - playerTwopos))
        {
            game.setGameState(GameState.DRAW);
        }
        // Le troll est plus proche du joueur 1 !
        else if((Math.abs(trollPos - playerOnePos)) < Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 2 gagne !
            game.setGameState(GameState.PLAYER_TWO_WIN);
        }
        // Le troll est plus proche du joueur 2 !
        else if ((Math.abs(trollPos - playerOnePos)) > Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 1 gagne !
            game.setGameState(GameState.PLAYER_ONE_WIN);

        }
    }


}
