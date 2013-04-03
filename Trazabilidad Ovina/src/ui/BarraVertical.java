/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import ui.RegistrarServicioPnl;
import javax.swing.JButton;


public class BarraVertical {//extends javax.swing.JToolBar {

public javax.swing.JToolBar barra;
public JButton altaServiciobtn = new JButton("Alta Servicio");
public JButton altaPreniesbtn = new JButton("Alta Preñes");

   public BarraVertical(javax.swing.JToolBar t) {
   barra=t;

   altaServiciobtn.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Marco m = (Marco) barra.getParent();

                RegistrarServicioPnl rsp = new RegistrarServicioPnl();
                rsp.initComponentes();
                Marco.contenidoCentral.add(rsp);
                rsp.setVisible(true);
                rsp.setBounds(0, 0, Marco.contenidoCentral.getWidth(), Marco.contenidoCentral.getHeight());
//                pack();
            }
        });

//    setLayout(null);
//    setOrientation(1);
    }
private void cargarGranja(){

}

private void cargarAlimentacion(){

}
private void cargarSanidad(){

}
private void cargarAdministracion(){

}

public void cargarAnimal(){
// JButton altaServiciobtn = new JButton("Alta Servicio");
// JButton altaPreniesbtn = new JButton("Alta Preñes");
barra.removeAll();
barra.repaint();
barra.add(altaServiciobtn);
barra.add(altaPreniesbtn);


}

}
