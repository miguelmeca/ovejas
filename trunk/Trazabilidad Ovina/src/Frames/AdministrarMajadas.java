/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import controllers.MajadaJpaController;
import controllers.OvejaJpaController;
import java.util.List;
import javax.swing.JOptionPane;
import model.Majada;
import model.Oveja;

public class AdministrarMajadas extends javax.swing.JPanel {

    /** Creates new form PnlABMMajadas */
    public AdministrarMajadas() {
        initComponents();

        inicializarPersonalizado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboMajadas = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldMajadaNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMajadaDescripcion = new javax.swing.JTextArea();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMajadaOvejas = new javax.swing.JTable();
        jButtonNuevaOveja = new javax.swing.JButton();
        jButtonBorrarOveja = new javax.swing.JButton();
        jButtonNuevaMajada = new javax.swing.JButton();
        jButtonBuscarMajada = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Majadas: ");

        jComboMajadas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 161));

        jTextFieldMajadaNombre.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Descripcion");

        jTextAreaMajadaDescripcion.setColumns(20);
        jTextAreaMajadaDescripcion.setRows(5);
        jTextAreaMajadaDescripcion.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaMajadaDescripcion);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMajadaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonAceptar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMajadaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonAceptar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(540, 320));

        jTableMajadaOvejas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableMajadaOvejas);

        jButtonNuevaOveja.setText("Agregar Oveja");
        jButtonNuevaOveja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaOvejaActionPerformed(evt);
            }
        });

        jButtonBorrarOveja.setText("Eliminar Oveja");
        jButtonBorrarOveja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarOvejaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jButtonNuevaOveja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jButtonBorrarOveja)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaOveja)
                    .addComponent(jButtonBorrarOveja))
                .addGap(19, 19, 19))
        );

        jButtonNuevaMajada.setText("Agregar Majada");
        jButtonNuevaMajada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaMajadaActionPerformed(evt);
            }
        });

        jButtonBuscarMajada.setText("OK");
        jButtonBuscarMajada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarMajadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboMajadas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonBuscarMajada, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButtonNuevaMajada))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMajadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNuevaMajada)
                    .addComponent(jLabel1)
                    .addComponent(jButtonBuscarMajada))
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextAreaMajadaDescripcion.setText("");
        jTextFieldMajadaNombre.setText("");
        jTextAreaMajadaDescripcion.setEnabled(false);
        jTextFieldMajadaNombre.setEnabled(false);
        jButtonAceptar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        MajadaJpaController majadaJpaController = new MajadaJpaController();
        Majada majada = new Majada();
        majada.setMajadanombre(jTextFieldMajadaNombre.getText());
        majada.setMajadadescripcion(jTextAreaMajadaDescripcion.getText());
        majadaJpaController.create(majada);

        jTextAreaMajadaDescripcion.setText("");
        jTextFieldMajadaNombre.setText("");
        jTextAreaMajadaDescripcion.setEnabled(false);
        jTextFieldMajadaNombre.setEnabled(false);
        jButtonAceptar.setEnabled(false);
        jButtonCancelar.setEnabled(false);

        //Mostrar mensaje!
        JOptionPane.showMessageDialog(null, "Se grabo exitosamente", "Nueva Majada", JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonNuevaOvejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaOvejaActionPerformed
        //Llama al frame que permite agregar ovejas a un corral. El corral es pasado por parametro
       // Marco.setContenidoCentral(new AgregarOvejaCorral(jComboMajadas.getSelectedIndex()));
    }//GEN-LAST:event_jButtonNuevaOvejaActionPerformed

    private void jButtonBorrarOvejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarOvejaActionPerformed
        //Llama al frame que permite eliminar ovejas de un corral. El corral es pasado por parametro
        //Marco.setContenidoCentral(new EliminarOvejaCorral(jComboMajadas.getSelectedIndex()));
}//GEN-LAST:event_jButtonBorrarOvejaActionPerformed

    private void jButtonBuscarMajadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarMajadaActionPerformed
        Majada majada = new Majada();
        MajadaJpaController mjc = new MajadaJpaController();
        majada = mjc.findMajada(jComboMajadas.getSelectedIndex());
        jTextFieldMajadaNombre.setText(majada.getMajadanombre());
        jTextAreaMajadaDescripcion.setText(majada.getMajadadescripcion());

        jTableMajadaOvejas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
        },
                new String [] {
            "RP", "Sexo", "Fecha Alta", "Peso"
        }
        ));

        OvejaJpaController ojc = new OvejaJpaController();
        List<Oveja> ovejas = ojc.findListaOvejaPorMajada(majada.getMajadaid());

        for(int i = 0; i < ovejas.size(); i++){
            Oveja oveja = ovejas.get(i);
            jTableMajadaOvejas.setValueAt(oveja.getOvejarp(), i, 0);
            jTableMajadaOvejas.setValueAt(oveja.getOvejasexo(), i, 1);
            jTableMajadaOvejas.setValueAt(oveja.getOvejafechaalta(), i, 2);
            jTableMajadaOvejas.setValueAt(oveja.getOvejapeso(), i, 3);
        }
    }//GEN-LAST:event_jButtonBuscarMajadaActionPerformed

    private void jButtonNuevaMajadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaMajadaActionPerformed
        jTextAreaMajadaDescripcion.setEnabled(true);
        jTextAreaMajadaDescripcion.setText("");
        jTextFieldMajadaNombre.setEnabled(true);
        jTextFieldMajadaNombre.setText("");
        jButtonAceptar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jButtonNuevaMajadaActionPerformed

     private void inicializarPersonalizado() {

        MajadaJpaController majadaJpaController = new MajadaJpaController();
        List<Majada> majadas = majadaJpaController.findMajadaEntities();

        String[] nombreMajada = new String[majadas.size()];
        for(int i = 0; i < majadas.size(); i++){
            nombreMajada[i] = majadas.get(i).getMajadanombre();
        }
        jComboMajadas.setModel(new javax.swing.DefaultComboBoxModel(nombreMajada));
        jButtonAceptar.setEnabled(false);
        jButtonCancelar.setEnabled(false);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBorrarOveja;
    private javax.swing.JButton jButtonBuscarMajada;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNuevaMajada;
    private javax.swing.JButton jButtonNuevaOveja;
    private javax.swing.JComboBox jComboMajadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMajadaOvejas;
    private javax.swing.JTextArea jTextAreaMajadaDescripcion;
    private javax.swing.JTextField jTextFieldMajadaNombre;
    // End of variables declaration//GEN-END:variables
}
