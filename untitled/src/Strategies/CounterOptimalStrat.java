package Strategies;

import Entities.Player;

import java.util.*;

/**
 * Stratégie contrant la stratégie prudente optimale.
 * 3 3 3 1
 * 10 pierres; 7 cases
 * */
public class CounterOptimalStrat implements IStrategy{

    private static LinkedList<Integer> listeDesCoups = new LinkedList<Integer>();

    public CounterOptimalStrat()
    {
        listeDesCoups.add(3);
        listeDesCoups.add(4);
        listeDesCoups.add(3);
    }

    @Override
    public int apply(Player player) {

        if(listeDesCoups.isEmpty())
        {
            return 0;
        }

        int pierreAlancer = listeDesCoups.removeFirst();

        if(player.lancerPierres(pierreAlancer))
        {
            return pierreAlancer;
        }
        return 0;
    }
}
