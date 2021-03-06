package juin2021.exo2;


import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import nfa035.metier.Sujet;

public class ExoFichier {
    

    /**
     * Recopie le contenu de *reader* sur *writer*, en s'assurant qu'aucune ligne ne fait plus de tailleLigne caractères.
     * (voir énoncé pour plus d'informations)
     * 
     * @param reader
     * @param writer
     * @param tailleLigne
     */
	public static void passerALaLigne(Reader reader, Writer writer, int tailleLigne) throws IOException {
		int cpt = 0;
		int data = 0;
		boolean stop = false;
		do {
			while (cpt < tailleLigne) {
				data = reader.read();
				if (data == -1) 
				{
					stop = true;
					break;
				}
				writer.write(data);
				if (data == '\n')
					cpt = 0;
				else
					cpt++;
			}
			writer.write('\n');
			cpt = 0;
		} while (!stop);
	}

    /**
     * Copie le texte contenu dans reader dans writer, en remplaçant toutes les occurrences de "@N" dans le texte d'entrée par le nom passé en paramètre.
     * @param reader le modèle de lettre (avec des '@N')
     * @param writer la lettre résultante
     * @param nom le nom à utiliser pour remplacer les '@N'
     * @throws IOException
     */
	public static void copierLettre(Reader reader, Writer writer, String nom) throws IOException {
		String line;
		Scanner sc = new Scanner(reader);
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			writer.write(line.replace("@N", nom) + "\n");
		}
		sc.close();
	}
    
}
