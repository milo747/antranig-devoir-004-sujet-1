package juin2021.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class TestExo1 {
    

    @Test
    public void testPoidsTotal() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        Item item2 = new Item("or", 1);
        inv.ajouter(item1, 4);
        inv.ajouter(item2, 1);
        assertEquals(21, inv.getPoidsTotal());
    }
    
    @Test
    public void testDepassePoids() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        Item item2 = new Item("or", 1);
        //inv.ajouter(item2, 201);
        inv.ajouter(item2, 195);
        inv.ajouter(item1, 1);
        inv.ajouter(item1, 1);
        assertEquals(1, inv.getQuantite(item1));
        assertEquals(200, inv.getPoidsTotal());
    }

    @Test
    public void testAjoutInventaire() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        Item item2 = new Item("or", 1);
        inv.ajouter(item1, 4);
        inv.ajouter(item2, 1);
        inv.ajouter(item1, 2);
        assertEquals(6, inv.getQuantite(item1));
        assertEquals(1, inv.getQuantite(item2));
        HashSet<Item> items = new HashSet<>(Arrays.asList(item1, item2));
        assertEquals(items, inv.getContenu());
    }

    @Test
    public void testRetourAjout() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        boolean ok = inv.ajouter(item1, 10);
        assertTrue(ok);
    }

    @Test
    public void testSupprimer() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        inv.ajouter(item1, 4);
        inv.retirer(item1, 3);
        assertEquals(1, inv.getQuantite(item1));
    }

    @Test
    public void testSupprimerTout() {
        Inventaire inv = new Inventaire();
        Item item1 = new Item("bois", 5);
        inv.ajouter(item1, 4);
        inv.retirer(item1, 4);
        assertEquals(0, inv.getQuantite(item1));
    }

    @Test
    public void testRecetteBouclier() {
        // On crée les objets manipulés.
        Item bois = new Item("bois", 5);
        Item metal = new Item("metal", 10);
        Item bouclier = new Item("bouclier", 8);

        // On crée la recette
        Recette recetteBouclier = new Recette(bouclier);
        recetteBouclier.setIngredient(bois,2);
        recetteBouclier.setIngredient(metal,1);

        // On crée l'inventaire avec assez de matériel.
        Inventaire inv = new Inventaire();        
        inv.ajouter(bois, 10);
        inv.ajouter(metal, 5);

        // On applique la recette
        boolean ok = recetteBouclier.appliquer(inv);
        assertTrue(ok); 
        assertEquals(8, inv.getQuantite(bois)); // On a consommé 2 bois
        assertEquals(4, inv.getQuantite(metal)); // On a consommé 2 métal
        assertEquals(1, inv.getQuantite(bouclier)); // on a créé un bouclier
    }

    @Test
    public void testRecetteBouclierRate() {
        // On crée les objets manipulés.
        Item bois = new Item("bois", 5);
        Item metal = new Item("metal", 10);
        Item bouclier = new Item("bouclier", 8);

        // On crée la recette
        Recette recetteBouclier = new Recette(bouclier);
        recetteBouclier.setIngredient(bois,2);
        recetteBouclier.setIngredient(metal,1);

        // On crée l'inventaire sans le matériel nécessaire...
        Inventaire inv = new Inventaire();        
        inv.ajouter(bois, 1); 
        inv.ajouter(metal, 5);

        // On applique la recette
        boolean ok = recetteBouclier.appliquer(inv);
        assertFalse(ok);
        assertEquals(1, inv.getQuantite(bois)); // le bois n'a pas bougé
        assertEquals(5, inv.getQuantite(metal)); // ni le métal
        assertEquals(0, inv.getQuantite(bouclier)); // on n'a créé aucun bouclier
    }

}
