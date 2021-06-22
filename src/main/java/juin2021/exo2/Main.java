package juin2021.exo2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
			Reader r = new FileReader("file.txt");
			Writer w = new FileWriter("output.txt");
			ExoFichier.passerALaLigne(r, w, 15);
			w.close();
			r.close();
			
			r = new FileReader("file2.txt");
			w = new FileWriter("output2.txt");
			ExoFichier.copierLettre(r, w, "Babbage");
			w.close();
			r.close();
	}

}
