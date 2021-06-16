package Entities;

import common.Main;

public class Chemin
{
    private Case[] cases;

    public Chemin(int nombreCases)
    {
        cases = new Case[nombreCases];

        for(int i = 0; i < nombreCases; i++)
        {
            // Création des cases du chemin avec les différents indices
            cases[i] = (new EmptyCase(i));
        }
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

    public void changeCasePosition(int indiceDepart, int indiceArrivee)
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
            cases[indiceArrivee] = case_depart;
            cases[indiceDepart] = case_arrivée;
        }
        /*
        La case d'arrivée est un joueur
         */
        else if (case_arrivée instanceof Player)
        {

        }
    }

    public void afficherChemin()
    {
        StringBuilder sb = new StringBuilder();
        for(Case c : this.getCasesList())
        {
            if(c instanceof Player)
            {
                sb.append("J");
            }
            if(c instanceof Troll)
            {
                sb.append("T");
            }
            if(c instanceof EmptyCase)
            {
                sb.append("C");
            }


        }

        System.out.println("---- Affichage du chemin ----");
        System.out.println(sb.toString());

    }

}
