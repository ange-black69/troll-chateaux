package common;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{


    /**
     * common.Game représentant la class principale du jeu.
     */
    private static Game game;

    private static int nombreDePartie;

    public static Logger logger = Logger.getLogger("troll");

    private static File outputFile;

    public static FileWriter fileWriter;

    /**
     * Compteur de victoire
     */
    public static int player1WinCounter, player2WinCounter, drawCounter;

    public static void main (String[] args)
    {

        outputFile = new File(Main.class.getResource("").getPath());
        try {
            fileWriter = new FileWriter("game_result.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Veuillez entrer le nombre de partie");
        Scanner sc = new Scanner(System.in);
        try
        {
         nombreDePartie = sc.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("VEUILLEZ ENTRER UN ENTIER !");
            System.exit(-1);
        }

        if(nombreDePartie <= 0)
        {
            System.out.println("Le nombre de partie ne peut pas etre nul ou négatif !-");
            System.exit(-1);
        }

        for(int i = 1; i <= nombreDePartie; i++)
        {
            System.out.println("");
            System.out.println("numéro de partie : " + i);

           /* try {
                fileWriter.write("Numéro de partie : "+ i + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            game = new Game(7, 20);
        }

        try {
            fileWriter.write("nombre total de parties : " + nombreDePartie + "\n");
            fileWriter.write("nombre de victoire du J1 : " + player1WinCounter + "\n");
            fileWriter.write("nombre de victoire du J2 : " + player2WinCounter + "\n");
            fileWriter.write("nombre de de match nul : " + drawCounter + "\n");
            fileWriter.write("------------------------------- " + "\n");

            fileWriter.write("Pourcentage de victoire du joueur 1 : " + (float)(((float)player1WinCounter / (float)nombreDePartie) * 100) + "% " + "\n");
            fileWriter.write("Pourcentage de victoire du joueur 2  : " +  (float)(((float)player2WinCounter / (float)nombreDePartie) * 100) +"% " + "\n");
            fileWriter.write("Pourcentage de match nul  : " + (float)(((float)drawCounter / (float)nombreDePartie) * 100) +"% " + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
