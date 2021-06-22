package Strategies;

import Entities.Player;
import common.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Question 3 b
 * Stratégie permetant de contrer a coup sur la stratégie @{@link RandomJoueur2Strat}
 */
public class CounterRandomJoueur2Strat implements IStrategy{

    int stockOtherPlayer;
    float tiersStock;

    List<Integer>  lancerPossible;

    @Override
    public int apply(Game game, Player player, boolean simulate) {

        int pierreALancer = 0;

        lancerPossible = new ArrayList<>();

        if(player.getStockPierre() <= 1)
        {
            pierreALancer = 1;
        }
        else
        {
            // C'est le joueur 1, on recup le stock du joueur 2
            if(player.getPlayerNumber() == 1)
            {
                stockOtherPlayer = game.getJoueur2().getStockPierre();
            }
            // C'est le joueur 2, on recup le stock du joueur 1
            else
            {
                stockOtherPlayer = game.getJoueur1().getStockPierre();
            }

            tiersStock = 0.33f * player.getStockPierre();

            if(stockOtherPlayer >= tiersStock)
            {
                lancerPossible.add((int)tiersStock);

                for(int i = 0; i < player.getStockPierre(); i++)
                {
                    lancerPossible.add((int)(tiersStock)-i);
                }

            }
            else if(stockOtherPlayer == 1)
            {
                lancerPossible.add(1);
            }

            // Calcul de la moyenne des lancer possibles
            double moyenne = lancerPossible.stream().mapToDouble(d -> d).average().orElse(0.0);

            // Petit tricks
            moyenne = moyenne+1;
            
            // On lance le nombre de pierre equivalent a la moyenne calculé avant
            pierreALancer = (int)moyenne;
        }


        if(!simulate)
        {
            if(player.lancerPierres(pierreALancer))
            {
                System.out.println("[RandomJoueur2Strat] appliqué au joueur 2 ");
                return pierreALancer;
            }
        }
        else
        {
            if(player.simulateLancerPierres(pierreALancer))
            {
                return pierreALancer;
            }
        }


        return 0;
    }
}
