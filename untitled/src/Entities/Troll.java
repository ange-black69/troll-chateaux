package Entities;

public class Troll extends Case{

    public Troll(Chemin chemin)
    {
        // On met le troll a la position central du chemin
        super(chemin.getCasesList().length / 2);
        chemin.getCasesList()[this.getIndice()] = this;
    }


    @Override
    public String toString() {
        return "Troll{" +
                "positionCase=" + getIndice() +
                '}';
    }


    /**
     * Déplacement du troll vers le joueur 1
     */
    public void deplacerVersJoueur1()
    {
        setIndice(getIndice()-1);
    }

    /**
     * Déplacement du troll vers le joueur 2
     */
    public void deplacerVersJoueur2()
    {
        setIndice(getIndice()+1);
    }
}
