/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistrarServicioPnl.java
 *
 * Created on 07/08/2011, 22:39:13
 */
package LoNuevo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import soporte.MyCheckBoxEditor;
import soporte.MyCheckBoxRenderer;
import soporte.MyComboBoxEditor;
import soporte.MyComboBoxRenderer;
import soporte.TablaServicio;

/**
 *
 * @author usuario
 */
public class RegistrarServicioPnl extends javax.swing.JPanel {

    /** Creates new form RegistrarServicioPnl */
    public RegistrarServicioPnl() {
        initComponents();
       
                      
        elegirBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        String mes, dia, anio;
        dia= Integer.toString(nacimientoCalendar.getDayChooser().getDay());
        mes= Integer.toString(nacimientoCalendar.getMonthChooser().getMonth()+1);
        anio= Integer.toString(nacimientoCalendar.getYearChooser().getYear());    
        fechaText.setText(dia+"/"+mes+"/"+anio);
        elegirBtn.setVisible(false);
        fechabtn.setVisible(true);
        nacimientoCalendar.setVisible(false);
        iniciartabla();
//        jScrollPane1.setVisible(true);
        }
        });
        
        listarServiciosBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            VerServicoPnl vsp = new VerServicoPnl();
      
        Marco.contenidoCentral.add(vsp);
       vsp.setVisible(true); 
       vsp.setBounds(0, 0, Marco.contenidoCentral.getWidth(), Marco.contenidoCentral.getHeight());
       Marco.contenidoCentral.repaint();
        }
        });
        
        
        
    }

   public void initComponentes(){
      
       nacimientoCalendar.setVisible(false);
       fechaText.enable(false);
       elegirBtn.setVisible(false);
//       jScrollPane1.setVisible(false);
//       jScrollPane2.setVisible(false);
       
      noFechaLbl.setVisible(false);
      iniciartabla();
//       TablaServicio t = new TablaServicio();
//      tablaServicios = t.getTabla();
     
   //   repaint();
       

   }
    
     
  private void iniciartabla  (){
      modelo = new DefaultTableModel();
      tablaServicios.setModel(modelo);

      modelo.addColumn("N°Servicio");
      modelo.addColumn("PR Macho");//,new Object[]{"seleccione"});
      modelo.addColumn("RP Hembra");
      modelo.addColumn("Observaciones");
      modelo.addColumn("#Exito/fracaso");

     // Object[] l ={new Integer(1),"Seleccione",new Integer(2),"Observaciones",new Boolean(false)};
      
//      for(int i=0;i<cant ;i++){
//      Object[] l ={i,"Seleccione",i*2,"Observaciones",new Boolean(false)};
//          modelo.addRow(l);
     // }
      JComboBox comboBox = new JComboBox();
        comboBox.addItem("Macho RP1");
        comboBox.addItem("Macho RP2");
        comboBox.addItem("Macho RP3");
        comboBox.addItem("Macho RP4");
        comboBox.addItem("Macho RP5");
        comboBox.addItem("DESCONOCIDO");
        tablaServicios.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));
      JCheckBox checkBox = new JCheckBox();
        tablaServicios.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(checkBox));

        Object[] l ={in,"Seleccione",in*2,"Observaciones",new Boolean(false)};
     modelo.addRow(l);
         
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        fechaText = new javax.swing.JTextField();
        fechabtn = new javax.swing.JButton();
        nacimientoCalendar = new com.toedter.calendar.JCalendar();
        elegirBtn = new javax.swing.JButton();
        eliminarServiciosBtn = new javax.swing.JButton();
        guardarServiciosBtn = new javax.swing.JButton();
        listarServiciosBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        agregaFilabtn = new javax.swing.JButton();
        noFechaLbl = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(470, 330));

        label.setText("FECHA");

        fechabtn.setText("...");
        fechabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechabtnActionPerformed(evt);
            }
        });

        nacimientoCalendar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nacimientoCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nacimientoCalendarMouseClicked(evt);
            }
        });

        elegirBtn.setText("Seleccionar");
        elegirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirBtnActionPerformed(evt);
            }
        });

        eliminarServiciosBtn.setLabel("Eliminar");

        guardarServiciosBtn.setText("Guardar");
        guardarServiciosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarServiciosBtnActionPerformed(evt);
            }
        });

        listarServiciosBtn.setText("Ver Servicios");
        listarServiciosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarServiciosBtnActionPerformed(evt);
            }
        });

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaServicios);

        jScrollPane2.setViewportView(jScrollPane1);

        agregaFilabtn.setText("add Row");
        agregaFilabtn.setName("agregaFilabtn"); // NOI18N
        agregaFilabtn.setOpaque(false);
        agregaFilabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregaFilabtnActionPerformed(evt);
            }
        });

        noFechaLbl.setForeground(new java.awt.Color(255, 0, 51));
        noFechaLbl.setText("Debe seleccionar una fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listarServiciosBtn)
                .addGap(18, 18, 18)
                .addComponent(eliminarServiciosBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarServiciosBtn)
                .addGap(46, 46, 46)
                .addComponent(agregaFilabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(elegirBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noFechaLbl)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(nacimientoCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label)
                            .addComponent(fechaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechabtn))
                        .addGap(18, 18, 18)
                        .addComponent(elegirBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noFechaLbl))
                    .addComponent(nacimientoCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addComponent(listarServiciosBtn)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eliminarServiciosBtn)
                                .addComponent(guardarServiciosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregaFilabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        fechabtn.getAccessibleContext().setAccessibleName("fechaBtn");
        nacimientoCalendar.getAccessibleContext().setAccessibleName("calendarioPnl");
    }// </editor-fold>//GEN-END:initComponents

    private void fechabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechabtnActionPerformed
        nacimientoCalendar.setVisible(true);
        fechabtn.setVisible(false);
        elegirBtn.setVisible(true);
        noFechaLbl.setVisible(false);
       
        
    }//GEN-LAST:event_fechabtnActionPerformed

    private void nacimientoCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nacimientoCalendarMouseClicked
        fechaText.setText(nacimientoCalendar.getDate().toString());
    }//GEN-LAST:event_nacimientoCalendarMouseClicked

    private void elegirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirBtnActionPerformed
//        jScrollPane1.setVisible(true);
//        jScrollPane2.setVisible(true);
        
        
    }//GEN-LAST:event_elegirBtnActionPerformed

    private void guardarServiciosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarServiciosBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarServiciosBtnActionPerformed

    private void listarServiciosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarServiciosBtnActionPerformed
        this.setVisible(false);
     
    }//GEN-LAST:event_listarServiciosBtnActionPerformed

    private void agregaFilabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregaFilabtnActionPerformed

    if (fechaText.getText().equals(""))
         noFechaLbl.setVisible(true);
        else
    {
        in++;
     Object[] l ={in,"Seleccione",in*2,"Observaciones",new Boolean(false)};
     modelo.addRow(l);
        }
    }//GEN-LAST:event_agregaFilabtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregaFilabtn;
    private javax.swing.JButton elegirBtn;
    private javax.swing.JButton eliminarServiciosBtn;
    private javax.swing.JTextField fechaText;
    private javax.swing.JButton fechabtn;
    private javax.swing.JButton guardarServiciosBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JButton listarServiciosBtn;
    private com.toedter.calendar.JCalendar nacimientoCalendar;
    private javax.swing.JLabel noFechaLbl;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo;
    private int in=1;




}
