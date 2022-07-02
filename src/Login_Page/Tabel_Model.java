package Login_Page;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class Tabel_Model extends AbstractTableModel {


    private List<DataModel> userData = new ArrayList<DataModel>();
    private String[] columnNames =  {"ID", "Username", "Email", "Section","Date Creation"};

    public Tabel_Model(){}

    public Tabel_Model(List<DataModel> userData) {
        this.userData = userData;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return userData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object userAttribute = null;
        DataModel userObject = userData.get(row);
        switch(column) {
            case 0: userAttribute = userObject.getId_akun(); break;
            case 1: userAttribute = userObject.getUsername(); break;
            case 2: userAttribute = userObject.getEmail(); break;
            case 3: userAttribute = userObject.getSection(); break;
            case 4: userAttribute = userObject.getDate_Creation(); break;
            default: break;
        }
        return userAttribute;
    }
    public void addUser(DataModel user) {
        userData.add(user);
        fireTableDataChanged();
    }

}
