/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soporte;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author edgardo.rodriguez
 */
public class ModeloTabla extends AbstractTableModel {
       String[] columnNames = {"N°Servicio",
                        "PR Macho",
                        "RP Hembra",
                        "Observaciones",
                        "Exito"};
        private Object[][] data = {
            {new Integer(1), new Integer(153),
            new Integer(200), "Observaciones", new Boolean(false)},
           {new Integer(2), new Integer(153),
            new Integer(200), "Observaciones", new Boolean(false)},
            {new Integer(3), new Integer(153),
            new Integer(200), "Observaciones", new Boolean(false)},
           {new Integer(4), new Integer(153),
            new Integer(200), "Observaciones", new Boolean(false)},
            {new Integer(5), new Integer(153),
            new Integer(200), "Observaciones", new Boolean(false)}
        };

    public ModeloTabla() {
    }

       public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

}
