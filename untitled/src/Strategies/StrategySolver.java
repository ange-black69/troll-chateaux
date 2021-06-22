package Strategies;

import Entities.Player;
import common.Game;
import common.GameState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class permettant de résoudre l'affrontement entre deux stratégies
 * différentes.
 */
public class StrategySolver {

    private final Game game;

    private List<IStrategy> strategyList;
    private List<Integer> t;

    /**
     *
     * @param game
     */
    public StrategySolver(Game game)
    {
        this.game = game;
        this.strategyList = new ArrayList<IStrategy>();
    }

    /**
     * Methode permetant de simuler une stratégie d'un joueur en fonction de l'état du jeu actuel.
     */
    public void simulateStrategy(Player player)
    {
        List<Integer> t = new ArrayList<>();
        // copie du joueur
        Player temp = new Player(player.getStockPierre(),player.getIndice(),player.getPlayerNumber(),game);

        temp.setPlayerStrategy(new CounterOptimalStrat());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new CounterOptimalStrat2());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new DumbStrat());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new PrudenteStrat());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new PrudenteStrat20Pierres());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new RandomStrat());
        t.add(temp.getPlayerStrategy().apply(game,temp, true));
        temp.setPlayerStrategy(new RandomJoueur2Strat());

        Collections.sort(t);

        System.out.println("t : " + t.toString());

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
                Player.handlePlayer1NoMoreRocks(p1, p2, game);
                return;
            }
            /*Si le joueur 2 n'a plus de pierre, on verifie la position du troll, et on l'avance que si un des deux
            joueurs n'a pas perdu !
             */
            if(p2.getStockPierre() == 0 && game.getGameState() == GameState.BEGIN)
            {
                Player.handlePlayer2NoMoreRocks(p1, p2,game);
                return;
            }

    }




}
