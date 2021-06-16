package Strategies;

import Entities.Player;

/**
 * Stratégie stupide ou le joueur lance toutes ses pierres
 */
public class DumbStrat implements IStrategy{

    @Override
    public int apply(Player player) {
        player.lancerPierres(1);
        return 1;
    }
}
