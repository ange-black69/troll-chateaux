package Strategies;

import Entities.Player;
import common.Game;

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
        listeDesCoups.add(1);
        listeDesCoups.add(1);
        listeDesCoups.add(2);
        listeDesCoups.add(2);
        listeDesCoups.add(2);
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
