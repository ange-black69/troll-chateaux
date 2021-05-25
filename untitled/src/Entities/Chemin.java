package Entities;

public class Chemin
{
    private Case[] cases;

    public Chemin(int nombreCases)
    {
        cases = new Case[nombreCases];

        for(int i = 0; i < cases.length; i++)
        {
            // Création des cases du chemin avec les différents indices
            cases[i] = new Case(i);
        }
    }
}
