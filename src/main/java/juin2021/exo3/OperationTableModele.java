package juin2021.exo3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class OperationTableModele extends AbstractTableModel implements ActionListener {
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
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
      if( operation.equals("+") )
    	  return (rowIndex+1) + columnIndex;
      if( operation.equals("*") )
      {
    	  if( columnIndex == 0)
    		  return (rowIndex+1);
      		if( rowIndex == 0)
      			return (columnIndex);
      		return columnIndex * (rowIndex+1);
      }
      return 0;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0)
            return operation;
        else
            return Integer.toString(column);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if( e.getSource() instanceof JComboBox )
    		setOperation( (String) ((JComboBox<?>) e.getSource()).getSelectedItem() );
}

}
