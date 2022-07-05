package Login_Page;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class Tabel_Model_attend extends AbstractTableModel {
    private List<datamode_attend> AttenduserData = new ArrayList<datamode_attend>();
    private String[] columnNames =  {"Date", "Work Time"};

    public Tabel_Model_attend(List<datamode_attend> attenduserData) {
        AttenduserData = attenduserData;
    }

    public Tabel_Model_attend() {
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return AttenduserData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object userAttribute = null;
        datamode_attend userObject = AttenduserData.get(row);
        switch(column) {
            case 0: userAttribute = userObject.getDate(); break;
            case 1: userAttribute = userObject.getTime(); break;
            default: break;
        }
        return userAttribute;
    }
    public void addUser(datamode_attend user) {
        AttenduserData.add(user);
        fireTableDataChanged();
    }
}
