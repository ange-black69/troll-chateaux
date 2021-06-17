package Strategies;

import Entities.Player;

import java.util.Random;

public class RandomStrat implements IStrategy{
    @Override
    public int apply(Player player) {

        Random random = new Random();
        int pierreALancer = random.nextInt(player.getStockPierre());

        if(player.lancerPierres(pierreALancer))
        {
            System.out.println("[RandomStat] appliqué à " +  player.toString());
            return pierreALancer;
        }

        return 0;
    }
}
