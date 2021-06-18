package Entities;

import common.Game;
import common.GameState;
import common.Main;

public class Chemin
{
    private Case[] cases;
    private final Game game;

    public Chemin(Game game, int nombreCases)
    {
        cases = new Case[nombreCases];

        for(int i = 0; i < nombreCases; i++)
        {
            // Création des cases du chemin avec les différents indices
            cases[i] = (new EmptyCase(i));
        }
        this.game = game;
    }

    public Case[] getCasesList()
    {
        return cases;
    }

    @Override
    public String toString() {
        return "Chemin{" +
                "cases=" + cases +
                "cases count : " + cases.length +
                '}';
    }

    /**
     * Permute la position de deux cases de notre chemin
     * Essentiellement pour bouger la position du troll;
     * @param indiceDepart
     * @param indiceArrivee
     */
    public void deplacerTroll(int indiceDepart, int indiceArrivee)
    {
        if(indiceDepart == indiceArrivee)
        {
            Main.logger.severe("indice de départ = indice d'arrivée !!");
            return;
        }
        Case case_depart = cases[indiceDepart];
        Case case_arrivée = cases[indiceArrivee];

        if(case_depart == null || case_arrivée == null)
        {
            Main.logger.severe("case de depart ou d'arrivée null !");
            return;
        }
        if(case_arrivée instanceof EmptyCase)
        {
            /**
             * On permutte les cases d'arrivées et de départ de notre tableau
             * de cases
             */
            cases[indiceArrivee] = case_depart;
            cases[indiceDepart] = case_arrivée;
            //On oublie pas de définir les nouveaux indices des cases !
            case_depart.setIndice(indiceArrivee);
            case_arrivée.setIndice(indiceDepart);
        }
        /*
        La case d'arrivée est un joueur
         */
        else if (case_arrivée instanceof Player)
        {
            // On va récuperer le joueur en question
            Player p = (Player)case_arrivée;
            if(p == null) {return;}

            if(p.playerNumber == 1)
            {
            // Le joueur I a perdu
                game.setGameState(GameState.TROLL_ON_PLAYER_ONE);
                return;

            }
            if(p.playerNumber == 2)
            {
                // Le joueur II a perdu !
                game.setGameState(GameState.TROLL_ON_PLAYER_TWO);
                return;
            }

            return;
        }
    }

    public void afficherChemin()
    {
        StringBuilder sb = new StringBuilder();

        sb.append('|');
        for(Case c : this.getCasesList())
        {
            if(c instanceof Player)
            {
                Player p = (Player)c;
                if(p.playerNumber == 1)
                {
                    sb.append("J1-");
                }
                else
                {
                    sb.append("-J2");
                }

            }
            if(c instanceof Troll)
            {
                sb.append("-T-");
            }
            if(c instanceof EmptyCase)
            {
                sb.append("-C-");
            }


        }
        sb.append('|');
        System.out.println(sb.toString());

    }

}
