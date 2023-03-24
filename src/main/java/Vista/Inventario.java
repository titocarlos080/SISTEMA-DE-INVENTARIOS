package Vista;

import Database.conectorDB;
import extras.DtablaInventarios;
import extras.ImgTable;
import java.time.Clock;
import java.util.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Segment;
import modelo.Categoria;
import modelo.Proveedor;

/**
 *
 * @author hp
 */
public class Inventario extends javax.swing.JPanel {

    public Inventario() {

        initComponents();

        llenarTablaProductos();
        tamañoTabla();
        llenarBox();
    }

    private void llenarBox() {

        String sql = "SELECT DESCRIPCION FROM CATEGORIA";
        Connection cn = new conectorDB().concectar();
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {

                boxCategorias.addItem(res.getString("DESCRIPCION"));
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

    }

    private void tamañoTabla() {

        tblProductos.setSize(this.getWidth(), (int) ((0.7) * this.getHeight()));
    }

    private void llenarTablaProductos() {

        tblProductos.setDefaultRenderer(Object.class, new ImgTable());

        conectorDB conector = new conectorDB();
        Connection con = conector.concectar();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT CODIGO,NOMBRE,CANTIDAD,PRECIO,FOTO,DESCRIPCION FROM PRODUCTO,CATEGORIA WHERE ID=IDCATEGORIA";
            ResultSet Respuesta = stmt.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
            model.setRowCount(0);
            Integer i = 1;
            while (Respuesta.next()) {
                Object Producto[] = new Object[7];
                Producto[0] = (Object) i.toString();
                Producto[1] = Respuesta.getString("CODIGO");
                Producto[2] = Respuesta.getString("NOMBRE");
                Producto[3] = String.valueOf(Respuesta.getInt("CANTIDAD"));
                Producto[4] = String.valueOf(Respuesta.getDouble("PRECIO"));
                Producto[5] = null;//PARA IMAGEN
                Producto[6] = Respuesta.getString("DESCRIPCION");
                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                InputStream isdatos = Respuesta.getBinaryStream("FOTO");

                try {

                    if (isdatos != null) {
                        ouput.writeBytes(isdatos.readAllBytes());
                        ImageIcon im = new ImageIcon(ouput.toByteArray());
                        JLabel lbl = new JLabel();
                        lbl.setSize(64, 32);
                        ImageIcon imScl = new ImageIcon(im.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
                        lbl.setIcon(imScl);
                        Producto[5] = lbl;
                    } else {
                        JLabel lbl = new JLabel("NO-IMAGE");
                        lbl.setForeground(Color.RED);
                        lbl.setBackground(Color.BLUE);
                        lbl.setSize(64, 32);
                        Producto[5] = lbl;
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }
                i++;
                model.addRow(Producto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex + "En productos");
        }

    }

    private void llenarTablaProductosFiltradoPorCategoria(Categoria categoria) {
        tblProductos.setDefaultRenderer(Object.class, new ImgTable());

        conectorDB conector = new conectorDB();
        Connection con = conector.concectar();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT CODIGO,NOMBRE,CANTIDAD,PRECIO,FOTO,DESCRIPCION FROM PRODUCTO,CATEGORIA WHERE ID=IDCATEGORIA AND DESCRIPCION=" + '"' + categoria.getDescripcion() + '"';
            ResultSet Respuesta = stmt.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
            model.setRowCount(0);
            Integer i = 1;
            while (Respuesta.next()) {
                Object Producto[] = new Object[7];
                Producto[0] = (Object) i.toString();
                Producto[1] = Respuesta.getString("CODIGO");
                Producto[2] = Respuesta.getString("NOMBRE");
                Producto[3] = String.valueOf(Respuesta.getInt("CANTIDAD"));
                Producto[4] = String.valueOf(Respuesta.getDouble("PRECIO"));
                Producto[5] = null;//PARA IMAGEN
                Producto[6] = Respuesta.getString("DESCRIPCION");
                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                InputStream isdatos = Respuesta.getBinaryStream("FOTO");

                try {

                    if (isdatos != null) {
                        ouput.writeBytes(isdatos.readAllBytes());
                        ImageIcon im = new ImageIcon(ouput.toByteArray());
                        JLabel lbl = new JLabel();
                        lbl.setSize(64, 32);
                        ImageIcon imScl = new ImageIcon(im.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
                        lbl.setIcon(imScl);
                        lbl.setBackground(Color.RED);
                        Producto[5] = lbl;
                    } else {
                        JLabel lbl = new JLabel("NO-IMAGE");
                        lbl.setSize(64, 32);
                        lbl.setForeground(Color.RED);
                        lbl.setBackground(Color.YELLOW);

                        Producto[5] = lbl;
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }

                model.addRow(Producto);
                i++;
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex + "En productos");
        }
    }

    private void llenarTablaProductosFiltradoPorProveedor(Proveedor proveedor) {
//        tblProductos.setDefaultRenderer(Object.class, new ImgTable());
//
//        conectorDB conector = new conectorDB();
//        Connection con = conector.concectar();
//        try {
//            String sql = "SELECT CODIGO,NOMBRE,CANTIDAD,PRECIO,FOTO FROM PRODUCTO,CATEGORIA WHERE ID=IDCATEGORIA AND DESCRIPCION=?";
//
//            PreparedStatement stmt = con.prepareStatement(sql);
//             stmt.setString(1,categoria.getDescripcion());
//            ResultSet Respuesta = stmt.executeQuery(sql);
//            DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
//             model.setRowCount(0);
//            while (Respuesta.next()) {
//                Object Producto[] = new String[5];
//                Producto[0] = String.valueOf(Respuesta.getInt("CODIGO"));
//                Producto[1] = Respuesta.getString("NOMBRE");
//                Producto[2] = String.valueOf(Respuesta.getInt("CANTIDAD"));
//                Producto[3] = String.valueOf(Respuesta.getDouble("PRECIO"));
//
//                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
//                InputStream isdatos = Respuesta.getBinaryStream("FOTO");
//                JLabel lbl = null;
//                try {
//
//                    if (isdatos != null) {
//                        ouput.writeBytes(isdatos.readAllBytes());
//                        ImageIcon im = new ImageIcon(ouput.toByteArray());
//
//                        lbl = new JLabel(im);
//
//                        model.setValueAt(lbl, model.getRowCount() - 1, 4);
//                    } else {
//                        Producto[4] = "NO IMG";
//                    }
//
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, "Error: " + ex);
//                }
//                model.addRow(Producto);
//
//            }
//
//            stmt.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex + "En productos");
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOp = new javax.swing.JPopupMenu();
        opcionEditar = new javax.swing.JMenuItem();
        opcionInformacion = new javax.swing.JMenuItem();
        opAyuda = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblFotoProducto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxProveedor = new javax.swing.JComboBox<>();
        boxCategorias = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbltitulo = new javax.swing.JLabel();

        opcionEditar.setText("EDITAR");
        opcionEditar.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                opcionEditarMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        opcionEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarMouseClicked(evt);
            }
        });
        opcionEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionEditarActionPerformed(evt);
            }
        });
        opcionEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                opcionEditarKeyPressed(evt);
            }
        });
        menuOp.add(opcionEditar);

        opcionInformacion.setText("INFORMACION");
        opcionInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionInformacionMouseClicked(evt);
            }
        });
        opcionInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionInformacionActionPerformed(evt);
            }
        });
        menuOp.add(opcionInformacion);

        opAyuda.setText("Ayuda");
        menuOp.add(opAyuda);

        setBackground(new java.awt.Color(93, 141, 132));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO", "IMAGEN", "CATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setComponentPopupMenu(menuOp);
        tblProductos.setName(""); // NOI18N
        tblProductos.setRowHeight(35);
        tblProductos.setShowHorizontalLines(true);
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
            tblProductos.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 960, 470));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("INVENTARIOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 250, 50));

        lblFotoProducto.setBackground(new java.awt.Color(51, 0, 255));
        add(lblFotoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 110, 130));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categorias_ico.png"))); // NOI18N
        jLabel2.setText("CATEGORIA");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 120, -1));

        boxProveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- todos los proveedores --", "prov 1", "prov 2", "prov 3" }));
        boxProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boxProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxProveedorItemStateChanged(evt);
            }
        });
        boxProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxProveedorKeyPressed(evt);
            }
        });
        add(boxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 230, 34));

        boxCategorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- todas las categorias --" }));
        boxCategorias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boxCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxCategoriasItemStateChanged(evt);
            }
        });
        boxCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxCategoriasKeyPressed(evt);
            }
        });
        add(boxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, 34));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proveedor_ico.png"))); // NOI18N
        jLabel4.setText("PROVEEDOR");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 130, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar_inventario_ico.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, -1, -1));

        lbltitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(0, 0, 0));
        lbltitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagen_header_fondo.jpg"))); // NOI18N
        lbltitulo.setText("INVENTARIOS");
        add(lbltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 960, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void boxProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxProveedorKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_boxProveedorKeyPressed

    private void boxCategoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxCategoriasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoriasKeyPressed

    private void boxCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxCategoriasItemStateChanged
        switch (evt.getStateChange()) {
            case ItemEvent.SELECTED -> {
                if (boxCategorias.getSelectedIndex() == 0) {
                    llenarTablaProductos();
                } else {
                    Categoria categoria = new Categoria();
                    categoria.setDescripcion(evt.getItem().toString().trim());
                    llenarTablaProductosFiltradoPorCategoria(categoria);

                }
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoriasItemStateChanged

    private void boxProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxProveedorItemStateChanged
        switch (evt.getStateChange()) {
            case ItemEvent.SELECTED:
                JOptionPane.showMessageDialog(null, "\n CATEGORIA: " + boxCategorias.getSelectedItem() + "\n PROVEEDOR: " + evt.getItem() + "\n");
                break;
            case ItemEvent.DESELECTED:

                break;
            default:

        }

// TODO add your handling code here:
    }//GEN-LAST:event_boxProveedorItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date date = new Date();
        Locale locale = new Locale("spanish");

        Calendar calendar = new GregorianCalendar();
        JOptionPane.showMessageDialog(null, calendar);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void opcionEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opcionEditarKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_opcionEditarKeyPressed

    private void opcionEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarMouseClicked

        System.out.println("hola buen!!");
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionEditarMouseClicked

    private void opcionEditarMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_opcionEditarMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionEditarMenuKeyPressed

    private void opcionEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionEditarActionPerformed

     
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionEditarActionPerformed
  
    private void opcionInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionInformacionMouseClicked

        // TODO add your handling code here:

    }//GEN-LAST:event_opcionInformacionMouseClicked

    private void opcionInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionInformacionActionPerformed
     
   
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionInformacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategorias;
    private javax.swing.JComboBox<String> boxProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFotoProducto;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JPopupMenu menuOp;
    private javax.swing.JMenuItem opAyuda;
    private javax.swing.JMenuItem opcionEditar;
    private javax.swing.JMenuItem opcionInformacion;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables

}
