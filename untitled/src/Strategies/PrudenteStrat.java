package Strategies;

import Entities.Player;

public class PrudenteStrat implements IStrategy{

    @Override
    public int apply(Player player) {
        if(player.lancerPierres(1))
        {
            System.out.println("[PrudenteStrat] appliqué à " +  player.toString());
            return 1;
        }

        return 0;
    }
}
