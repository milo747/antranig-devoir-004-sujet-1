package juin2021.exo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




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
     * Applique la recette.
     * Si tous les ingrédients sont disponible en quantité suffisante dans l'inventaire. 
     * On retire les ingrédients utilisés par la recette de l'inventaire puis on ajoute l'objet
     * créé par la recette dans l'inventaire. 
     * On considère que le poids total de l'inventaire après la recette ne peut que etre égale 
     * ou inferieur au poids d'avant la recette. Dans le cas contraire et si il n'y a pas la place 
     * de stocker l'objet fabriqué. Les ingrédients utilisés pour la recette sont perdus.
     * @param inventaire
     */
    
    
    public boolean appliquer(Inventaire inventaire) {
      //vérifier qu'il y a les ingrédients nécéssaires dans l'inventaire
        for( Map.Entry<Item, Integer> entry : this.ingredients.entrySet() ) {
        	if(inventaire.getQuantite( entry.getKey() ) < entry.getValue())
        		return false;
        }
        
      //modifier l'inventaire en retirant les ingrédients
        for( Map.Entry<Item, Integer> entry : this.ingredients.entrySet() ) 
        	inventaire.retirer( entry.getKey(), entry.getValue() );
        
        inventaire.ajouter(this.resultat, 1);
        return true;
    }
    
}
