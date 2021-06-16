package Entities;

public class Troll extends Case{

    Chemin chemin;
    public Troll(Chemin chemin)
    {
        super(chemin.getCasesList().length / 2);
        this.chemin = chemin;
        // On met le troll a la position central du chemin
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
        chemin.changeCasePosition(getIndice(), getIndice()-1);
    }

    /**
     * Déplacement du troll vers le joueur 2
     */
    public void deplacerVersJoueur2()
    {
        chemin.changeCasePosition(getIndice(), getIndice()+1);
    }
}
