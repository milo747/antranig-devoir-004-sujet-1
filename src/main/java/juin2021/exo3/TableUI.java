package juin2021.exo3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableUI {
    private final JFrame frame;
    private final JTable table;
    private final JComboBox<String> choixOperation;
    

    public TableUI() {
        frame = new JFrame("Table de multiplication");
        table = new JTable();
        String operations [] = {"+",  "*"};
        choixOperation = new JComboBox<>(operations);
        mettreEnPage();
    }


    private void mettreEnPage() {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints cc = new GridBagConstraints();
        cc.weightx = 1;
        cc.weighty = 1;
        cc.fill = GridBagConstraints.BOTH;
        frame.add(new JScrollPane(table), cc);
        cc.gridy = 1;
        cc.weighty = 0;
        cc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(choixOperation,cc);
        frame.pack();        
    }


    public JFrame getFrame() {
        return frame;
    }


    public JTable getTable() {
        return table;
    }

    public JComboBox<String> getChoixOperation() {
        return choixOperation;
    }

}
