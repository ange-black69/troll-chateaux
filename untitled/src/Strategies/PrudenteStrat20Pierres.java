package Strategies;

import Entities.Player;
import common.Game;

import java.util.LinkedList;
/**
 * Une stratégie prudente
 * 4 6 4 4 2 car il y a seulement deux configurations de défaite possible dans le cas :
 * 10 pierres; 7 cases
 * */
public class PrudenteStrat20Pierres implements IStrategy{

    private LinkedList<Integer> listeDesCoups = new LinkedList<Integer>();

    public PrudenteStrat20Pierres()
    {
        listeDesCoups.add(4);
        listeDesCoups.add(6);
        listeDesCoups.add(4);
        listeDesCoups.add(4);
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
