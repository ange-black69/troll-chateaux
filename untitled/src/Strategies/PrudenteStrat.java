package Strategies;

import Entities.Player;
import common.Game;

import java.util.*;

/**
 * Stratégie prudente optimale pour un joueur est de jouer
 * 2 3 2 2 1 car il y a seulement deux configurations de défaite possible dans le cas :
 * 10 pierres; 7 cases
 * */
public class PrudenteStrat implements IStrategy{

    private LinkedList<Integer> listeDesCoups = new LinkedList<Integer>();

    public PrudenteStrat()
    {
        listeDesCoups.add(2);
        listeDesCoups.add(3);
        listeDesCoups.add(2);
        listeDesCoups.add(2);
        listeDesCoups.add(1);
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
