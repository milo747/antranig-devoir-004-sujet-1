package juin2021.exo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Inventaire {
    public static final int POIDS_MAXIMAL = 200;

    private HashMap<Item, Integer> contenuMap = new HashMap<>();

    /**
     * Ajoute un certain nombre d'unités d'un item donné dans l'inventaire. Si
     * l'item est déjà présent, la quantité de l'item est augmentée. Par exemple, si
     * j'ajoute 2 unités de "pomme", et qu'il y en a déjà 3 dans l'inventaire, il y
     * en aura 5 au total.
     * 
     * Si l'ajout fait dépasser strictement le poids maximal de 200, l'ajout ne doit
     * pas être effectué (l'inventaire reste inchangé) et la méthode doit renvoyer
     * false.
     * 
     * @param item
     * @param quantite
     * @return true si l'ajout a été effectué.
     */
    public boolean ajouter(Item item, int quantite) 
    {
    	Integer quantiteItem =	contenuMap.get(item);
    	int ajout=0;
    	// test si l'objet est déjà présent dans l'inventaire
    	ajout = ( quantiteItem != null) ?  quantiteItem + quantite : quantite;
    	
    	if(getPoidsTotal() + quantite*item.getPoids() <= Inventaire.POIDS_MAXIMAL)
    		{
    			this.contenuMap.put(item, ajout);
    			return true;
    		}
    	return false;
    }

    /**
     * Retire une certaine quantité d'items dans l'inventaire. Si la quantité
     * retirée est plus importante que la quantité disponible, lève une
     * InventaireException.
     */
    public void retirer(Item item, int quantite) {
        if (quantite == 0)
            return;
        int quantiteActuelle = getQuantite(item);
        if (quantite > quantiteActuelle)
            throw new InventaireException();
        if (quantite == quantiteActuelle)
            contenuMap.remove(item);
        else
            contenuMap.put(item, quantiteActuelle - quantite);
    }

    /**
     * Retourne tous les items présents dans l'inventaire
     */
    public Set<Item> getContenu() {
        return new HashSet<>(contenuMap.keySet());
    }

    /**
     * Retourne la quantité d'un item dans l'inventaire ou 0 s'il n'est pas présent.
     * 
     * @param item
     * @return
     */
    public int getQuantite(Item item) {
        return contenuMap.getOrDefault(item, 0);
    }

    /**
     * Retourne le poids total des items transportés.
     * 
     * @return
     */
    public int getPoidsTotal() {
    	int poids=0;
    	for( Item itm : this.getContenu() )
    		poids += this.getQuantite( itm )*itm.getPoids();
    	
    	return poids;
    }
}
