/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PnlABMServicio.java
 *
 * Created on 20/05/2013, 21:23:35
 */
package Frames;

import javax.swing.JPanel;
import ui.Marco;

/**
 *
 * @author usuario
 */
public class PnlABMServicio extends javax.swing.JPanel {

    /** Creates new form PnlABMServicio */
    public PnlABMServicio() {
        initComponents();
        jCalendarAlmanaque.setVisible(false);
        jButtonCalendar.setVisible(false);
        jTextFieldFecha.setEnabled(false);
        jTextFieldRPMacho.setEnabled(false);
        jTextFieldRPHembra.setEnabled(false);
        jTextFieldServicio.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jButtonModificar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jButtonReportes.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldServicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldRPMacho = new javax.swing.JTextField();
        jTextFieldRPHembra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCalendarAlmanaque = new com.toedter.calendar.JCalendar();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonCalendar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonReportes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(449, 599));
        setPreferredSize(new java.awt.Dimension(599, 449));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Servicio:");
        add(jLabel1);
        jLabel1.setBounds(12, 17, 62, 17);
        add(jTextFieldServicio);
        jTextFieldServicio.setBounds(90, 10, 100, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Macho:");
        add(jLabel3);
        jLabel3.setBounds(12, 90, 51, 17);

        jTextFieldRPMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRPMachoActionPerformed(evt);
            }
        });
        add(jTextFieldRPMacho);
        jTextFieldRPMacho.setBounds(90, 80, 100, 30);
        add(jTextFieldRPHembra);
        jTextFieldRPHembra.setBounds(90, 150, 100, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Hembra:");
        add(jLabel4);
        jLabel4.setBounds(10, 160, 58, 17);

        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBox1.setText("Exito");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(250, 100, 61, 25);

        jCalendarAlmanaque.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCalendarAlmanaque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendarAlmanaqueMouseClicked(evt);
            }
        });
        jCalendarAlmanaque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCalendarAlmanaqueKeyPressed(evt);
            }
        });
        add(jCalendarAlmanaque);
        jCalendarAlmanaque.setBounds(110, 270, 188, 133);

        jTextFieldFecha.setName("servicioFechatxt"); // NOI18N
        jTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaActionPerformed(evt);
            }
        });
        jTextFieldFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFechaFocusGained(evt);
            }
        });
        add(jTextFieldFecha);
        jTextFieldFecha.setBounds(90, 220, 100, 30);

        jButtonCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarActionPerformed(evt);
            }
        });
        add(jButtonCalendar);
        jButtonCalendar.setBounds(230, 220, 33, 28);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        add(jButtonBuscar);
        jButtonBuscar.setBounds(400, 20, 120, 23);

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        add(jButtonNuevo);
        jButtonNuevo.setBounds(400, 80, 120, 23);

        jButtonModificar.setText("Modiificar");
        add(jButtonModificar);
        jButtonModificar.setBounds(400, 140, 120, 23);

        jButtonEliminar.setText("Eliminar");
        add(jButtonEliminar);
        jButtonEliminar.setBounds(400, 210, 120, 23);

        jButtonReportes.setText("Informes");
        add(jButtonReportes);
        jButtonReportes.setBounds(400, 280, 120, 23);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        add(jLabel2);
        jLabel2.setBounds(10, 230, 47, 17);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaActionPerformed
        
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

    private void jButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarActionPerformed
        String mes, dia, anio;
        dia= Integer.toString(jCalendarAlmanaque.getDayChooser().getDay());
        mes= Integer.toString(jCalendarAlmanaque.getMonthChooser().getMonth()+1);
        anio= Integer.toString(jCalendarAlmanaque.getYearChooser().getYear());
        jTextFieldFecha.setText(dia+"/"+mes+"/"+anio);
        jButtonCalendar.setVisible(false);
        jCalendarAlmanaque.setVisible(false);
    }//GEN-LAST:event_jButtonCalendarActionPerformed

    private void jTextFieldRPMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRPMachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRPMachoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        BuscarGenerico bg = new BuscarGenerico();
        bg.setBounds(0, 0, Marco.getContenidoCentral().getWidth(), Marco.getContenidoCentral().getHeight());
       Marco.setContenidoCentral(bg);
       
      
       
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        jTextFieldFecha.setEnabled(true);
        jTextFieldRPMacho.setEnabled(true);
        jTextFieldRPHembra.setEnabled(true);
        jTextFieldServicio.setEnabled(true);
        jCheckBox1.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jCalendarAlmanaqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCalendarAlmanaqueKeyPressed
      // TODO add your handling code here:
    }//GEN-LAST:event_jCalendarAlmanaqueKeyPressed

    private void jCalendarAlmanaqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarAlmanaqueMouseClicked
       //jTextField1.setText(nacimientoCalendar.getDate().toString());
       
       
       
    }//GEN-LAST:event_jCalendarAlmanaqueMouseClicked

    private void jTextFieldFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaFocusGained
       jCalendarAlmanaque.setVisible(true); 
       jButtonCalendar.setVisible(true);
    }//GEN-LAST:event_jTextFieldFechaFocusGained

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonReportes;
    private com.toedter.calendar.JCalendar jCalendarAlmanaque;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldRPHembra;
    private javax.swing.JTextField jTextFieldRPMacho;
    private javax.swing.JTextField jTextFieldServicio;
    // End of variables declaration//GEN-END:variables
}
