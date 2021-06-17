package Strategies;

import Entities.Player;

public class PrudenteStrat implements IStrategy{

    @Override
    public int apply(Player player) {
        int currentStockPierre = player.getStockPierre();
        return 0;
    }
}
