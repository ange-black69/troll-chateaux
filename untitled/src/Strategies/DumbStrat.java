package Strategies;

import Entities.Player;

/**
 * Stratégie stupide ou le joueur lance toutes ses pierres
 */
public class DumbStrat implements IStrategy{

    @Override
    public int apply(Player player) {
        int currentStockPierre = player.getStockPierre();
        if(player.lancerPierres(currentStockPierre))
        {
            System.out.println("[DumbStrat] appliqué à " +  player.toString());
            return currentStockPierre;
        }

        return 0;


    }
}
