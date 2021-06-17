package common;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{


    /**
     * common.Game représentant la class principale du jeu
     */
    private static Game game;

    public static Logger logger = Logger.getLogger("troll");

    public static void main (String[] args)
    {
        logger.log(Level.INFO, "Lancement du jeu du troll avec un chemin de taille 7");

        game = new Game(7, 10);

    }
}
