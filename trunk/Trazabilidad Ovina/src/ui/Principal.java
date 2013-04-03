package ui;

import java.awt.event.MouseEvent;
import javax.swing.JTree.*;
import javax.swing.JMenuItem;
import java.awt.Image;
import javax.swing.JPopupMenu;
import java.awt.Toolkit;
import java.awt.Point;

public class Principal extends javax.swing.JFrame {

        public Principal() {
        initComponents();
        Image img = Toolkit.getDefaultToolkit().getImage("iconos/oveja.png");
        this.setIconImage(img);
        iniciarBarra();

      ovejaAltaPartoBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        AltaOvejaParto c = new AltaOvejaParto();
        panelPrincipal.add(c);
        c.setVisible(true);
        c.setBounds(0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight());
        ovejaPopup.setVisible(false);
        ovejasAltaPopup.setVisible(false);
        pack();
            }
        });


        ovejasAltaBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        ovejasAltaPopup.setLocation(loc.x+100,loc.y);
        ovejasAltaPopup.setVisible(true);
        pack();
            }
        });


        ovejasBtn.addMouseListener(new java.awt.event.MouseListener() {
        public void mouseClicked(MouseEvent e) {
            }
        public void mousePressed(MouseEvent e) {
            ovejaPopup.setLocation(loc);
            ovejaPopup.setVisible(true);
            //ovejasAltaPopup.setLocation(loc);
            //ovejasAltaPopup.setVisible(true);
            }
        public void mouseReleased(MouseEvent e) {
            }
        public void mouseEntered(MouseEvent e) {
            }
        public void mouseExited(MouseEvent e) {
            }
        });


         salirBtn.addMouseListener(new java.awt.event.MouseListener() {
        public void mouseClicked(MouseEvent e) {
            }
        public void mousePressed(MouseEvent e) {
          //cerrar la ventana
            }
        public void mouseReleased(MouseEvent e) {
            }
        public void mouseEntered(MouseEvent e) {
            }
        public void mouseExited(MouseEvent e) {
            }
        });



        }
  
 private void iniciarBarra() {
   //botones de la barra
   this.jToolBar1.setOrientation(1);
   this.jToolBar1.setLayout(null);
   this.jToolBar1.add(ovejasBtn);
   this.jToolBar1.add(alimentacionBtn);
   this.jToolBar1.add(sanidadBtn);
   this.jToolBar1.add(granjaBtn);
   this.jToolBar1.add(administracionBtn);
   this.jToolBar1.add(configuracionBtn);
   this.jToolBar1.add(salirBtn);
   this.ovejasBtn.setBounds(0,0,this.jToolBar1.getWidth(), 30);
   this.alimentacionBtn.setBounds(0,30,this.jToolBar1.getWidth(), 30);
   this.sanidadBtn.setBounds(0,60,this.jToolBar1.getWidth(), 30);
   this.granjaBtn.setBounds(0,90,this.jToolBar1.getWidth(), 30);
   this.administracionBtn.setBounds(0,120,this.jToolBar1.getWidth(), 30);
   this.configuracionBtn.setBounds(0,150,this.jToolBar1.getWidth(), 30);
   this.salirBtn.setBounds(0,180,this.jToolBar1.getWidth(), 30);

   //menu de ovejas
   this.ovejaPopup.setLocation(this.panelPrincipal.getLocation().x,this.panelPrincipal.getLocation().y);
   this.panelPrincipal.add(ovejaPopup);
   this.panelPrincipal.add(ovejasAltaPopup);

   //menu de alta ovejas
   this.ovejaPopup.add(ovejasAltaBtn);
   this.ovejaPopup.add(ovejasBajaBtn);
   this.ovejaPopup.add(ovejasModificaBtn);
   this.ovejaPopup.add(ovejasObservaBtn);

   //botones alta oveja
   this.ovejasAltaPopup.add(ovejaAltaPartoBtn);
   this.ovejasAltaPopup.add(ovejaAltaCompraBtn);
   
   //menu baja ovejas

   //menu modificacion ovejas
   
    //menu baja ovejas


   
   

     pack();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jButton1 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trazabilidad Ovina");
        setBackground(new java.awt.Color(255, 204, 153));
        setForeground(new java.awt.Color(255, 204, 153));
        setIconImages(getIconImages());
        setLocationByPlatform(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPrincipal.setAutoscrolls(true);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.setToolTipText("Barra de Menu ");
        jToolBar1.setAlignmentX(0.0F);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setLabel("Archivo");
        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("Archivo\n");

        jMenu2.setLabel("Ovejas");
        jMenuBar1.add(jMenu2);

        jMenu3.setLabel("Alimentacion");
        jMenuBar1.add(jMenu3);

        jMenu4.setLabel("Sanidad");
        jMenuBar1.add(jMenu4);

        jMenu5.setLabel("Gastos");
        jMenuBar1.add(jMenu5);

        jMenu6.setLabel("Ayuda");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(575, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        ovejaPopup.setVisible(false);
        ovejasAltaPopup.setVisible(false);
        loc = new Point(new Integer(this.getLocation().x+this.panelPrincipal.getLocation().x),
                       new Integer (this.getLocation().y+this.panelPrincipal.getLocation().y)+70);
    }//GEN-LAST:event_formComponentMoved


    private void ovejasBtnEntre(java.awt.event.MouseEvent evt) {
         ovejaPopup.setVisible(true);
         pack();
       }

    private void ovejasBtnSale(java.awt.event.MouseEvent evt) {
         ovejaPopup.setVisible(false);
         pack();
       }

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                              }
        });
    }


   //punto de ubicacion
   public Point loc;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

   //botones de la barra
    public javax.swing.JButton ovejasBtn = new javax.swing.JButton("Ovejas");
    public javax.swing.JButton alimentacionBtn = new javax.swing.JButton("Alimentacion");
    public javax.swing.JButton sanidadBtn = new javax.swing.JButton("Sanidad");
    public javax.swing.JButton granjaBtn = new javax.swing.JButton("Granja");
    public javax.swing.JButton administracionBtn = new javax.swing.JButton("Administracion");
    public javax.swing.JButton configuracionBtn = new javax.swing.JButton("Configuracion");
    public javax.swing.JButton salirBtn = new javax.swing.JButton("Salir");

     //Botones del menu ovejas
    public javax.swing.JButton ovejasAltaBtn = new javax.swing.JButton("Alta Ovejas");
    public javax.swing.JButton ovejasBajaBtn = new javax.swing.JButton("Baja Ovejas");
    public javax.swing.JButton ovejasModificaBtn = new javax.swing.JButton("Modificacion Ovejas");
    public javax.swing.JButton ovejasObservaBtn = new javax.swing.JButton("Obserbacion Ovejas");





    // menus de nivel 1
    public javax.swing.JPopupMenu ovejaPopup = new JPopupMenu();
    public javax.swing.JPopupMenu alimentacionPopup = new JPopupMenu();
    public javax.swing.JPopupMenu sanidadPopup = new JPopupMenu();
    public javax.swing.JPopupMenu granjaPopup = new JPopupMenu();
    public javax.swing.JPopupMenu administracionPopup = new JPopupMenu();
    public javax.swing.JPopupMenu configuracionPopup = new JPopupMenu();

    //menu de nivel 2
    //menu ovejaPopup
    public javax.swing.JPopupMenu ovejasAltaPopup =new JPopupMenu();
    public javax.swing.JPopupMenu ovejasBajaPopup =new JPopupMenu();
    public javax.swing.JPopupMenu ovejasPreniesPopup =new JPopupMenu();
    public javax.swing.JPopupMenu ovejasServicioPopup =new JPopupMenu();
    //menu alimentacionPopup
    public javax.swing.JPopupMenu alimentacionMenuPopup =new JPopupMenu();
    public javax.swing.JPopupMenu alimentacionAplicacionPopup =new JPopupMenu(); 
    public javax.swing.JPopupMenu alimentacionPlanPopup =new JPopupMenu();
    public javax.swing.JPopupMenu alimentacionParcelasPopup =new JPopupMenu();
    //menu sanidadPopup
    public javax.swing.JPopupMenu sanidadTratamientoPopup =new JPopupMenu();
    public javax.swing.JPopupMenu saidadPlanPopup =new JPopupMenu();
    public javax.swing.JPopupMenu sanidadAplicacionPopup =new JPopupMenu();
    //menu granjaPopup
    public javax.swing.JPopupMenu granjaCorralPopup =new JPopupMenu();
    public javax.swing.JPopupMenu granjaMajadaPopup =new JPopupMenu();
    public javax.swing.JPopupMenu granjaRodeosPopup =new JPopupMenu();
    public javax.swing.JPopupMenu granjaLechePopup =new JPopupMenu();
    //menu administracionPopup
    public javax.swing.JPopupMenu administracionGastosPopup =new JPopupMenu();
    public javax.swing.JPopupMenu administracionStockPopup =new JPopupMenu();
    public javax.swing.JPopupMenu administracionFormulariosPopup =new JPopupMenu();
    //menu configuracionPopup
    public javax.swing.JPopupMenu configuracionBasePopup =new JPopupMenu();
    public javax.swing.JPopupMenu configuracionUserPopup =new JPopupMenu();



    //menu de nivel 3 ovejaAltaPopup
    public javax.swing.JButton ovejaAltaPartoBtn = new javax.swing.JButton("Alta Ovejas Parto");
    public javax.swing.JButton ovejaAltaCompraBtn = new javax.swing.JButton("Alta Ovejas Compra");
   
    public javax.swing.JButton ovejaBajaMuerteBtn = new javax.swing.JButton("Baja Ovejas Muerte");
    public javax.swing.JButton ovejaBajaVentaBtn = new javax.swing.JButton("Baja Ovejas Venta");

   

}



