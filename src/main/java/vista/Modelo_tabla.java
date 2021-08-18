package vista;

import javax.swing.table.DefaultTableModel;

public class Modelo_tabla extends DefaultTableModel{
    String[][] data;
    String [] columnNames;

    public Modelo_tabla(String[][] data, String [] columnNames) {
        super();
        this.columnNames=columnNames;
        this.data=data;
        setDataVector(data, columnNames);
    }
    
}
