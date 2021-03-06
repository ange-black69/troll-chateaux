package Strategies;

import Entities.Player;
import common.Game;

import java.util.*;

/**
 * Stratégie contrant la stratégie prudente optimale.
 * 3 4 3
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
    public int apply(Game game, Player player, boolean simulate) {

        if(listeDesCoups.isEmpty())
        {
            return 0;
        }

        int pierreAlancer = listeDesCoups.removeFirst();

        if(!simulate)
        {
            if(player.lancerPierres(pierreAlancer))
            {
                return pierreAlancer;
            }
        }
        else
        {
            if(player.simulateLancerPierres(pierreAlancer))
            {
                return pierreAlancer;
            }
        }

        return 0;
    }
}
