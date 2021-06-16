package Strategies;

import Entities.Player;

public interface IStrategy
{
    /**
     * Applique la stratégie
     * @param player
     * @return le nombre de pierre lancées
     */
    public int apply(Player player);
}
