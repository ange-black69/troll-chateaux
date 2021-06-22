package Strategies;

import Entities.Player;
import common.Game;

public interface IStrategy
{
    /**
     * Applique la stratégie
     * @param player
     * @param simulate : si on simule ou pas
     * @return le nombre de pierre lancées
     */
    public int apply(Game game, Player player, boolean simulate);
}
