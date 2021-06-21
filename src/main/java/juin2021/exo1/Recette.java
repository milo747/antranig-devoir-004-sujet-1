package juin2021.exo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class Recette {
    private HashMap<Item,Integer> ingredients;
    private Item resultat;

    /**
     * Crée un objet recette qui construira un Item du type résultat
     * @param resultat : l'objet construit par la recette.
     */
    public Recette(Item resultat) {
        this.resultat = resultat;
        this.ingredients = new HashMap<>();
    }

    /**
     * Fixe un ingrédient nécessaire à la recette et sa quantité.
     * @param ingredient
     * @param quantite
     */
    public void setIngredient(Item ingredient, int quantite) {
        ingredients.put(ingredient, quantite);
    }

    public Item getResultat() {
        return resultat;
    }

    public Set<Item> getIngredients() {
        return new HashSet<>(ingredients.keySet()); 
    }

    public int getQuantite(Item item) {
        return ingredients.getOrDefault(item, 0);
    }


    /**
     * Applique la recette (à écrire !!!)
     */
    public boolean appliquer(Inventaire inventaire) {
        throw new RuntimeException("à écrire");
    }
    
}
