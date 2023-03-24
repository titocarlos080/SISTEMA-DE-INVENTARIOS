
package Vista;

import Database.conectorDB;
import java.awt.BorderLayout;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hp
 */
public class Index extends javax.swing.JFrame {
   

    public Index(boolean sec, String usuarioNombre) {
        if (sec) {
            initComponents();
            personañizarIconos();
            lblNombreUsuario.setText(usuarioNombre);
            this.setVisible(true);

        } else {
            inicioSeccion in = new inicioSeccion();
            in.setVisible(true);

        }

    }

    public Index() {

        inicioSeccion in = new inicioSeccion();
        in.setVisible(true);
        this.dispose();
        this.setVisible(false);

    }

    // -----------FUNCIONES----------------------------
    private void cambiarPanelPrincipal(JPanel panelAPoner) {
        pnlPrincipal.removeAll();
        panelAPoner.setSize(pnlPrincipal.getSize());
        panelAPoner.setLocation(0, 0);
        pnlPrincipal.add(panelAPoner, BorderLayout.CENTER);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
    }

    private void personañizarIconos() {
        // ImageIcon iconoInv = new
        // ImageIcon(ClassLoader.getSystemResource("iconos/inventario-disponible.png"));
        // ImageIcon iconoEscaldo = new
        // ImageIcon(iconoInv.getImage().getScaledInstance(menuInventario.getWidth() /
        // 2, menuInventario.getHeight(), Image.SCALE_SMOOTH));
        // menuInventario.setIcon(iconoEscaldo);
        ImageIcon icono = new ImageIcon(ClassLoader.getSystemResource("images/bienes.png"));
        Image imagen = icono.getImage();
        System.out.println(lblfoto.getWidth() + "  " + lblfoto.getHeight());

        ImageIcon iconoEscalado = new ImageIcon(
                imagen.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_SMOOTH));
        lblfoto.setIcon(iconoEscalado);

        this.setIconImage(imagen);

        this.setLocationRelativeTo(null);
        this.setSize(1200, 800);
    }
    // -----------------------------------------------------------------------

    public ResultSet consultaBaseDeDatos(String SQL) {
        ResultSet respueta = null;
        conectorDB conector = new conectorDB();
        Connection con = conector.concectar();
        try {
            respueta = con.prepareStatement(SQL).executeQuery();

        } catch (SQLException ex) {

            System.out.println(ex);
        }
        return respueta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnOpciones = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 102));
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(1312, 903));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(93, 141, 132));
        pnlPrincipal.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.hoverBorderColor"));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 841, Short.MAX_VALUE)
        );

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 6, 1140, 841));

        pnlOpciones.setBackground(new java.awt.Color(93, 141, 132));
        pnlOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vender_ico.png"))); // NOI18N
        jButton1.setText("VENDER");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 329, 103));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo_cliente_ico.png"))); // NOI18N
        jButton2.setText("REGISTRAR CLIENTE");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 116));

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion_ico.png"))); // NOI18N
        jButton3.setText("CERRAR SECCION");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 330, 120));

        getContentPane().add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, 640));

        lblfoto.setText(" ");
        lblfoto.setToolTipText("click para cambiar imagen");
        lblfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblfotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblfotoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblfotoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblfotoMouseReleased(evt);
            }
        });
        lblfoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblfotoKeyPressed(evt);
            }
        });
        getContentPane().add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 22, 150, 120));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(0, 51, 51));
        lblNombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estadoUsuario.png"))); // NOI18N
        getContentPane().add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 375, 11));

        jMenuBar1.setBackground(java.awt.SystemColor.controlShadow);
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setMargin(new java.awt.Insets(10, 5, 30, 0));
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(404, 50));

        jMenu1.setBackground(new java.awt.Color(255, 255, 0));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 0), new java.awt.Color(51, 102, 255), new java.awt.Color(102, 153, 0), java.awt.Color.black));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        jMenu1.setText("Cuenta");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(180, 20));
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nueva_cuenta_ico.png"))); // NOI18N
        jMenuItem1.setText("Administar");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        menuInventario.setBackground(new java.awt.Color(255, 255, 0));
        menuInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 0), new java.awt.Color(51, 102, 255), new java.awt.Color(102, 153, 0), java.awt.Color.black));
        menuInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventario_ico.png"))); // NOI18N
        menuInventario.setText("Inventarios");
        menuInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInventario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuInventario.setInheritsPopupMenu(true);
        menuInventario.setPreferredSize(new java.awt.Dimension(200, 20));

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ver_inventario_ico.png"))); // NOI18N
        jMenuItem3.setText("Ver ");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuInventario.add(jMenuItem3);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_producto_ico.png"))); // NOI18N
        jMenuItem5.setText("Nuevo Producto");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuInventario.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categorias_ico.png"))); // NOI18N
        jMenuItem6.setText("Categorias");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuInventario.add(jMenuItem6);

        jMenuBar1.add(menuInventario);

        jMenu2.setBackground(new java.awt.Color(255, 255, 0));
        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 0), new java.awt.Color(51, 102, 255), new java.awt.Color(102, 153, 0), java.awt.Color.black));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas_ico.png"))); // NOI18N
        jMenu2.setText("Ventas");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenu2.setMinimumSize(new java.awt.Dimension(160, 80));
        jMenu2.setPreferredSize(new java.awt.Dimension(180, 20));

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reportes_del_dia_ico.png"))); // NOI18N
        jMenuItem4.setText("Reportes del dia");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mejor-vendido_ico.png"))); // NOI18N
        jMenuItem2.setText("Producto mas vendido");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        btnOpciones.setBackground(new java.awt.Color(255, 255, 0));
        btnOpciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 0), new java.awt.Color(51, 102, 255), new java.awt.Color(102, 153, 0), java.awt.Color.black));
        btnOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuraciones.png"))); // NOI18N
        btnOpciones.setText("Opciones");
        btnOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnOpciones.setMargin(new java.awt.Insets(3, 20, 3, 20));
        btnOpciones.setPreferredSize(new java.awt.Dimension(180, 20));
        jMenuBar1.add(btnOpciones);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

        cambiarPanelPrincipal(new Vender());
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed

        cambiarPanelPrincipal(new UsuariosVendedor());
        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        cambiarPanelPrincipal(new Inventario());

        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
        cambiarPanelPrincipal(new ProductoVista());
        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
cambiarPanelPrincipal(new ClenteVista());
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed

        int res = JOptionPane.showInternalConfirmDialog(null, "ESTAS SEGURO DE CERRAR SECCION!");
        if (res == 0) {
            this.dispose();
            new inicioSeccion().setVisible(true);
        }

        System.out.println(res);
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton3ActionPerformed

    private void lblfotoKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_lblfotoKeyPressed

        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoKeyPressed

    private void lblfotoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblfotoMouseClicked
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png,jpg & gif", "jpg", "png", "gif");
        file.addChoosableFileFilter(filter);
        int respuesta = file.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String path = file.getSelectedFile().getPath();
            ImageIcon icono = new ImageIcon(path);
            Image imagen = icono.getImage();
            ImageIcon imagenIco = new ImageIcon(
                    imagen.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_SMOOTH));
            lblfoto.setIcon(imagenIco);
            JOptionPane.showMessageDialog(null, path);
        }
        JOptionPane.showMessageDialog(null, respuesta);
        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoMouseClicked

    private void lblfotoMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblfotoMouseReleased
        System.out.println("4");
        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoMouseReleased

    private void lblfotoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblfotoMouseEntered

    
        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoMouseEntered

    private void lblfotoMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblfotoMousePressed

        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoMousePressed

    private void lblfotoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblfotoMouseExited

       
        // TODO add your handling code here:
    }// GEN-LAST:event_lblfotoMouseExited

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
        cambiarPanelPrincipal(new CategoriaVista());

        // TODO add your handling code here:
    }// GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jMenu1KeyPressed
        // TODO add your handling code here:
    }// GEN-LAST:event_jMenu1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Index index= new Index(false, "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnOpciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables

}
