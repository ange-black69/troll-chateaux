package Strategies;

import Entities.Player;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStrat implements IStrategy{
    @Override
    public int apply(Player player) {

        int pierreALancer = 0;

        if(player.getStockPierre() <= 1)
        {
            pierreALancer = 1;
        }
        else
        {
            // On génére un nombre aléatoire de pierre à lancer entre 1 et le nombre de pierre disponible
            pierreALancer = ThreadLocalRandom.current().nextInt(1,player.getStockPierre());
        }

        if(player.lancerPierres(pierreALancer))
        {
            System.out.println("[RandomStat] appliqué à " +  player.toString());
            return pierreALancer;
        }

        return 0;
    }
}
