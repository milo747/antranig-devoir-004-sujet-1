package juin2021;
import nfa035.metier.Sujet;

/**
 * Main pour rendre le projet. 
 * 
 * Attention, pour ce dernier devoir, vous n'êtes plus guidé par
 * des tests déjà écrits... à vous de faire vos propres tests.
 * 
 * <p>NE PAS MODIFIER CE CODE.
 * <p>Faire RUN AS JAVA APPLICATION pour lancer le logiciel de rendu. 
 * @author rosmord
 */
public class RendreProjet {
	public static void main(String[] args) {
		Sujet sujet= new Sujet("004");
		new nfa035.Main().startAppli(sujet);		
	}
}
