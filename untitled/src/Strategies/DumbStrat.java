package Strategies;

import Entities.Player;
import common.Game;

/**
 * Stratégie stupide ou le joueur lance toutes ses pierres
 */
public class DumbStrat implements IStrategy{

    @Override
    public int apply(Game game, Player player, boolean simulate) {
        int currentStockPierre = player.getStockPierre();



        if(!simulate)
        {
            if(player.lancerPierres(currentStockPierre))
            {
                return currentStockPierre;
            }
        }
        else
        {
            if(player.simulateLancerPierres(currentStockPierre))
            {
                return currentStockPierre;
            }
        }
        return 0;


    }
}
