package Strategies;

import Entities.Player;

import java.util.*;

/**
 * Stratégie contrant la stratégie prudente optimale.
 * 3 3 3 1
 * 10 pierres; 7 cases
 * */
public class CounterOptimalStrat2 implements IStrategy{

    private static LinkedList<Integer> listeDesCoups = new LinkedList<Integer>();

    public CounterOptimalStrat2()
    {
        listeDesCoups.add(3);
        listeDesCoups.add(3);
        listeDesCoups.add(3);
        listeDesCoups.add(1);
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
