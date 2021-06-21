package juin2021.exo3;

import javax.swing.table.AbstractTableModel;

public class OperationTableModele extends AbstractTableModel {
    private String operation = "+";

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;        
        fireTableStructureChanged(); // parce qu'on change aussi le nom de la première colonne.
    }

    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return "à compléter";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0)
            return operation;
        else
            return Integer.toString(column);
    }

}
