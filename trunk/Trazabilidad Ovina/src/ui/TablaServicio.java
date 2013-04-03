/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
//import Servicio;
//import oracle.toplink.essentials.sessions.Record;
import ui.TableDemo.MyTableModel;

/**
 *
 * @author usuario
 */
public class TablaServicio {
    JTable tabla ;

    public TablaServicio(int s) {
      TablaModelo modelo = new TablaModelo();
            
      String[] columnNames = {"N°Servicio",
                        "PR Macho",
                        "RP Hembra",
                        "Observaciones",
                        "Exito"};
      
     Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };

      tabla=  new JTable(data,columnNames);
      
      setUpSportColumn(tabla, tabla.getColumnModel().getColumn(2));
      //tabla.setModel(modelo);      
      
      
      
      
//      modelo.addColumn("N°Servicio");
//      modelo.addColumn("PR Macho",new Object[]{"seleccione"});
//      modelo.addColumn("RP Hembra");
//      modelo.addColumn("Observaciones");
//      modelo.addColumn("#Exito/fracaso");
//       
//      
//      String[] values = new String[]{"macho1", "macho2", "macho3", "macho4"};
//             int vColIndex = 1;
//             TableColumn col = tabla.getColumnModel().getColumn(vColIndex);
//             col.setCellEditor(new MyComboBoxEditor(values));
//             col.setCellRenderer(new MyComboBoxRenderer(values));
//      
//             int cColIndex = 4;
//             TableColumn col2 = tabla.getColumnModel().getColumn(cColIndex);
//             col2.setCellEditor(new MyCheckBoxEditor());
//             col2.setCellRenderer(new MyCheckBoxRenderer());
      
        
         
        }
  
     public TablaServicio() {
         iniciarTabla(5);
     }

    public JTable getTabla() {
        return tabla;
    }

    private void iniciarTabla(int cantidad)
    {
        for(int i =0; i<= cantidad; i++)
        {
            setUpSportColumn(tabla, tabla.getColumnModel().getColumn(2));
        }

    }



   private void initColumnSizes(JTable table) {
        MyTableModel model = (MyTableModel)table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
            table.getTableHeader().getDefaultRenderer();

        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(
                                 null, column.getHeaderValue(),
                                 false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;

            comp = table.getDefaultRenderer(model.getColumnClass(i)).
                             getTableCellRendererComponent(
                                 table, longValues[i],
                                 false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;

           column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }



    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Knitting");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Pool");
        comboBox.addItem("None of the above");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
    }
    
}
