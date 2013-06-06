/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Marco.java
 *
 * Created on 31/07/2011, 21:40:40
 */
package ui;

import Frames.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import ui.BarraVertical;
import ui.TablaServicio;

/**
 *|
 * @author usuario
 */
public class Marco extends javax.swing.JFrame {

    /** Creates new form Marco */
    public Marco() {
        initComponents();
        initComponentes();

    btnCorrales.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new AdministrarCorral());
             pack();
            }
        });

   
     btnMajadas.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMMajadas());
             pack();
            }
        });
         
      btnInsumos.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMInsumosGranja());
             pack();
            }
        });
             
       btnMenues.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMMenues());
             pack();
            }
        });
                 
     btnRacion.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMRacion());
             pack();
            }
        });
     
       btnInsumosAlimentacion.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMInsumoAlimentacion());
             pack();
            }
        });
     
     btnTratamiento.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMTratamiento());
             pack();
            }
        });
     
       btnDosis.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMDosis());
             pack();
            }
        });
     
       btnInsumosSanidad.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMInsumoSanidad());
             pack();
            }
        });
      
      
      btnCaja.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMCaja());
             pack();
            }
        });
     
       btnClientes.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMCliente());
             pack();
            }
        });
     
       btnProveedores.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMProveedor());
             pack();
            }
        });
     
       btnInformes.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMInformes());
             pack();
            }
        });
      
        btnServicio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMServicio());
             pack();
            }
        });
       
       btnPrenies.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMPrenies());
             pack();
            }
        });
     
       btnParto.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            setContenidoCentral( new PnlABMParto());
             pack();
            }
        });
             
   
         
    }

    public static JPanel getContenidoCentral() {
        return contenidoCentral;
     
    }

    public static void setContenidoCentral(JPanel acontenidoCentral) {
        contenidoCentral.removeAll();
        contenidoCentral.add(acontenidoCentral);
        acontenidoCentral.setVisible(true);
        acontenidoCentral.setBounds(0, 0, contenidoCentral.getWidth(), contenidoCentral.getHeight());    
        acontenidoCentral.setBorder(contenidoCentral.getBorder());
        acontenidoCentral.setVisible(true);
       
    }

    public void Pack()
    {
        pack();
    }
    
    private void initComponentes() {
        Image img = Toolkit.getDefaultToolkit().getImage("/ui/ovejaicono2 1.jpg");
        this.setIconImage(img);
        barraVertical.setLayout(null);
        barraVertical.setOrientation(1);
        pack();
       // cargarArbol();
       
    }

   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHorizontal = new javax.swing.JToolBar();
        granjabtn = new javax.swing.JButton();
        alimentacionbtn = new javax.swing.JButton();
        sanidadbtn = new javax.swing.JButton();
        administracionbtn = new javax.swing.JButton();
        animalbtn = new javax.swing.JButton();
        salir1btn = new javax.swing.JButton();
        barraVertical = new javax.swing.JToolBar();
        contenidoCentral = new javax.swing.JPanel();
        salir2btn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jMenu21 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trazabilidad Ovina");
        setForeground(java.awt.Color.white);
        setIconImages(getIconImages());

        barraHorizontal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraHorizontal.setRollover(true);

        granjabtn.setBackground(new java.awt.Color(255, 255, 255));
        granjabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/granjaicono2.jpg"))); // NOI18N
        granjabtn.setText("Granja");
        granjabtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        granjabtn.setFocusable(false);
        granjabtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        granjabtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        granjabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                granjabtnActionPerformed(evt);
            }
        });
        barraHorizontal.add(granjabtn);

        alimentacionbtn.setBackground(new java.awt.Color(255, 255, 255));
        alimentacionbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/alimentacionicono2.jpg"))); // NOI18N
        alimentacionbtn.setText("Alimentacion");
        alimentacionbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        alimentacionbtn.setFocusable(false);
        alimentacionbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alimentacionbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alimentacionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alimentacionbtnActionPerformed(evt);
            }
        });
        barraHorizontal.add(alimentacionbtn);

        sanidadbtn.setBackground(new java.awt.Color(255, 255, 255));
        sanidadbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/sanidadicono2.jpg"))); // NOI18N
        sanidadbtn.setText("Sanidad");
        sanidadbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sanidadbtn.setFocusable(false);
        sanidadbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sanidadbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sanidadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanidadbtnActionPerformed(evt);
            }
        });
        barraHorizontal.add(sanidadbtn);

        administracionbtn.setBackground(new java.awt.Color(255, 255, 255));
        administracionbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/administracionicono2.jpg"))); // NOI18N
        administracionbtn.setText("Administracion");
        administracionbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        administracionbtn.setFocusable(false);
        administracionbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        administracionbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        administracionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionbtnActionPerformed(evt);
            }
        });
        barraHorizontal.add(administracionbtn);

        animalbtn.setBackground(new java.awt.Color(255, 255, 255));
        animalbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/animalicono2.jpg"))); // NOI18N
        animalbtn.setText("Animal");
        animalbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        animalbtn.setFocusable(false);
        animalbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        animalbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        animalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalbtnActionPerformed(evt);
            }
        });
        barraHorizontal.add(animalbtn);

        salir1btn.setBackground(new java.awt.Color(255, 255, 255));
        salir1btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/cerraricono2.jpg"))); // NOI18N
        salir1btn.setText("Salir");
        salir1btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir1btn.setFocusable(false);
        salir1btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salir1btn.setPreferredSize(new java.awt.Dimension(140, 89));
        salir1btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salir1btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir1btnActionPerformed(evt);
            }
        });
        barraHorizontal.add(salir1btn);

        barraVertical.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraVertical.setFloatable(false);
        barraVertical.setOrientation(1);
        barraVertical.setRollover(true);
        barraVertical.setAutoscrolls(true);

        contenidoCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenidoCentral.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout contenidoCentralLayout = new javax.swing.GroupLayout(contenidoCentral);
        contenidoCentral.setLayout(contenidoCentralLayout);
        contenidoCentralLayout.setHorizontalGroup(
            contenidoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        contenidoCentralLayout.setVerticalGroup(
            contenidoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        salir2btn.setText("Salir");
        salir2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir2btnActionPerformed(evt);
            }
        });

        jMenu2.setText("Granja");

        jMenu8.setText("Corrales");

        jMenuItem6.setText("Alta Corrales");
        jMenu8.add(jMenuItem6);

        jMenuItem7.setText("Baja Corrales");
        jMenu8.add(jMenuItem7);

        jMenuItem8.setText("Editar Corrales");
        jMenu8.add(jMenuItem8);

        jMenuItem9.setText("Consulta Corrales");
        jMenu8.add(jMenuItem9);

        jMenuItem10.setText("Listado Corrales");
        jMenu8.add(jMenuItem10);

        jMenu2.add(jMenu8);

        jMenu9.setText("Majadas");

        jMenuItem1.setText("Alta Majada");
        jMenu9.add(jMenuItem1);

        jMenuItem2.setText("Baja Majada");
        jMenu9.add(jMenuItem2);

        jMenuItem3.setText("Editar Majada");
        jMenu9.add(jMenuItem3);

        jMenuItem4.setText("Consulta Majadas");
        jMenu9.add(jMenuItem4);

        jMenuItem5.setText("Listado Majadas");
        jMenu9.add(jMenuItem5);

        jMenu2.add(jMenu9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Alimentacion");

        jMenu10.setText("Menues");

        jMenuItem11.setText("Alta Menu");
        jMenu10.add(jMenuItem11);

        jMenuItem12.setText("Baja Menu");
        jMenu10.add(jMenuItem12);

        jMenuItem13.setText("Editar Menu");
        jMenu10.add(jMenuItem13);

        jMenuItem14.setText("Listado Menu");
        jMenu10.add(jMenuItem14);

        jMenuItem15.setText("Consulta Menu");
        jMenu10.add(jMenuItem15);

        jMenuItem16.setText("Historial Menu");
        jMenu10.add(jMenuItem16);

        jMenu3.add(jMenu10);

        jMenu11.setText("Insumos Alimentacion");

        jMenuItem17.setText("Alta Insumo Alimentacion");
        jMenu11.add(jMenuItem17);

        jMenuItem18.setText("Baja Insumo Alimentacion");
        jMenu11.add(jMenuItem18);

        jMenuItem19.setText("Editar Insumo Alimentacion");
        jMenu11.add(jMenuItem19);

        jMenuItem20.setText("Stock Insumo Alimentacion");
        jMenu11.add(jMenuItem20);

        jMenuItem21.setText("Proveedores Insumo Alimentacion");
        jMenu11.add(jMenuItem21);

        jMenuItem22.setText("Precio  Insumo Alimentacion");
        jMenu11.add(jMenuItem22);

        jMenu3.add(jMenu11);

        jMenu12.setText("Planes de Alimentacion");

        jMenuItem23.setText("Alta Plan Alimentacion");
        jMenu12.add(jMenuItem23);

        jMenuItem24.setText("Baja Plan Alimentacion");
        jMenu12.add(jMenuItem24);

        jMenuItem25.setText("Editar Plan Alimentacion");
        jMenu12.add(jMenuItem25);

        jMenuItem26.setText("Asignar Plan Alimentacion");
        jMenu12.add(jMenuItem26);

        jMenuItem27.setText("Calendario Plan Alimentacion");
        jMenu12.add(jMenuItem27);

        jMenu3.add(jMenu12);

        jMenu1.setText("Archivo");
        jMenu3.add(jMenu1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sanidad");

        jMenu13.setText("Tratamiento Sanitario");

        jMenuItem28.setText("Alta Tratamiento Sanitario");
        jMenu13.add(jMenuItem28);

        jMenuItem29.setText("Baja Tratamiento Sanitario");
        jMenu13.add(jMenuItem29);

        jMenuItem30.setText("Editar Tratamiento Sanitario");
        jMenu13.add(jMenuItem30);

        jMenuItem31.setText("Aplicacion Tratamiento Sanitario");
        jMenu13.add(jMenuItem31);

        jMenu4.add(jMenu13);

        jMenu14.setText("Plan Sanitario");

        jMenuItem33.setText("Alta Plan Sanitario");
        jMenu14.add(jMenuItem33);

        jMenuItem34.setText("Baja Plan Sanitario");
        jMenu14.add(jMenuItem34);

        jMenuItem35.setText("Editar Plan Sanitario");
        jMenu14.add(jMenuItem35);

        jMenuItem36.setText("Asignar Plan Sanitario");
        jMenu14.add(jMenuItem36);

        jMenu4.add(jMenu14);

        jMenu15.setText("Insumos Sanitarios");

        jMenuItem37.setText("Alta Insumos Sanitarios ");
        jMenu15.add(jMenuItem37);

        jMenuItem38.setText("Baja Insumos Sanitarios");
        jMenu15.add(jMenuItem38);

        jMenuItem39.setText("Editar Insumos Sanitarios");
        jMenu15.add(jMenuItem39);

        jMenuItem40.setText("Stock Insumos Sanitarios");
        jMenu15.add(jMenuItem40);

        jMenuItem41.setText("Proveedores Insumos Sanitarios");
        jMenu15.add(jMenuItem41);

        jMenuItem42.setText("Precios Insumos Sanitarios");
        jMenu15.add(jMenuItem42);

        jMenu4.add(jMenu15);

        jMenuItem32.setText("Veterinarios");
        jMenu4.add(jMenuItem32);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Administracion");

        jMenu16.setText("Clientes");

        jMenuItem43.setText("Clientes Insumos");
        jMenu16.add(jMenuItem43);

        jMenuItem44.setText("Clientes Animales");
        jMenu16.add(jMenuItem44);

        jMenu5.add(jMenu16);

        jMenu17.setText("Proveedores");

        jMenuItem45.setText("Proveedores Insumos");
        jMenu17.add(jMenuItem45);

        jMenuItem46.setText("Proveedores Animales");
        jMenu17.add(jMenuItem46);

        jMenu5.add(jMenu17);

        jMenu18.setText("Caja");

        jMenuItem47.setText("Ultimos Movimientos");
        jMenu18.add(jMenuItem47);

        jMenuItem48.setText("Resumen");
        jMenu18.add(jMenuItem48);

        jMenuItem49.setText("Estudios de mercado");
        jMenu18.add(jMenuItem49);

        jMenu5.add(jMenu18);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Animal");

        jMenu19.setText("Alta Animal");
        jMenu6.add(jMenu19);

        jMenu20.setText("Baja Animal");
        jMenu6.add(jMenu20);

        jMenu21.setText("Generar Reportes");
        jMenu6.add(jMenu21);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Extras");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barraHorizontal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(barraVertical, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(salir2btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addComponent(contenidoCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contenidoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salir2btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barraVertical, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void granjabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_granjabtnActionPerformed
        barraVertical.removeAll();
        barraVertical.repaint();
        barraVertical.add(btnCorrales);
        barraVertical.add(btnMajadas);
        barraVertical.add(btnInsumos);
        
        btnCorrales.setBounds(0,   0, barraVertical.getWidth(),50);
        btnMajadas.setBounds(0,   50, barraVertical.getWidth(),50);
        btnInsumos.setBounds(0,   100, barraVertical.getWidth(),50);
        
         
        pack();
    }//GEN-LAST:event_granjabtnActionPerformed

    private void administracionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionbtnActionPerformed
        barraVertical.removeAll();
        barraVertical.repaint();
        barraVertical.add(btnCaja);
        barraVertical.add(btnClientes);
        barraVertical.add(btnProveedores);
        barraVertical.add(btnInformes);
        btnCaja.setBounds(0,   0, barraVertical.getWidth(),50);
        btnClientes.setBounds(0,   50, barraVertical.getWidth(),50);
        btnProveedores.setBounds(0,   100, barraVertical.getWidth(),50);
        btnInformes.setBounds(0,   150, barraVertical.getWidth(),50);
        
        pack();
    }//GEN-LAST:event_administracionbtnActionPerformed

    private void salir2btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir2btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_salir2btnActionPerformed

    private void alimentacionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimentacionbtnActionPerformed
        barraVertical.removeAll();
        barraVertical.repaint();
        barraVertical.add(btnMenues);
        barraVertical.add(btnRacion);
        barraVertical.add(btnInsumosAlimentacion);
        btnMenues.setBounds(0,   0, barraVertical.getWidth(),50);
        btnRacion.setBounds(0,   50, barraVertical.getWidth(),50);
        btnInsumosAlimentacion.setBounds(0,   100, barraVertical.getWidth(),50);
        pack();
    }//GEN-LAST:event_alimentacionbtnActionPerformed


    private void animalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalbtnActionPerformed
        barraVertical.removeAll();
        barraVertical.repaint();
        barraVertical.add(btnServicio);
        barraVertical.add(btnPrenies);
        barraVertical.add(btnParto);
        btnServicio.setBounds(0,   0, barraVertical.getWidth(),50);
        btnPrenies.setBounds(0,   50, barraVertical.getWidth(),50);
        btnParto.setBounds(0,   100, barraVertical.getWidth(),50);
        pack();
    }//GEN-LAST:event_animalbtnActionPerformed

    private void salir1btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir1btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_salir1btnActionPerformed

    private void sanidadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanidadbtnActionPerformed
        barraVertical.removeAll();
        barraVertical.repaint();
        barraVertical.add(btnTratamiento);
        barraVertical.add(btnDosis);
        barraVertical.add(btnInsumosSanidad);
        btnTratamiento.setBounds(0,   0, barraVertical.getWidth(),50);
        btnDosis.setBounds(0,   50, barraVertical.getWidth(),50);
        btnInsumosSanidad.setBounds(0,   100, barraVertical.getWidth(),50);
        pack();
    }//GEN-LAST:event_sanidadbtnActionPerformed
      
    /**
      *@param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Marco().setVisible(true);
            }
        });
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administracionbtn;
    private javax.swing.JButton alimentacionbtn;
    private javax.swing.JButton animalbtn;
    private javax.swing.JToolBar barraHorizontal;
    private javax.swing.JToolBar barraVertical;
    public static javax.swing.JPanel contenidoCentral;
    private javax.swing.JButton granjabtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JButton salir1btn;
    private javax.swing.JButton salir2btn;
    private javax.swing.JButton sanidadbtn;
    // End of variables declaration//GEN-END:variables
   
    
    // botones barra vertical opcion "GRANJA"
    JButton btnCorrales = new JButton("CORRALES");
   JButton btnMajadas = new JButton("MAJADAS");
    JButton btnInsumos = new JButton("INSUMOS");
     
    // botones barra vertical opcion "ALIMENTACION"
    JButton btnMenues = new JButton("MENUES");
    JButton btnRacion = new JButton("RACION");
    JButton btnInsumosAlimentacion = new JButton("INSUMOS");

     // botones barra vertical opcion "SANIDAD"
    JButton btnTratamiento = new JButton("TRATAMIENTOS");
    JButton btnDosis = new JButton("DOSIS");
    JButton btnInsumosSanidad = new JButton("INSUMOS");
    
     // botones barra vertical opcion "ADMINSTRACION"
    JButton btnCaja = new JButton("CAJA");
    JButton btnClientes = new JButton("CLIENTES");
    JButton btnProveedores = new JButton("PROVEEDORES");
    JButton btnInformes = new JButton("INFORMES");
    
     // botones barra vertical opcion "ANIMAL"
    JButton btnServicio = new JButton("SERVICIOS");
    JButton btnPrenies = new JButton("PRENIES");
    JButton btnParto = new JButton("PARTOS");
    
    
}
