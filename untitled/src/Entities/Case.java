package Entities;

public class Case {

    /**
     * La position de la case en terme d'indice de tableau
     */
    int indice;

    public Case(int indice)
    {
        this.indice = indice;
    }

    public int getIndice()
    {
        return this.indice;
    }

    public void setIndice(int indice)
    {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Case{" +
                "indice=" + indice +
                '}';
    }
}
