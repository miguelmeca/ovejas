/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

public class MyCheckBoxEditor extends DefaultCellEditor {
    public MyCheckBoxEditor() {
        super(new JCheckBox());
    }

}