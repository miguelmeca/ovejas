/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import controllers.CorralJpaController;
import controllers.OvejaJpaController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.Corral;
import model.Oveja;

public class AgregarOvejaCorral extends javax.swing.JPanel {

    /** Creates new form PnlABMMajadas */
    public AgregarOvejaCorral(int corralEntrada) {
        initComponents();

        inicializarPersonalizado(corralEntrada);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCorralOrigen = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCorralDestino = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOvejasCorralOrigen = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListOvejasCorralDestino = new javax.swing.JList();
        jButtonAgregarOvejaCorral = new javax.swing.JButton();
        jButtonQuitarOvejaCorral = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreadescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButtonComfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Corral Origen:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Ovejas:");

        jComboBoxCorralOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCorralOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCorralOrigenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Corral Destino:");

        jComboBoxCorralDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCorralDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCorralDestinoActionPerformed(evt);
            }
        });

        jListOvejasCorralOrigen.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListOvejasCorralOrigen);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Ovejas:");

        jListOvejasCorralDestino.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListOvejasCorralDestino);

        jButtonAgregarOvejaCorral.setText(">>");
        jButtonAgregarOvejaCorral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarOvejaCorralActionPerformed(evt);
            }
        });

        jButtonQuitarOvejaCorral.setText("<<");
        jButtonQuitarOvejaCorral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarOvejaCorralActionPerformed(evt);
            }
        });

        jTextAreadescripcion.setColumns(20);
        jTextAreadescripcion.setRows(5);
        jScrollPane3.setViewportView(jTextAreadescripcion);

        jLabel5.setText("Descripción:");

        jButtonComfirmar.setText("Confirmar");
        jButtonComfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxCorralOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonQuitarOvejaCorral)
                                    .addComponent(jButtonAgregarOvejaCorral)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCorralDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonCancelar)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonComfirmar)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCorralOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxCorralDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jButtonAgregarOvejaCorral)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonQuitarOvejaCorral))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarOvejaCorralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarOvejaCorralActionPerformed
        // TODO add your handling code here:
        jComboBoxCorralOrigen.setEnabled(false);
        jComboBoxCorralDestino.setEnabled(false);
        DefaultListModel listaModelo = (DefaultListModel) jListOvejasCorralOrigen.getModel();
        DefaultListModel listaModeloDst = (DefaultListModel) jListOvejasCorralDestino.getModel();
    
        if (jListOvejasCorralOrigen.getSelectedIndex() > -1){
            listaModeloDst.addElement(jListOvejasCorralOrigen.getSelectedValue());
            listaModelo.removeElement(jListOvejasCorralOrigen.getSelectedValue());
        }
    }//GEN-LAST:event_jButtonAgregarOvejaCorralActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxCorralOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCorralOrigenActionPerformed

        CorralJpaController corralJpaController = new CorralJpaController();
        String corralNombre = (String)jComboBoxCorralOrigen.getSelectedItem();
        List<Corral> corralSeleccionado = corralJpaController.findCorral(corralNombre);
        
        CargarComboDestino(corralSeleccionado.get(0).getCorralid());
        
        CargarOvejasPorCorral(corralSeleccionado.get(0).getCorralid(), true);
    }//GEN-LAST:event_jComboBoxCorralOrigenActionPerformed

    private void jComboBoxCorralDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCorralDestinoActionPerformed

        CorralJpaController corralJpaController = new CorralJpaController();
        String corralNombre = (String)jComboBoxCorralDestino.getSelectedItem();
        List<Corral> corralSeleccionado = corralJpaController.findCorral(corralNombre);

        CargarOvejasPorCorral(corralSeleccionado.get(0).getCorralid(), false);

    }//GEN-LAST:event_jComboBoxCorralDestinoActionPerformed

    private void jButtonComfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComfirmarActionPerformed
        jComboBoxCorralOrigen.setEnabled(true);
        jComboBoxCorralDestino.setEnabled(true);
    }//GEN-LAST:event_jButtonComfirmarActionPerformed

    private void jButtonQuitarOvejaCorralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarOvejaCorralActionPerformed
        // TODO add your handling code here:
        jComboBoxCorralOrigen.setEnabled(false);
        jComboBoxCorralDestino.setEnabled(false);
        DefaultListModel listaModelo = (DefaultListModel) jListOvejasCorralOrigen.getModel();
        DefaultListModel listaModeloDst = (DefaultListModel) jListOvejasCorralDestino.getModel();

        if (jListOvejasCorralDestino.getSelectedIndex() > -1){
            listaModelo.addElement(jListOvejasCorralDestino.getSelectedValue());
            listaModeloDst.removeElement(jListOvejasCorralDestino.getSelectedValue());
        }
    }//GEN-LAST:event_jButtonQuitarOvejaCorralActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarOvejaCorral;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonComfirmar;
    private javax.swing.JButton jButtonQuitarOvejaCorral;
    private javax.swing.JComboBox jComboBoxCorralDestino;
    private javax.swing.JComboBox jComboBoxCorralOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListOvejasCorralDestino;
    private javax.swing.JList jListOvejasCorralOrigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreadescripcion;
    // End of variables declaration//GEN-END:variables

    private void inicializarPersonalizado(int corral) {

        
        CargarComboOrigen(corral);
        CargarComboDestino(corral);

    }

    private void CargarComboOrigen(int corralid){

        CorralJpaController corralJpaController = new CorralJpaController();
        List<Corral> corrales = corralJpaController.findCorralEntities();

        String[] nombreCorralOrigen = new String[corrales.size()];
        for (int i = 0; i < corrales.size(); i++){
            nombreCorralOrigen[i] = corrales.get(i).getCorralnombre();
        }
        jComboBoxCorralOrigen.setModel(new javax.swing.DefaultComboBoxModel(nombreCorralOrigen));
        CorralJpaController cjc = new CorralJpaController();
        Corral corral = new Corral();
        corral = cjc.findCorral(corralid);
        jComboBoxCorralOrigen.setSelectedItem(corral.getCorralnombre());

        CargarOvejasPorCorral(corralid, true);
    }

     private void CargarComboDestino(int corralid){

        CorralJpaController corralJpaController = new CorralJpaController();
        List<Corral> corrales = corralJpaController.findTodosCorralesMenosUno(corralid);

        String[] nombreCorralDestino = new String[corrales.size()];
        for (int i = 0; i < corrales.size(); i++){
            nombreCorralDestino[i] = corrales.get(i).getCorralnombre();
        }
        jComboBoxCorralDestino.setModel(new javax.swing.DefaultComboBoxModel(nombreCorralDestino));
        String corralNombre = (String)jComboBoxCorralDestino.getSelectedItem();
       
        List<Corral> corralSeleccionado = corralJpaController.findCorral(corralNombre);
        
        CargarOvejasPorCorral(corralSeleccionado.get(0).getCorralid(), false);
    }

     private void CargarOvejasPorCorral(int corralid, boolean bandera){
     //bandera es true cuando es origen y es false cuando es destino

        DefaultListModel listaModelo = new DefaultListModel();
        if (bandera){
            jListOvejasCorralOrigen.setModel(listaModelo);
        } else {
            jListOvejasCorralDestino.setModel(listaModelo);
        }

        OvejaJpaController ovejaJpaController = new OvejaJpaController();
        List<Oveja> ovejas = ovejaJpaController.findListaOvejaPorCorral(corralid);

        for(int i = 0; i < ovejas.size(); i++){
            listaModelo.addElement(ovejas.get(i).getOvejarp());
        }
     }

}
