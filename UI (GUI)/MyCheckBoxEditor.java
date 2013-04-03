/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soporte;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

/**  
 *
 * @author edgardo.rodriguez
 */
public class MyCheckBoxEditor extends DefaultCellEditor {
    public MyCheckBoxEditor() {
        super(new JCheckBox());
    }

}