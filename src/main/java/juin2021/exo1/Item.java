package juin2021.exo1;

public class Item {
    private String nom;
    private int poids;

    public Item(String nom, int poids) {
        this.nom = nom;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public int getPoids() {
        return poids;
    }
}
