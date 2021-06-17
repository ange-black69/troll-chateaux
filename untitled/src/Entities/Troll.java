package Entities;

public class Troll extends Case{

    Chemin chemin;

    /**
     * Construit notre Troll à la position dans notre chemin
     * @param chemin
     * @param posIndice
     */
    public Troll(Chemin chemin, int posIndice)
    {
        super(posIndice);
        this.chemin = chemin;
        // On met le troll a la position central du chemin
        chemin.getCasesList()[this.getIndice()] = this;
    }


    @Override
    public String toString() {
        return "Troll{" +
                "indice =" + getIndice() +
                '}';
    }


    /**
     * Déplacement du troll vers le joueur 1
     */
    public void deplacerVersJoueur1()
    {
        chemin.deplacerTroll(getIndice(), getIndice()-1);
        System.out.println("le troll se déplace vers le joueur 1 !");
        System.out.println(toString());
    }

    /**
     * Déplacement du troll vers le joueur 2
     */
    public void deplacerVersJoueur2()
    {
        chemin.deplacerTroll(getIndice(), getIndice()+1);
        System.out.println("le troll se déplace vers le joueur 2 !");
        System.out.println(toString());
    }
}
