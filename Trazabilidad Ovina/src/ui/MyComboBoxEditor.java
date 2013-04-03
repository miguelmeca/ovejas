/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author edgardo.rodriguez
 */
public class MyComboBoxEditor extends DefaultCellEditor {
    public MyComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }

}