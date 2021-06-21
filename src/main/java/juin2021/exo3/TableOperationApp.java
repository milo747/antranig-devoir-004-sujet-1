package juin2021.exo3;

import javax.swing.JFrame;

public class TableOperationApp {
    private TableUI ui;
    private OperationTableModele modele = new OperationTableModele();

    public TableOperationApp() {
        this.ui = new TableUI();
        this.ui.getFrame().setVisible(true);
        this.ui.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // à compléter...
    }

 
    

}
