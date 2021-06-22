package Strategies;

import Entities.Player;
import common.Game;

import java.util.concurrent.ThreadLocalRandom;

public class RandomJoueur2Strat implements IStrategy{
    @Override
    public int apply(Game game, Player player, boolean simulate) {

        int pierreALancer = 0;

        if(player.getStockPierre() <= 1)
        {
            pierreALancer = 1;
        }
        else
        {
            // On génére un nombre aléatoire de pierre à lancer entre 1 et le nombre de pierre disponible
            pierreALancer = ThreadLocalRandom.current().nextInt(1,player.getStockPierre()/3);
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
